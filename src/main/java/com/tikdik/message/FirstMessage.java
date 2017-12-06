package com.tikdik.message;

import lombok.Data;

@Data
public class FirstMessage extends Message{

    private String tag = "first";

    private String name;

    private int age;

    public FirstMessage() {
    }

    public FirstMessage(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
