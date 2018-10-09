package com.nuode.intelligence.modular.system.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author luzhenqian luzhenqian98@gmail.com
 * @created 2018-10-09-0:07
 */
public class ReflexUtil {
    public static HashMap initProperties(Object object) {
        StringBuilder sbName = new StringBuilder();
        StringBuilder sbValue = new StringBuilder();
        String[] fieldNames = getFiledName(object);
        HashMap hashMap = new HashMap();
        for (int j = 0; j < fieldNames.length; j++) {     //遍历所有属性
            String name = fieldNames[j];    //获取属性的名字
            Object value = getFieldValueByName(name, object);
            sbName.append(name);
            sbValue.append(value);
            if (j != fieldNames.length - 1) {
                sbName.append("/");
                sbValue.append("/");
            }

            hashMap.put(name,value);
        }

        System.out.println("attribute name:" + sbName.toString());
        System.out.println("attribute value:" + sbValue.toString());
        return hashMap;
    }

    /**
     * 创建获取属性数组的方法
     * @param object
     * @param
     * @return
     */
    public static String[] getFiledName(Object object) {
        Field[] fields = object.getClass().getDeclaredFields();
        String[] fieldNames = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            //System.out.println("属性名:" + fields[i].getType());
            fieldNames[i] = fields[i].getName();
        }
        for (Object o : fieldNames) {
            //System.out.println("属性值:" + o + ",当前方法:PropertiesUtil.initProperties()");
        }
        return fieldNames;
    }

    /**
     * 根据属性名称获取对应的属性值
     * @param fieldName
     * @param object
     * @return
     */
    private static Object getFieldValueByName(String fieldName, Object object) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = object.getClass().getMethod(getter, new Class[]{});
            Object value = method.invoke(object, new Object[]{});
            return value;
        } catch (Exception e) {
            return null;
        }
    }


    public static Map get(Object object){
        Map map = new HashMap();
        // 得到类对象
        Class userCla = (Class) object.getClass();
        /* 得到类中的所有属性集合 */
        Field[] fs = userCla.getDeclaredFields();
        for (int i = 0; i < fs.length; i++) {
            Field f = fs[i];
            f.setAccessible(true); // 设置些属性是可以访问的
            Object val = new Object();
            try {
                val = f.get(object);
                // 得到此属性的值
                map.put(f.getName(), val);// 设置键值
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            /*
             * String type = f.getType().toString();//得到此属性的类型 if
             * (type.endsWith("String")) {
             * System.out.println(f.getType()+"\t是String"); f.set(obj,"12") ;
             * //给属性设值 }else if(type.endsWith("int") ||
             * type.endsWith("Integer")){
             * System.out.println(f.getType()+"\t是int"); f.set(obj,12) ; //给属性设值
             * }else{ System.out.println(f.getType()+"\t"); }
             */

        }
        System.out.println("单个对象的所有键值==反射==" + map.toString());
        return map;
    }
}
