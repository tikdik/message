package com.tikdik.message;

import com.tikdik.annotation.MessageTag;
import lombok.Data;

@Data
@MessageTag("second")
public class SecondMessage {

    private String title;

    private int number;

    public SecondMessage() {
    }

    public SecondMessage(String title, int number) {
        this.number = number;
        this.title = title;
    }
}
