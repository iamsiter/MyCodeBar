package com.java8;

import java.util.Comparator;

public class DefaultInterfaceImpl implements A, B {

    @Override
    public void show() {
        System.out.println("BiiiHiii");
    }

    public static void main(String[] args) {

       /* A a = new DefaultInterfaceImpl();
        a.show();

        A b = new DefaultInterfaceImpl();
        b.show();*/

       /* //------------static--------------------
        A.show();
       */

       //---------------default-------------------
        B b = new DefaultInterfaceImpl();
        b.show();
    }
}

interface B {
    public void show();
}

interface A {
   /* public default void show(){
        System.out.println("Hiiii");
    }*/
}

