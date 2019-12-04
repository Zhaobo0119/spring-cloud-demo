package com.redstar.domain;

/**
 * @date: 2019-03-19 上午 10:49
 * @author: zhaobo0119@outlook.com
 * @Descriptopn:
 */
public class User {

    private long id;
    private String name;
    private int age;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
