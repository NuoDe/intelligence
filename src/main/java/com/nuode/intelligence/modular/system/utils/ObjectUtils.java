package com.nuode.intelligence.modular.system.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author luzhenqian luzhenqian98@gmail.com
 * @created 2018-10-10-14:08
 */
public class ObjectUtils {

    public static Map<?,?> objectToMap(Object object){
        if(object == null){
            return null;
        }
        try {
            Map map = org.apache.commons.beanutils.BeanUtils.describe(object);
            return map;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}
