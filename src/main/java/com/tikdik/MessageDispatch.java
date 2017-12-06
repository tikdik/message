package com.tikdik;

import com.tikdik.annotation.MessageTag;
import com.tikdik.handler.Handler;
import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MessageDispatch {
    private static Map<String, Class<?>> classMap;

    static {
        classMap = new HashMap<>();
        Reflections reflections = new Reflections(Handler.class.getPackage().getName());
        Set<Class<?>> classesList = reflections.getTypesAnnotatedWith(MessageTag.class);
        for (Class<?> classes : classesList) {
            MessageTag messageTag = classes.getAnnotation(MessageTag.class);
            classMap.put(messageTag.value(), classes);
        }
    }

    public void dispatch(String message) {
        int split = message.indexOf(":");
        if (split < 0) {
            return;
        }
        String tag = message.substring(0, split);
        String data = message.substring(split + 1);
        dispatch(tag, data);
    }

    public void dispatch(String tag, String data) {
        if (tag == null || data == null) {
            return;
        }
        Class cls = classMap.get(tag);
        if (cls == null) {
            return;
        }

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
