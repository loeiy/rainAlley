package com.alley.rain.thinkInJava.reflect;

public class ClassDemo3 {
    public static void main(String[] args) {
        String s = "adfs";
        Integer i = 12;
        ClassUtil.printClassMethodMessage(i);
        ClassUtil.printClassFieldMessage(i);
        ClassUtil.printClassConstructor(i);
    }
}
