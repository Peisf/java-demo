package com.itcast.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itcast.domain.User;
import com.itcast.domain.VO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/quick")
    public String save(){
        System.out.println("Controller save running...");
        return "success.jsp";
    }

    @RequestMapping("/quick1")
    @ResponseBody
    public String save1() throws JsonProcessingException {
        User user = new User();
        user.setUsername("lisi");
        user.setAge(18);

        //使用json的转换工具将对象转换成json格式字符串在返回
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);
        return json;
    }

    @RequestMapping("/quick2")
    @ResponseBody
    public User save2() {
        User user = new User();
        user.setUsername("lisi2");
        user.setAge(18);
        return user;
    }

    @RequestMapping("/quick3")
    @ResponseBody
    public void save3(String username, int age) {
        System.out.println(username);
        System.out.println(age);
    }
    @RequestMapping("/quick4")
    @ResponseBody
    public void save4(User user) {
        System.out.println(user);
    }

    @RequestMapping("/quick5")
    @ResponseBody
    public void save5(String[] strings) {
        System.out.println(Arrays.asList(strings));
    }

    @RequestMapping("/quick6")
    @ResponseBody
    public void save6(VO vo) {
        System.out.println(vo);
    }
}
