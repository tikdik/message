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
    public static void main( String[] args ) {

        MessageDispatch dispatch = new MessageDispatch();
        //发第一条消息
        Object message = new FirstMessage("zw", 30);
        MessageTag msgTypeSend = message.getClass().getAnnotation(MessageTag.class);
        String msgBodySend = JSON.toJSONString(message);
        String msgSend = msgTypeSend.value() + ":" + msgBodySend;

        //接收第一条消息
        int split = msgSend.indexOf(":");
        String msgType = msgSend.substring(0, split);
        String msgBody = msgSend.substring(split + 1);

        dispatch.dispatch(msgType, msgBody);

        //发第二条消息
        message = new SecondMessage("ha", 20);
        msgTypeSend = message.getClass().getAnnotation(MessageTag.class);
        msgBodySend = JSON.toJSONString(message);
        msgSend = msgTypeSend.value() + ":" + msgBodySend;

        //接收第二条
        split = msgSend.indexOf(":");
        msgType = msgSend.substring(0, split);
        msgBody = msgSend.substring(split + 1);

        dispatch.dispatch(msgType, msgBody);
    }
}
