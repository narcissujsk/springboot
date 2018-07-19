package com.example.consumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Consumer {

    @Autowired
    RestTemplate rest;
    @Autowired
    UserService userService;
    @RequestMapping(method = RequestMethod.GET, value = "/usersget")
    public String get() {
        return userService.get();
    }


}

@Service
class UserService {

    @Autowired
    RestTemplate rest;

    @HystrixCommand(fallbackMethod = "fallback")
    public String get() {
        return rest.getForEntity("http://privider-user/users/list", String.class).getBody();
    }

    public String fallback() {
        return "error";
    }


}
