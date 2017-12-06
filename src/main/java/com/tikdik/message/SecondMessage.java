package com.tikdik.message;

import lombok.Data;

@Data
public class SecondMessage extends Message{

    private String tag = "second";

    private String title;

    private int number;

    public SecondMessage() {
    }

    public SecondMessage(String title, int number) {
        this.number = number;
        this.title = title;
    }
}
