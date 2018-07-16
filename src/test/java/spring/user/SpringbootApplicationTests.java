package spring.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import spring.user.bean.UserBean;
import spring.user.mapper.UserMapper;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.List;
import org.springframework.http.MediaType;
import org.junit.Assert;
/**
 * @RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！
 * @SpringApplicationConfiguration(classes = SpringBootSampleApplication.class) // 指定我们SpringBoot工程的Application启动类 新版可用@SpringBootTest
 * @WebAppConfiguration // 由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class SpringbootApplicationTests {

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
