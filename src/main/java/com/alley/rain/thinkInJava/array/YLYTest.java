package com.alley.rain.thinkinjava.array;

/**
 * Description:养老院
 * User: dyf
 * Date: 2019-04-26
 * Time: 17:05
 */
public class YLYTest {

    /**
     * 1.finally中如果有return,会忽略try/catch中的返回,同时忽略其中的异常
     */
   /* public static void main(String[] args) {
        System.out.println(new YLYTest().getInt());
    }

    public int getInt(){
        try {
            return 1;
        } finally {
            return 2;
        }
    }*/

    /**
     * 2.final修饰局部变量
     * 基本类型：基本类型的值不能发生改变。
     * 引用类型：引用类型的地址值不能发生改变，但是，该对象的堆内存的值是可以改变。
     */

    public static void main(String[] args) {
        int x = 10;
        x = 20;
        System.out.println(x);

        final int y = 10;
        //  y = 20; 报错
        System.out.println(y);

        final Girl g = new Girl();
        System.out.println(g.getAgee());

        g.setAgee(20);
        System.out.println(g.getAgee());
    }

    /**
     * 3.递归求斐波那契数列第30位的值（1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144...）
     * 麻烦点用for循环的逗号表达式，未验证
     */

   /* public static void main(String[] args) {
        System.out.println(f(30));
    }

    private static int f(int n){
        if(n==1 || n==2){
            return 1;
        }else{
            return f(n-1)+f(n-2);
        }
    }
*/
    /**
     * 4.sql语句：group by having或者where
     */
}
