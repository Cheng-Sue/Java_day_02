package com.shangjia.java_day_02.inject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * Create: 2020/8/29 11:17
 * <p>
 * Description:
 */
public class IntentExtraUtils {

    public static String TAG = IntentExtraUtils.class.getSimpleName();

    public static void initIntentExtra(Activity activity) {
        //实例对象
        Class<? extends Activity> aClass = activity.getClass();
        //成员属性
        Field[] fields = aClass.getDeclaredFields();
        //bundle == Map
        Bundle bundle = activity.getIntent().getExtras();
        //遍历
        for (Field field : fields) {
            //是否使用注解
            if (field.isAnnotationPresent(IntentExtra.class)) {
                //注解对象
                IntentExtra annotation = field.getAnnotation(IntentExtra.class);
                //IntentExtra value 得key
                String key;
                if (TextUtils.isEmpty(annotation.value())) {
                    key = field.getName();
                } else {
                    key = annotation.value();
                }
                //从bundle根据key取value
                if (bundle.containsKey(key)) {
                    Object obj = bundle.get(key);
                    //实现parcelable的数组 还有再进行判断
                    Class<?> componentType = field.getType().getComponentType();
                    if (field.getType().isArray() &&
                            Parcelable.class.isAssignableFrom(componentType)){
                        Object[] objs = (Object[]) obj;

                        Object[] objects = Arrays.copyOf(objs, objs.length,
                                (Class<? extends Object[]>) field.getType());
                        obj = objects;
                    }

                    try {
                        //把数据塞进实例里
                        field.setAccessible(true);
                        field.set(activity, obj);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }
            }

        }


    }

}
