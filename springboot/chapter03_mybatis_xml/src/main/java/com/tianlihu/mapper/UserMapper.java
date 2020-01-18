package com.tianlihu.mapper;

import com.tianlihu.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    public List<User> findAll();

    public User findById(Long id);

    public void save(User user);

    public void update(User user);

    public void delete(Long id);
}