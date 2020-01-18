package com.tianlihu.service;

import com.tianlihu.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserService {

    public User findById(Integer id) {
        User user = new User();
        user.setId(1);
        user.setName("张三");
        user.setPassword("123456");
        user.setBirthday(new Date());
        return user;
    }

    public List<User> list(Integer pageNum, Integer pageSize) {
        if (pageNum >= 3) {
            throw new RuntimeException("只有两页数据");
        }

        List<User> users = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            User user = new User();
            user.setId(i);
            user.setName("name_" + i);
            user.setPassword("12345_" + i);
            user.setBirthday(new Date());
            users.add(user);
        }
        return users;
    }
}
