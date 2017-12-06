package com.tikdik;

import com.tikdik.annotation.MessageTag;
import com.tikdik.handler.Handler;
import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MessageDispatch {
    private static Map<String, Class> classMap;

    static {
        classMap = new HashMap<>();
        Reflections reflections = new Reflections(Handler.class.getPackage().getName());
        Set<Class<?>> classesList = reflections.getTypesAnnotatedWith(MessageTag.class);
        for (Class classes : classesList) {
            MessageTag messageTag = (MessageTag) classes.getAnnotation(MessageTag.class);
            classMap.put(messageTag.value(), classes);
        }
    }

    public void dispatch(String tag, String data) {
        Class cls = classMap.get(tag);
        Handler handler = null;
        try {
            handler = (Handler) cls.newInstance();
            handler.handle(data);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
