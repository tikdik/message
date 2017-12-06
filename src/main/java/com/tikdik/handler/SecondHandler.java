package com.tikdik.handler;

import com.alibaba.fastjson.JSON;
import com.tikdik.annotation.MessageTag;
import com.tikdik.message.SecondMessage;

@MessageTag("second")
public class SecondHandler implements Handler{
    @Override
    public void handle(String data) {
        if (data == null || "".equals(data)) {
            return;
        }
        SecondMessage secondMessage = JSON.parseObject(data, SecondMessage.class);
        System.out.println(JSON.toJSONString(secondMessage));
    }
}
