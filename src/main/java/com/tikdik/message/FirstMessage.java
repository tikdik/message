package com.tikdik.message;

import com.tikdik.annotation.MessageTag;
import lombok.Data;

@Data
@MessageTag("first")
public class FirstMessage {

    private String name;

    private int age;

    public FirstMessage() {
    }

    public FirstMessage(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
