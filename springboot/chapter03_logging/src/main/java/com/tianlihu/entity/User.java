package com.tianlihu.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class User {

    private Integer id;
    private String name;
    @JsonIgnore
    @XStreamOmitField
    private String password;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GTM+8")
    private Date birthday;
}
