package com.alley.rain.thinkinjava.reflect;

public class ClassDemo3 {
    public static void main(String[] args) {
        String s = "adfs";
        Integer i = 13;
        ClassUtil.printClassMethodMessage(i);
        ClassUtil.printClassFieldMessage(i);
        ClassUtil.printClassConstructor(i);
    }
}
