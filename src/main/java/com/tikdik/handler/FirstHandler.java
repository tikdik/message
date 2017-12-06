package com.tikdik.handler;

import com.alibaba.fastjson.JSON;
import com.tikdik.annotation.MessageTag;
import com.tikdik.message.FirstMessage;

@MessageTag("first")
public class FirstHandler implements Handler{
    @Override
    public void handle(String data) {
        if (data == null || "".equals(data)) {
            return;
        }
        FirstMessage firstMessage = JSON.parseObject(data, FirstMessage.class);
        System.out.println(JSON.toJSONString(firstMessage));
    }
}
