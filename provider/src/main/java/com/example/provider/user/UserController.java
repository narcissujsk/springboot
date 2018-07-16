package com.example.provider.user;


import com.netflix.discovery.DiscoveryClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.provider.user.bean.UserBean;
import com.example.provider.user.mapper.UserMapper;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/users")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger("UserController");

    @Autowired
    private UserMapper userMapper;
  //  @Autowired
    DiscoveryClient client;

    @RequestMapping(value = "/list")
    @ResponseBody
    public List<UserBean> getUsers() {

        List<UserBean> userList = userMapper.getUsers();
        logger.info(userList+"");
     //   logger.info("client.getLastSuccessfulHeartbeatTimePeriod() :"+cient.getLastSuccessfulHeartbeatTimePeriod()+"");
      //  logger.info("client.getApplicationInfoManager() :"+ client.getApplicationInfoManager().getInfo()+"");

        return userList;

    }

    @ResponseBody
    @RequestMapping(value = "/update")
    public List<UserBean> update() {
        UserBean user = new UserBean();
        user.setId(1);
        user.setUserName("updateName");
        user.setPassWord("123");
        user.setCreateTime(new Date());
        userMapper.update(user);
        return userMapper.getUsers();

    }

    @ResponseBody
    @RequestMapping(value = "/del")
    public List<UserBean> del() {


        userMapper.del(1);

        return userMapper.getUsers();
    }

    @ResponseBody
    @RequestMapping(value = "/add")
    public List<UserBean> add() {

        UserBean user = new UserBean();
        user.setUserName("test");
        user.setPassWord("111");
        user.setCreateTime(new Date());

        userMapper.save(user);
        return userMapper.getUsers();
    }

}