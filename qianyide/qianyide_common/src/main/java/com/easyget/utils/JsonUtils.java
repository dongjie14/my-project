package com.easyget.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Type;
import java.net.URL;
import java.sql.Timestamp;
import java.util.*;


/**
 * json数据转换
 *
 * @author yun
 * @ClassName: JsonUtils
 * @date 2015年1月15日 下午5:43:21
 */
public class JsonUtils {

    /**
     * object输出json
     *
     * @param response
     * @param res
     */
    public static void toJson(HttpServletResponse response, Object res) {
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = null;
        try {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.setDateFormat("yyyy-MM-dd HH:mm:ss");
            gsonBuilder.registerTypeAdapter(Timestamp.class, new TimestampTypeAdapter());
            Gson gson = gsonBuilder.create();
            String result = gson.toJson(res);
            out = response.getWriter();
            out.print(result);
            out.flush();
            out.close();
        } catch (IOException e) {

        }
    }

    /**
     * 加有注解的字段转换为JSON
     *
     * @param response
     * @param object
     */
    public static void toObjectJson(HttpServletResponse response, Object object) {
        try {
            response.setContentType("application/json; charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();

            GsonBuilder bulider = new GsonBuilder();
            bulider.setDateFormat("yyyy-MM-dd HH:mm:ss");
            bulider.registerTypeAdapter(Timestamp.class, new TimestampTypeAdapter());
            bulider.excludeFieldsWithoutExposeAnnotation();
            Gson gson = bulider.create();
            out.print(gson.toJson(object));
            out.flush();
            out.close();
        } catch (Exception e) {

        }
    }

    /**
     * object转json
     *
     * @param res
     * @return
     */
    public static String toParseJson(Object res) {
        String result = null;
        try {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.setDateFormat("yyyy-MM-dd HH:mm:ss");
            gsonBuilder.registerTypeAdapter(Timestamp.class, new TimestampTypeAdapter());
            Gson gson = gsonBuilder.create();
            result = gson.toJson(res);
        } catch (Exception e) {

        }
        return result;
    }

    /**
     * @param object
     * @return
     */
    public static String beanToJson(Object object) {
        Gson gson = new Gson();
        return gson.toJson(object);
    }

    /***
     *
     * @return
     */
    public static String beanToJson(Object obj, Type type) {
        Gson gson = new Gson();
        return gson.toJson(obj, type);
    }

    public static String beanWithGsonToJson(Object obj) {
        String str = null;
        GsonBuilder bulider = new GsonBuilder();
        bulider.setDateFormat("yyyy-MM-dd HH:mm:ss");
        bulider.registerTypeAdapter(Timestamp.class, new TimestampTypeAdapter());
        bulider.excludeFieldsWithoutExposeAnnotation(); // 不转换没@Expose 注解的字
        Gson gson = bulider.create();
        str = gson.toJson(obj);
        return str;
    }

    public static String beanWithGsonToJson(Object obj, Type type) {
        String str = null;
        GsonBuilder bulider = new GsonBuilder();
        bulider.excludeFieldsWithoutExposeAnnotation(); // 不转换没@Expose 注解的字
        Gson gson = bulider.create();
        str = gson.toJson(obj, type);
        System.out.println(str);
        return str;
    }

    public static String listToJson(List list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    public static String listToJson(List list, Type type) {
        Gson gson = new Gson();
        return gson.toJson(list, type);
    }

    public static String listWithGsonToJson(List list, Type type) {
        String str = null;
        GsonBuilder bulider = new GsonBuilder();
        bulider.excludeFieldsWithoutExposeAnnotation(); // 不转换没@Expose 注解的字
        Gson gson = bulider.create();
        str = gson.toJson(list, type);
        System.out.println(str);
        return str;
    }

    @SuppressWarnings("unchecked")
    public static Object jsonToBean(String json, Class clzz) {

        GsonBuilder bulider = new GsonBuilder();
        // buliderc.excludeFieldsWithoutExposeAnnotation();
        Gson gson = bulider.create();
        return gson.fromJson(json, clzz);
    }

    public static Object jsonToBean(String json, Type typeof) {
        GsonBuilder bulider = new GsonBuilder();
        Gson gson = bulider.create();
        return gson.fromJson(json, typeof);
    }

    @SuppressWarnings("unchecked")
    public static List<Map<String, Object>> parseJSON2List(String jsonStr) {
        JSONArray jsonArr = JSONArray.fromObject(jsonStr);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Iterator<JSONObject> it = jsonArr.iterator();
        while (it.hasNext()) {
            JSONObject json2 = it.next();
            list.add(parseJSON2Map(json2.toString()));
        }
        return list;
    }

    @SuppressWarnings("unchecked")
    public static Map<String, Object> parseJSON2Map(String jsonStr) {
        Map<String, Object> map = new HashMap<String, Object>();
        // 层解
        JSONObject json = JSONObject.fromObject(jsonStr);
        for (Object k : json.keySet()) {
            Object v = json.get(k);
            // 如果内层还是数组的话，继续解
            if (v instanceof JSONArray) {
                List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
                Iterator<JSONObject> it = ((JSONArray) v).iterator();
                while (it.hasNext()) {
                    JSONObject json2 = it.next();
                    list.add(parseJSON2Map(json2.toString()));
                }
                map.put(k.toString(), list);
            } else {
                map.put(k.toString(), v);
            }
        }
        return map;
    }

    public static List<Map<String, Object>> getListByUrl(String url) {
        try {
            // 通过HTTP获取JSON数据
            InputStream in = new URL(url).openStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            return parseJSON2List(sb.toString());
        } catch (Exception e) {

        }
        return null;
    }

    public static Map<String, Object> getMapByUrl(String url) {
        try {
            // 通过HTTP获取JSON数据
            InputStream in = new URL(url).openStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }

            return parseJSON2Map(sb.toString());
        } catch (Exception e) {

        }
        return null;
    }

    public static Map<String, Object> parseJSON2ObjectList(String jsonStr) {
        Map<String, Object> map = new HashMap<String, Object>();
        // 层解
        JSONObject json = JSONObject.fromObject(jsonStr);
        for (Object k : json.keySet()) {
            Object v = json.get(k);
            // 如果内层还是数组的话，继续解
            if (v instanceof JSONArray) {
                List<Object> list = new ArrayList<Object>();
                Iterator<JSONObject> it = ((JSONArray) v).iterator();
                while (it.hasNext()) {
                    Object json2 = it.next();
                    list.add(json2.toString());
                }
                map.put(k.toString(), list);
            } else {
                map.put(k.toString(), v);
            }
        }
        return map;
    }

}
