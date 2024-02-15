package com.yupi.springbootinit.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yupi.springbootinit.model.entity.Chart;
import org.springframework.stereotype.Service;
import com.yupi.springbootinit.service.ChartService;
import com.yupi.springbootinit.mapper.ChartMapper;

/**
* @author vhaow
* @description 针对表【chart(图表表)】的数据库操作Service实现
* @createDate 2024-02-15 01:31:39
*/
@Service
public class ChartServiceImpl extends ServiceImpl<ChartMapper, Chart>
    implements ChartService {

}




