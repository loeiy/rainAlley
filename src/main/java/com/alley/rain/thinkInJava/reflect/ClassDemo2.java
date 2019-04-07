package com.alley.rain.thinkinjava.reflect;

public class ClassDemo2 {

    public static void main(String[] args) {
        Class c1 = int.class; // int的类类型
        Class c2 = String.class; // String的类类型
        Class c3 = double.class;
        Class c4 = Double.class;
        Class c5 = void.class;

        System.out.println(c2.getName());
        System.out.println(c2.getSimpleName()); // 打印不带路径的类名
        System.out.println(c5.getName());
    }
}
