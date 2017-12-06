package com.tikdik;

import com.alibaba.fastjson.JSON;
import com.tikdik.message.FirstMessage;
import com.tikdik.message.Message;
import com.tikdik.message.SecondMessage;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        MessageDispatch dispatch = new MessageDispatch();
        Message message = new FirstMessage("zw", 30);
        dispatch.dispatch(message.getTag(), JSON.toJSONString(message));
        message = new SecondMessage("ha", 20);
        dispatch.dispatch(message.getTag(), JSON.toJSONString(message));
    }
}
