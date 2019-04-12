package com.alley.rain.thinkinjava.array;

import java.util.Arrays;

/**
 * Description: 数组说明-为了存储同种数据类型的多个值。数组既可以存储基本数据类型，也可以存储引用数据类型。
 * User: dyf
 * Date: 2019-04-12
 * Time: 23:24
 */
public class ArrayTest {

    public static void main(String[] args) {
        Girl[] g1 = new Girl[5]; // 动态初始化数组，只指定长度，在内存中开辟连续的5个空间
        System.out.println(Arrays.toString(g1));

        // 也可以简写成g3
        Girl[] g2 = new Girl[]{new Girl("q", "1"), new Girl("w", "2"), new Girl("e", "3")};
        Girl[] g3 = {new Girl("q", "1"), new Girl("w", "2"), new Girl("e", "3")};
        System.out.println(Arrays.toString(g2));
        System.out.println(Arrays.toString(g3));

        /**
         * 数组初始化：就是为数组开辟连续的内存空间，并为每个数组元素赋予值
         * 动态初始化：只指定长度，由系统给出初始化值 	int[] arr = new int[5];
         * 静态初始化：给出初始化值，由系统决定长度 	int[] arr = new int[]{,,,,,};简便写法是int[] arr={,,,,,};
         * 整数类型:byte,short,int,long默认初始化值都是0
         * 浮点类型:float,double默认初始化值都是0.0
         * 布尔类型:boolean默认初始化值false
         * 字符类型:char默认初始化值'\u0000'
         * char在内存中占的两个字节,是16个二进制位
         * \u0000,每一个0其实代表的是16进制的0,那么四个0就是代表16个二进制位
         */
        int[] arr = new int[5];
        int[] arr1 = new int[]{1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}
