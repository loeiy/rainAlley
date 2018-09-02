package com.alley.rain.po;

import java.util.Scanner;

public class DoTest {
    public static void main(String[] args) {

        while (true) {
            System.out.println("请输入一个数：");
            Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();
            if (a == 0) {
                System.out.println("程序退出");
                return;
            } else {
                switch (a) {
                    case 1:
                        System.out.println("周一！");
                        break;
                    case 2:
                        System.out.println("周二！");
                        break;
                    case 3:
                        System.out.println("周三！");
                        break;
                    case 4:
                        System.out.println("周四！");
                        break;
                    default:
                        System.out.println("你输入的数我识别不了！");
                }
            }
        }
    }
}
