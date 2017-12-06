package com.tikdik.message;

import lombok.Data;

@Data
public class SecondMessage extends Message{

    private String title;

    private int number;

    public SecondMessage() {
        setTag("second");
    }

    public SecondMessage(String title, int number) {
        this();
        this.number = number;
        this.title = title;
    }
}
