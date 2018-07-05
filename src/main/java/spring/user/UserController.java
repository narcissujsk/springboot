package spring.user;



import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.user.bean.UserBean;
import spring.user.mapper.UserMapper;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value="/list")
    @ResponseBody
    public List<UserBean> getUsers() {

        List<UserBean> userList = userMapper.getUsers();

        return userList;

    }

    @ResponseBody
    @RequestMapping(value="/update")
    public List<UserBean> update() {
        UserBean user=new UserBean();
        user.setId(1);
        user.setUserName("updateName");
        user.setPassWord("123");
        user.setCreateTime(new Date());
        userMapper.update(user);
        return userMapper.getUsers();

    }

    @ResponseBody
    @RequestMapping(value="/del")
    public List<UserBean> del(){


        userMapper.del(1);

        return userMapper.getUsers();
    }

    @ResponseBody
    @RequestMapping(value="/add")
    public List<UserBean> add(){

        UserBean user=new UserBean();
        user.setUserName("test");
        user.setPassWord("111");
        user.setCreateTime(new Date());

        userMapper.save(user);
        return userMapper.getUsers();
    }

}