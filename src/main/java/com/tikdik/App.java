package com.tikdik;

import com.alibaba.fastjson.JSON;
import com.tikdik.annotation.MessageTag;
import com.tikdik.message.FirstMessage;
import com.tikdik.message.SecondMessage;

/**
 * Hello world!
 *
 */
public class App 
{
    public static String send(Object message) {
        MessageTag msgTypeSend = message.getClass().getAnnotation(MessageTag.class);
        String msgBodySend = JSON.toJSONString(message);
        return  msgTypeSend.value() + ":" + msgBodySend;
    }

    public static void main( String[] args ) {
        MessageDispatch dispatch = new MessageDispatch();
        //发第一条消息
        Object message = new FirstMessage("zw", 30);
        String msgSend = send(message);
        //接收第一条消息
        dispatch.dispatch(msgSend);

        //发第二条消息
        message = new SecondMessage("ha", 20);
        msgSend = send(message);

        //接收第二条
        dispatch.dispatch(msgSend);
    }
}
