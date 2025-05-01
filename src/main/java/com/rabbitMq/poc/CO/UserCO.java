package com.rabbitMq.poc.CO;

import lombok.Data;

@Data
public class UserCO {

    private int id;
    private String name;
    private int age;

    @Override
    public String toString() {
        return "UserCO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
