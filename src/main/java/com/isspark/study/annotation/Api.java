package com.isspark.study.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * <p>
 * TODO(一句话描述该类的功能)
 * </p>
 *
 * @author xuzheng
 * @since 2020/4/15 21:19
 */
@Target(ElementType.TYPE)
public @interface Api {

    String name();
    String falg() default "aaa";
}
