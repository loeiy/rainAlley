package com.alley.rain.thinkinjava.reflect;


/**
 * Class对象
 */
public class ClassDemo1 {

    /**
     * 万事万物皆对象，但静态成员、普通数据类型不是对象。
     * 类是对象，类是java.lang.Class类的实例对象
     */
    public static void main(String[] args) {
        // Foo的实例对象表示-->new 创建对象是静态加载类，在编译时刻就需要加载所有的可能使用到的类
        Foo foo1 = new Foo();

        // 任何类都是Class类的实例对象，这个实例对象的三种表现形式
        // 1.实际告诉我们任何一个类都有一个隐含的静态成员变量
        Class c1 = Foo.class;

        // 2.已知该类的对象通过getClass()方法
        Class c2 = foo1.getClass();

        // c1和c2表示了Foo类的类类型（class type）。类也是对象，是Class类的实例对象，这个对象称之为该类的类类型

        System.out.println(c1 == c2);

        // 3.c3也是该类的类类型。Class.forName("类的全称")不仅表示了类的类类型，还代表了动态加载类
        // 一般使用这种方法，1需要导入类的包路径，2都有对象了还需要反射吗？
        Class c3 = null;
        try {
            c3 = Class.forName("com.alley.rain.thinkinjava.reflect.Foo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(c1 == c3);

        // 于是，我们知道可以通过类的类类型创建该类的实例对象-->通过c1/c2/c3获取Foo的实例对象
        Foo foo2 = null;
        try {
            foo2= (Foo) c1.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        foo2.print();
    }
}

class Foo {
    void print() {
        System.out.println("11");
    }
}