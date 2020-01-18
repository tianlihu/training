package com.tianlihu.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tianlihu.User;
import com.tianlihu.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(controllers = UserController.class)
public class UserControllerTest1 {

    @Autowired
    private MockMvc mockMvc;

    @SpyBean
    private UserService userService;

    @BeforeEach
    public void before() {
        // 准备场景
        when(userService.list(3, 2)).thenReturn("用户列表：32");
    }

    @Test
    public void list() throws Exception {
        // 执行程序
        String response = mockMvc.perform(get("/user/list")
                .contentType(MediaType.TEXT_HTML)
                .param("pageNum", "3")
                .param("pageSize", "2"))
                .andDo(print()).andReturn().getResponse().getContentAsString();

        // 验证结果
        Assertions.assertEquals("用户列表：32", response);
    }

    @Test
    public void save() throws Exception {
        // 执行程序
        String response = mockMvc.perform(get("/user/save")
                .contentType(MediaType.TEXT_HTML)
                .param("id", "3")
                .param("name", "张三")
                .param("sex", "1")
                .param("birthday", "2020-01-19"))
                .andDo(print()).andReturn().getResponse().getContentAsString();

        // 验证结果
        Assertions.assertEquals("保存用户成功: 3", response);
    }

    @Test
    public void update() throws Exception {
        User user = getUser();
        ObjectMapper mapper = new ObjectMapper();

        // 执行程序
        String response = mockMvc.perform(get("/user/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(user)))
                .andDo(print()).andReturn().getResponse().getContentAsString();

        // 验证结果
        Assertions.assertEquals("修改用户成功: 3", response);
    }

    private User getUser() {
        User user = new User();
        user.setId(3);
        user.setName("张三");
        user.setSex(1);
        user.setBirthday(new Date());
        return user;
    }
}