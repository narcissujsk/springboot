package com.example.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Consumer {

    @Autowired
    RestTemplate rest;

    @RequestMapping(method = RequestMethod.GET,value = "/usersget")
    public String get() {
        return rest.getForEntity("http://PRIVIDER-USER/users/list",String.class).getBody();
    }


}
