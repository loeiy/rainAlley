package com.alley.rain.thinkInJava.reflect;

import java.lang.reflect.Method;

/**
 * Description: 获取方法对象，并进行反射操作
 * User: dyf
 * Date: 2019-04-06
 * Time: 23:52
 */
public class MethodDemo1 {

    public static void main(String[] args) {
        A a = new A();
        Class c = a.getClass();
        try {
            // 获取方法对象，首先获取类的类类型
            Method m1 = c.getMethod("print", new Class[]{int.class, int.class});
            Object obj = m1.invoke(a, 10, 20);

            Method m2 = c.getMethod("print", String.class, String.class);
            m2.invoke(a, "HELLO", "World");

            Method m3 = c.getMethod("print");
            m3.invoke(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class A {
    public void print(int a, int b) {
        System.out.println(a + b);
    }

    public void print(String a, String b) {
        System.out.println(a.toLowerCase() + b.toUpperCase());
    }

    public void print() {
        System.out.println("获取类中的无参数方法！");
    }
}