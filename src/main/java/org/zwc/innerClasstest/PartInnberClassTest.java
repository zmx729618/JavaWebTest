package org.zwc.innerClasstest;

/**
 * 局部内部类测试---定义在外部类的方法中，并且只能在定义该内部类的方法内实例化
 * Created by zhangwenchao on 2017/11/23.
 */
public class PartInnberClassTest {

    private int s = 100;
    private int out_i = 1;

    public void f(final int k) {
        final int s = 200;
        int i = 1;
        final int j = 10;

        // 定义在方法内部
        class Inner {
            int s = 300;// 可以定义与外部类同名的变量

            // static int m = 20;//不可以定义静态变量
            Inner() {}

            int inner_i = 100;

            void inner_f(int k) {
                // 如果内部类没有与外部类同名的变量，在内部类中可以直接访问外部类的实例变量
                System.out.println(out_i);
                // 可以访问外部类的局部变量(即方法内的变量)，但是变量必须是final的
                System.out.println(j);
                // System.out.println(i);
                // 如果内部类中有与外部类同名的变量，直接用变量名访问的是内部类的变量
                System.out.println(s);
                // 用this.变量名访问的也是内部类变量
                System.out.println(this.s);
                // 用外部类名.this.内部类变量名访问的是外部类变量
                System.out.println(PartInnberClassTest.this.s);
            }
        }
        new Inner().inner_f(k);
    }

    public static void main(String[] args) {
        // 访问局部内部类必须先有外部类对象
        PartInnberClassTest out = new PartInnberClassTest();
        out.f(3);
    }





}
