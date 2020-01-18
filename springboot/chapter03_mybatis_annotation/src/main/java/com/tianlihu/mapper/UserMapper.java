package com.tianlihu.mapper;

import com.tianlihu.constants.Sex;
import com.tianlihu.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    @Select("SELECT * FROM sys_user")
    @Results({
            @Result(property = "name", column = "name"),
            @Result(property = "password", column = "password"),
            @Result(property = "sex", column = "sex", javaType = Sex.class),
    })
    public List<User> findAll();

    @Select("SELECT * FROM sys_user WHERE id=#{id}")
    @Results({
            @Result(property = "name", column = "name"),
            @Result(property = "password", column = "password"),
            @Result(property = "sex", column = "sex", javaType = Sex.class),
    })
    public User findById(Long id);

    @Insert("INSERT INTO sys_user(name,password,sex) VALUES(#{name}, #{password}, #{sex})")
    public void save(User user);

    @Update("UPDATE sys_user SET name=#{name}, password=#{password}, sex=#{sex} WHERE id=#{id}")
    public void update(User user);

    @Delete("DELETE FROM sys_user WHERE id=#{id}")
    public void delete(Long id);
}