package com.tianlihu.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.xstream.XStream;
import com.tianlihu.entity.User;
import com.tianlihu.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class UserController {

//    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/user/find")
    public User findById(Integer id,
                        @RequestParam(defaultValue = "1") Integer pageNum,
                        @RequestParam(defaultValue = "5") Integer pageSize) throws JsonProcessingException {
        try {
            User user = userService.findById(id);
            XStream xStream = new XStream();
            xStream.omitField(User.class, "password");
            log.debug("查询用户方法出错，参数为：id={}, pageNum={}, pageSize={}, 返回值为：{}", id, pageNum, pageSize, xStream.toXML(user));

            ObjectMapper mapper = new ObjectMapper();
            log.debug("查询用户方法出错，参数为：id={}, pageNum={}, pageSize={}, 返回值为：{}", id, pageNum, pageSize, mapper.writeValueAsString(user));

            return user;
        } catch (Exception e) {
            log.error("查询用户方法出错，参数为：id={}, pageNum={}, pageSize={}");
            throw e;
        }
    }

    @RequestMapping("/user/list")
    public List<User> list( @RequestParam(defaultValue = "1") Integer pageNum,
                            @RequestParam(defaultValue = "5") Integer pageSize) {

        return userService.list(pageNum, pageSize);
    }
}
