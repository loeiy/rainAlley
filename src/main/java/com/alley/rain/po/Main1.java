package com.alley.rain.po;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main1 {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("e:/ly/user.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<User> list = (ArrayList<User>) ois.readObject();

       /* for(User s:list){
            System.out.println(s.getName());
            System.out.println(s.getPass());
        }*/

        int i = list.size();
        System.out.println(i);
        User verifyUser = list.get(0);
        String verifyName = verifyUser.getName();
        String verifyPass = verifyUser.getPass();
        System.out.println(verifyName);
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入帐号：");
        String name = sc.next();
        System.out.println("请输入密码：");
        String pass = sc.next();
        //map.put(name, pass);
        if (name.equals(verifyName) && pass.equals(verifyPass)) {
            //if (map.containsKey(name)&&pass.equals(user.getPass())){
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }

    }
}
