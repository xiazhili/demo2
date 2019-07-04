package com.example.demo2;

import com.example.demo2.bean.User;
import com.example.demo2.restful.Result;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@CrossOrigin
@Controller
@SpringBootApplication
public class Demo2Application {

    @GetMapping(value = "home")
    public String show(Model model){
        model.addAttribute("uid","123456789");
        model.addAttribute("name","Jerry");
        return "HomePage";
    }

    @GetMapping("/users")
    @ResponseBody
    public Result<List> userList() {

        Random random = new Random();
        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setId(Long.valueOf(i));
            user.setUsername("夏志丽");
            user.setCity("广州");
            user.setSex("女");
            user.setClassify("bug专家");
            user.setScore(Long.valueOf(random.nextInt(10)));
            user.setExperience(Long.valueOf(random.nextInt(10000)));
            user.setSign("夏夏i");
            user.setWealth(random.nextLong());
            users.add(user);
        }
        Result<List> userResult = new Result<>();
        userResult.setData(users);
        userResult.setCode(0);
        userResult.setCount(users.size());
        return userResult;
    }

    public static void main(String[] args) {
        SpringApplication.run(Demo2Application.class, args);
    }

}
