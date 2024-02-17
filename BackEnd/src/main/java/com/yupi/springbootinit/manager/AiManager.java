package com.yupi.springbootinit.manager;

import com.yupi.springbootinit.common.ErrorCode;
import com.yupi.springbootinit.exception.BusinessException;
import com.yupi.yucongming.dev.client.YuCongMingClient;
import com.yupi.yucongming.dev.common.BaseResponse;
import com.yupi.yucongming.dev.model.DevChatRequest;
import com.yupi.yucongming.dev.model.DevChatResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.File;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 用于对接 AI 平台
 */
@Service
public class AiManager {

    @Resource
    private YuCongMingClient yuCongMingClient;

    /**
     * AI 对话
     *
     * @param modelId
     * @param message
     * @return
     */
    public String doChat(long modelId, String message) {
        DevChatRequest devChatRequest = new DevChatRequest();
        devChatRequest.setModelId(modelId);
        devChatRequest.setMessage(message);
        BaseResponse<DevChatResponse> response = yuCongMingClient.doChat(devChatRequest);
        if (response == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "AI 响应错误");
        }
        System.out.println(response);
        return response.getData().getContent();
    }


//    GML的
    public String doChatGMl(String message){
        String basePath = "src/main/java/com/yupi/springbootinit/manager/py/ChatGml.py";
        File file = new File(basePath);
        String absolutePath = null;
        String result = null;
//       拿到绝对路径
        try{
            absolutePath = file.getCanonicalPath();
//
        }catch (Exception e){
            System.out.println("获取绝对路径失败");
        }
        
        ProcessBuilder processBuilder = new ProcessBuilder("python",absolutePath,message);
        try {
            Process process = processBuilder.start();
//            获取输出
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(), "GBK"));
            String line;
            while ((line = reader.readLine()) != null) {
//                拼接输出,同时控制编码
                result += line;
                result += "\n";
            }
            System.out.println(result);
            // 等待脚本执行完成
//
        }catch (Exception e){
            System.out.println("启动python失败");
        }

        return result;
    }
}
