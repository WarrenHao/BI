package com.yupi.springbootinit.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yupi.springbootinit.model.entity.Post;
import java.util.Date;
import java.util.List;
import com.yupi.springbootinit.model.entity.Chart;
import com.yupi.springbootinit.model.entity.User;

/**
 * 帖子数据库操作
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
 */
public interface PostMapper extends BaseMapper<Post> {

    /**
     * 查询帖子列表（包括已被删除的数据）
     */
    List<Post> listPostWithDelete(Date minUpdateTime);

    /**
    * @author vhaow
    * @description 针对表【chart(图表表)】的数据库操作Mapper
    * @createDate 2024-02-15 01:31:39
    * @Entity generator.domain.Chart
    */
    interface ChartMapper extends BaseMapper<Chart> {

    }

    /**
    * @author vhaow
    * @description 针对表【user(用户)】的数据库操作Mapper
    * @createDate 2024-02-15 01:31:39
    * @Entity generator.domain.User
    */
    interface UserMapper extends BaseMapper<User> {

    }
}




