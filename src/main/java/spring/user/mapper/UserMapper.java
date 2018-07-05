package spring.user.mapper;



import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import spring.user.bean.UserBean;

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
