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
        Object message = new FirstMessage("zw", 30);
        MessageTag tag = message.getClass().getAnnotation(MessageTag.class);

        dispatch.dispatch(tag.value(), JSON.toJSONString(message));

        message = new SecondMessage("ha", 20);
        tag = message.getClass().getAnnotation(MessageTag.class);

        dispatch.dispatch(tag.value(), JSON.toJSONString(message));
    }
}
