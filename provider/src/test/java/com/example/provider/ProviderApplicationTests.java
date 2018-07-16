package com.example.provider;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.example.provider.user.bean.UserBean;
import com.example.provider.user.mapper.UserMapper;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.List;
import org.springframework.http.MediaType;
import org.junit.Assert;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ProviderApplicationTests {

    @Test
    public void contextLoads() {
    }
    @Autowired
    private UserMapper userMapper;

    @Test
    public void getUsers() {
        List<UserBean> user = userMapper.getUsers();
        print(user);
    }

    public void print(Object object){
        System.out.println("\r\n");
        System.out.println("\r\n");
        System.out.println("**********************************************");
        System.out.println(object);
        System.out.println("**********************************************");
        System.out.println("\r\n");
        System.out.println("\r\n");
    }

    @Autowired
    private MockMvc mvc;


    @Test
    public void getUsersList() throws Exception {
        List<UserBean> user = userMapper.getUsers();
        String uri = "/users/list";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        print(content);
        Assert.assertTrue("错误，正确的返回值为200", status == 200);
        // Assert.assertFalse("数据不一致", !user.toString().equals(content));
    }
}
