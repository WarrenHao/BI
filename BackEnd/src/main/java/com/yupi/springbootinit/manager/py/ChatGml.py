# --coding: utf-8--

from zhipuai import ZhipuAI
import time
import sys

MSG = sys.argv[1]

API_KEY = '70d4d58db3651a90df2b6941bb13be35.DeAuphS0I1bVSaKF'


if __name__ == '__main__':

    client = ZhipuAI(api_key=API_KEY) # 填写您自己的APIKey

    response = client.chat.asyncCompletions.create(
    model="glm-4",  # 填写需要调用的模型名称
    messages=[
        {
            'role': 'user',
            'content': '你是一名数据分析师和前端工程师你需要根据我给定的分析目标和数据完成任务，按照以下指定格式生成内容并给出分析结论，而不要输出任何多余的注释，内容需以”【【“开头和结尾：\n【【\n{前端Echarts V5的option配置对象的JSON代码，不能生成开头的 " options = "，而是生成options花括号里面的内容代码，不要生成options的"title"= "chart title"。以及不要生成任何多余的注释，解释，介绍，开头，结尾。生成的Echarts能够合理地将数据进行可视化}\n【【\n{明确的数据分析结论、越详细越好，不要生成多余的注释}'
        },
        {
            'role':'user',
            'content': MSG
        }
        ],
    )
    task_id = response.id
    task_status = ''
    get_cnt = 0
    
    while task_status != 'SUCCESS' and task_status != 'FAILED' and get_cnt <= 40:
        result_response = client.chat.asyncCompletions.retrieve_completion_result(id=task_id)
        task_status = result_response.task_status
        time.sleep(0.6)
        if task_status == 'SUCCESS':
            print(result_response.choices[0].message.content)
        get_cnt += 1
        