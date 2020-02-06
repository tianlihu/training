package com.tianlihu.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("service-producer")
public interface UserApi {

    @RequestMapping("/user/list")
    public String list();
}
