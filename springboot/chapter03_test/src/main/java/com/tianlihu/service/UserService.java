package com.tianlihu.service;

import com.tianlihu.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String list(Integer pageNum, Integer pageSize) {
        return "用户列表：" + pageNum + pageSize;
    }

    public String save(User user) {
        return "保存用户成功: " + user.getId();
    }
}
