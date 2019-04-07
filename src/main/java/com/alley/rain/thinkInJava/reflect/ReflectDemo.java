package com.alley.rain.thinkinjava.reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Description: 反射使用类Demo
 * User: dyf
 * Date: 2019-04-06
 * Time: 15:25
 */
public class ReflectDemo {

    public static void main(String[] args) {
        ArrayList list1 = new ArrayList();
        ArrayList<String> list2 = new ArrayList<>();

        list2.add("abc");
        // list2.add(111);错误的

        Class c1 = list1.getClass();
        Class c2 = list2.getClass();
        System.out.println(c1 == c2);
        // 反射的操作都是在编译之后的操作，c1 == c2 返回true，说明编译之后集合的泛型是去泛型化的
        // Java中的泛型，是防止错误输入的，只在编译阶段有效，验证：用反射
        // 绕过编译使用反射让list2添加int类型数据
        try {
            Method m = c2.getMethod("add", Object.class);
            m.invoke(list2, 100);
            System.out.println(list2.size());
            System.out.println(list2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
