package com.tianlihu.entity;

import com.tianlihu.constants.Sex;
import lombok.Data;

@Data
public class User {

    private Long id;
    private String name;
    private String password;
    private Sex sex;
}