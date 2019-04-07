package com.alley.rain.thinkinjava.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 打印类的信息，包括类的成员方法、成员变量
 */
public class ClassUtil {

    public static void printClassMethodMessage(Object obj) {
        // 获取类的信息，首先获取类的类类型。类.class/对象的.getClass()/Class.forName();此处obj是个对象
        Class c = obj.getClass(); // 传递的是哪个子类的对象，c就是该类的类类型

        // 获取类的成员方法信息
        System.out.println("类的名称是：" + c.getName());
        /**
         * Method类，方法对象
         * 一个成员方法就是一个Method对象
         * getMethods()获取的是所有public的函数，包括父类继承而来的方法
         * getDeclaredMethods()获取的是所有该类自己声明的方法，不问访问权限
         */
        Method[] ms = c.getMethods(); //  c.getDeclaredMethods()

        for (int i = 0; i < ms.length; i++) {
            // 得到方法的返回值类型的类类型
            Class returnType = ms[i].getReturnType();
            System.out.print(returnType.getName() + " "); // 方法返回值的类型的名称
            // 得到方法的名称
            System.out.print(ms[i].getName() + " ("); // 方法的名称
            // 获取参数类型-->得到的是参数列表的类型的类类型
            Class[] parameterTypes = ms[i].getParameterTypes();
            for (Class class1 : parameterTypes) {
                System.out.print(class1.getName() + ","); // 方法的参数类型的名称
            }
            System.out.println(")");
        }
    }

    public static void printClassFieldMessage(Object obj) {
        // 首先获取类的类类型
        Class c = obj.getClass();

        /**
         * 成员变量也是对象
         * java.lang.reflect.Field
         * Field类封装了关于成员变量的操作
         * getFields()方法获取的是所有的public的成员变量的信息
         * getDeclaredFields获取的是该类自己声明的成员变量的信息
         */
        System.out.println("类的名称是：" + c.getName());
        Field[] fs = c.getDeclaredFields(); // c.getFields()
        for (Field field : fs) {
            // 获取成员变量类型的类类型
            Class fieldType = field.getType();
            String typeName = fieldType.getName(); // 成员变量的类型的名称

            String fieldName = field.getName(); // 成员变量名称
            System.out.println(typeName + " " + fieldName);
        }

    }

    public static void printClassConstructor(Object obj) {
        // 获取类的类类型
        Class c = obj.getClass();

        /**
         * 构造函数也是对象
         * java.lang.Constructor中封装了构造函数的信息
         * getConstructors获取所有的public的构造函数
         * getDeclaredConstructors得到所有的构造函数
         */
        Constructor[] cs = c.getDeclaredConstructors();
        for (Constructor constructor : cs) {
            System.out.print(constructor.getName() + "("); // 构造参数名称

            Class[] parameterTypes = constructor.getParameterTypes();
            for (Class class1 : parameterTypes) {
                System.out.print(class1.getName() + ",");
            }
            System.out.println(")");
        }
    }
}
