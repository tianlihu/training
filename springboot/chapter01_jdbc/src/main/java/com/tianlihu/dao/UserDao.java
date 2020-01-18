package com.tianlihu.dao;

import com.tianlihu.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> list(String name) {
        String sql = "select * from sys_user where 1=1";
        List<Object> args = new ArrayList<>();
        if (name != null) {
            sql += " and name like concat('%', ?, '%')";
            args.add(name);
        }

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), args.toArray());
    }

    public void save(User user) {
        jdbcTemplate.update("insert into sys_user(name, birthday) values (?, ?)", user.getName(), user.getBirthday());
    }

    public void update(User user) {
        jdbcTemplate.update("update sys_user set name=?, birthday=? where id=?", user.getName(), user.getBirthday(), user.getId());
    }

    public void delete(Integer id) {
        jdbcTemplate.update("delete from sys_user where id=?", id);
    }


    private RowMapper getRowMapper() {
        RowMapper<User> rowMapper = (ResultSet rs, int rowNum) -> {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setBirthday(rs.getDate("birthday"));
            return user;
        };

        return rowMapper;
    }
}
