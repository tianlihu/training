package com.tianlihu.service;

import com.tianlihu.dao.UserDao;
import com.tianlihu.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserDao userDao;

    @Transactional(readOnly = true)
    public List<User> list(String name) {
        return userDao.list(name);
    }

    public void save(User user) {
        userDao.save(user);
    }

    public void update(User user) {
        userDao.update(user);
    }

    public void delete(Integer id) {
        userDao.delete(id);
    }
}
