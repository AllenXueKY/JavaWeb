package com.allen.annotation;

import com.allen.domain.Person;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 框架类
 */
@Pro(className = "com.allen.annotation.Demo1",methodName = "show")
public class ReflectTest {
    public static void main(String[] args) throws Exception {

        /**
         * 前提：不能改变该类的任何代码。可以创建任意类的对象，可以执行任意方法
         */
        //1、解析注解
        //1.1、获取该类的字节码文件对象
        Class<ReflectTest> reflectTestClass = ReflectTest.class;
        //2、获取上边的注解对象
        Pro annotation = reflectTestClass.getAnnotation(Pro.class);
        //3、调用注解对象中定义的抽象方法，获取返回值
        String className = annotation.className();
        String methodName = annotation.methodName();
        System.out.println(className);
        System.out.println(methodName);

        //3、加载该类进内存
        Class cls = Class.forName(className);
        //4、创建对象
        Object obj = cls.newInstance();
        //5、获取方法对象
        Method method = cls.getMethod(methodName);
        //6、执行方法
        method.invoke(obj);
    }
}
