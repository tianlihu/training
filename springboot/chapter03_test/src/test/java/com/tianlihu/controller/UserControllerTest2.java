package com.tianlihu.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest2 {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void list_get() {
        Map<String, String> params = new HashMap<>();
        params.put("pageNum", "3");
        params.put("pageSize", "5");

        String response = restTemplate.getForObject("/user/list?pageNum={pageNum}&pageSize={pageSize}", String.class, params);
        assertEquals("用户列表：35", response);
    }

    @Test
    public void list_post() {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("pageNum", "3");
        params.add("pageSize", "5");

        HttpHeaders headers = new HttpHeaders();
        headers.add("username", "abcdef");
        HttpEntity httpEntity = new HttpEntity(params, headers);

        String response = restTemplate.postForObject("/user/list",httpEntity, String.class);
        assertEquals("用户列表：35", response);
    }

    @Test
    public void save() {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("id", "3");
        params.add("name", "张三");
        params.add("sex", "1");
        params.add("birthday", "2019-01-19");

        HttpHeaders headers = new HttpHeaders();
        headers.add("username", "abcdef");
        HttpEntity httpEntity = new HttpEntity(params, headers);

        String response = restTemplate.postForObject("/user/save",httpEntity, String.class);
        assertEquals("保存用户成功: 3", response);
    }

    @Test
    public void update() {
        Map<String, String> params = new HashMap<>();
        params.put("id", "3");
        params.put("name", "张三");
        params.put("sex", "1");
        params.put("birthday", "2019-01-19");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("username", "abcdef");
        HttpEntity httpEntity = new HttpEntity(params, headers);

        String response = restTemplate.postForObject("/user/update",httpEntity, String.class);
        assertEquals("修改用户成功: 3", response);
    }
}
