package org.example.portal.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtils {

    private  static Gson gson = null;

    static {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();
    }

    public static String ToGson(Object object)
    {
        return gson.toJson(object);
    }

    public static <T> T FromGson(Class<T> tclass,String json)
    {
        return gson.fromJson(json,tclass);
    }

}
