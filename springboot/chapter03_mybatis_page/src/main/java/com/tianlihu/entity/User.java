package com.tianlihu.entity;

import lombok.Data;

@Data
public class User {
    private Long id;

    private String name;

    private String sex;

    private String password;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", sex=").append(sex);
        sb.append(", password=").append(password);
        sb.append("]");
        return sb.toString();
    }
}