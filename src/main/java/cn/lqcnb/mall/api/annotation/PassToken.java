package cn.lqcnb.mall.api.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PassToken {
    boolean required() default true;
}
//@Target:注解的作用目标
//@Target(ElementType.TYPE)——接口、类、枚举、注解
//@Target(ElementType.FIELD)——字段、枚举的常量
//@Target(ElementType.METHOD)——方法
//@Target(ElementType.PARAMETER)——方法参数
//@Target(ElementType.CONSTRUCTOR) ——构造函数
//@Target(ElementType.LOCAL_VARIABLE)——局部变量
//@Target(ElementType.ANNOTATION_TYPE)——注解
//@Target(ElementType.PACKAGE)——包
//
//@Retention：注解的保留位置
//        RetentionPolicy.SOURCE:这种类型的Annotations只在源代码级别保留,编译时就会被忽略,在class字节码文件中不包含。
//        RetentionPolicy.CLASS:这种类型的Annotations编译时被保留,默认的保留策略,在class文件中存在,但JVM将会忽略,运行时无法获得。
//        RetentionPolicy.RUNTIME:这种类型的Annotations将被JVM保留,所以他们能在运行时被JVM或其他使用反射机制的代码所读取和使用。
//@Document：说明该注解将被包含在javadoc中
//@Inherited：说明子类可以继承父类中的该注解


