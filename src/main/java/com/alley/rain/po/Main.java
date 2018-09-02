package com.alley.rain.po;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * main方法
 */
public class Main {
    public static void main(String[] args) throws IOException {

        ArrayList<User> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String name;
        String pass;
        FileOutputStream fos = new FileOutputStream("e:/ly/user.txt", true);
        ObjectOutputStream  oos = new ObjectOutputStream(fos);
        System.out.println("请输入帐号：");
        name = sc.next();
        System.out.println("请输入密码：");
        pass = sc.next();
        User user = new User(name, pass);
        list.add(user);
        oos.writeObject(list);
        oos.flush();
        oos.close();
    }
}
