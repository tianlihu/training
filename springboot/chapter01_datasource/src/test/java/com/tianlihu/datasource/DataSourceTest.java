package com.tianlihu.datasource;

import com.tianlihu.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DataSourceTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSource dataSource;

    @Test
    public void list() {
        List<User> users = jdbcTemplate.query("select * from sys_user", new BeanPropertyRowMapper<>(User.class));
        System.out.println(users);
    }

    @Test
    public void dataSource() {
        System.out.println(dataSource.getClass());
    }
}
