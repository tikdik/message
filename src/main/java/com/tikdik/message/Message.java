package com.tikdik.message;

import lombok.Data;

@Data
public abstract class Message {
    /**
     * 必须有个消息类型，这个类型与消息处理handler的tag相同
     */
    protected String tag;
}
