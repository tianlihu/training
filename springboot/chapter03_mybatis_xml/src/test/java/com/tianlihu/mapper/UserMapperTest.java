package com.tianlihu.mapper;

import com.tianlihu.constants.Sex;
import com.tianlihu.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
@Rollback(false)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void findAll() {
        List<User> users = userMapper.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void findById() {
        User user = userMapper.findById(1L);
        System.out.println(user);
    }

    @Test
    public void save() {
        User user = new User();
        user.setName("王五");
        user.setSex(Sex.FEMALE);
        user.setPassword("1234567");
        userMapper.save(user);
    }

    @Test
    public void update() {
        User user = userMapper.findById(1L);
        user.setPassword("654321");
        userMapper.update(user);
    }

    @Test
    public void delete() {
        userMapper.delete(1L);
    }
}