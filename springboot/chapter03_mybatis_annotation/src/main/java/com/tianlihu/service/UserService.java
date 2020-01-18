package com.tianlihu.service;

import com.tianlihu.entity.User;
import com.tianlihu.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Transactional(readOnly = true)
    public User getById(Long id) {
        return userMapper.findById(id);
    }

    public void save(User user) {
        userMapper.save(user);
    }

    public void update(User user) {
        userMapper.update(user);
    }

    public void delete(Long id) {
        userMapper.delete(id);
    }
}
