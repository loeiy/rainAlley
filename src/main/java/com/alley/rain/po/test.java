package com.alley.rain.po;

import java.util.Random;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Random ran = new Random(); // 随机数
        Scanner sc = new Scanner(System.in); // 接受键盘输入

        do {
            // 1.首先输入账号，不合要求循环此块
            System.out.println("请输入用户名/账号：");
            String a = sc.next();
            if (a.length() < 3) {
                System.out.println("请输入大于3位数账号！");
                continue;
            }

            while (true) {
                // 2.输入密码，不一致则循环此块
                System.out.println("请输入密码：");
                String b = sc.next();
                if (b.length() < 6) {
                    System.out.println("请输入大于6位数密码！");
                    continue;
                }
                System.out.println("请再次输入密码：");
                String c = sc.next();
                if (!b.equals(c)) {
                    System.out.println("两次密码必须相同！");
                    continue;
                }

                // 3.生成的4位验证码
                String str = "";
                String appStr = null; // 每次循环生成的单个验证码
                for (int i = 0; i < 4; i++) {
                    int num = ran.nextInt(3);
                    System.out.println("num的值为：" + num);
                    if (num == 0) {
                        int num1 = ran.nextInt(10);
                        appStr = String.valueOf(num1);
                        System.out.println("num1的值为：" + num1);
                    }
                    if (num == 1) {
                        char num2 = (char) ((char) ran.nextInt(26) + 65);
                        appStr = String.valueOf(num2);
                        System.out.println("num2的值为：" + num2);
                    }
                    if (num == 2) {
                        char num3 = (char) ((char) ran.nextInt(26) + 97);
                        appStr = String.valueOf(num3);
                        System.out.println("num3的值为：" + num3);
                    }
                    str = str + appStr;
                }
                System.out.println("验证码为：" + str);
                System.out.println("----------------------");

                while (true) {
                    // 4.验证码匹配校验
                    System.out.println("请输入验证码：");
                    String verifyStr = sc.next(); //输入的验证码
                    if (!verifyStr.equalsIgnoreCase(str)) {
                        System.out.println("验证码不正确，请重新输入！");
                        continue;
                    }
                    System.out.println("注册成功！");
                    System.exit(1);
                }
            }
        } while (true);
    }
}
