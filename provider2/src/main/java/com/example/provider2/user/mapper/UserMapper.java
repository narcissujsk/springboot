package com.example.provider2.user.mapper;


import com.example.provider2.user.bean.UserBean;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper

public interface UserMapper {


    /**
     * 获取所有用户
     *
     * @return
     */
    @Select(value = "select * from users")
    @Results(value = { @Result(column = "user_name", property = "userName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "pass_word", property = "passWord", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIME) })
    List<UserBean> getUsers();

    /**
     * 修改用户信息
     *
     * @param user
     */
    @Update("update users set user_name= #{userName},pass_word=#{passWord},create_time=#{createTime} where id=#{id}")
    void update(UserBean user);

    /**
     * 删除用户
     *
     */
    @Delete("delete from users where id=#{id}")
    void del(int id);

    /**
     * 新增一条用户信息
     *
     * @param user
     */
    @Insert("insert into users(user_name,pass_word,create_time) values(#{userName},#{passWord},#{createTime})")
    void save(UserBean user);

}
