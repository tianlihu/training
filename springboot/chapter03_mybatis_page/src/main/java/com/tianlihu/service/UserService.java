package com.tianlihu.service;

import com.github.pagehelper.Page;
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
    public Page<User> selectAll() {
        return userMapper.selectAll();
    }
}
