package com.tianlihu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class UserController {

    private static final String PROVIDER_SERVER_URL_PREFIX = "http://eureka-provider";

    @Autowired
    private DiscoveryClient client;
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/user/list1")
    public String list1() {
        StringBuilder builder = new StringBuilder();
        List<ServiceInstance> instances = client.getInstances("eureka-provider");
        for (ServiceInstance instance : instances) {
            builder.append(instance.getHost() + " port:" + instance.getPort() + " service_id:" + instance.getServiceId() + "<br>");
        }
        return builder.toString();
    }

    @RequestMapping("/user/list2")
    public String list2() {
        String result = restTemplate.postForObject(PROVIDER_SERVER_URL_PREFIX + "/user/list", null, String.class);
        return result;
    }
}
