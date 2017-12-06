package com.tikdik.message;

import lombok.Data;

@Data
public class FirstMessage extends Message{

    private String name;

    private int age;

    public FirstMessage() {
        setTag("first");
    }

    public FirstMessage(String name, int age) {
        this();
        this.name = name;
        this.age = age;
    }
}
