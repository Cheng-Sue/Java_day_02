package com.shangjia.java_day_02.inject;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Create: 2020/8/29 11:09
 * <p>
 * Description:
 */

/**
 * ElementType.ANNOTATION_TYPE 可以应用于注解类型。
 * ElementType.CONSTRUCTOR 可以应用于构造函数。
 * ElementType.FIELD 可以应用于字段或属性。
 * ElementType.LOCAL_VARIABLE 可以应用于局部变量。
 * ElementType.METHOD 可以应用于方法级注解。
 * ElementType.PACKAGE 可以应用于包声明。
 * ElementType.PARAMETER 可以应用于方法的参数。
 * ElementType.TYPE 可以应用于类的任何元素。
 */
@Target(ElementType.FIELD)
/**
 * RetentionPolicy.SOURCE - 标记的注解仅保留在源级别中，并被编译器忽略。
 * RetentionPolicy.CLASS - 标记的注解在编译时由编译器保留，但 Java 虚拟机(JVM)会忽略。
 * RetentionPolicy.RUNTIME - 标记的注解由 JVM 保留，因此运行时环境可以使用它。
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface IntentExtra {
    String value() default "";
}
