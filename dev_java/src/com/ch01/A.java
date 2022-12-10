\package com.ch01;

public class A {
    
    double pi = 3.14;
    
    public static void main( String[] args ) {
        double pi = 5.1;
        // insert here 전역변수 출력해주세요
        A a = new A();
        System.out.println( pi );// 5.1 전역변수가 아닌 지역변수가 출력
        System.out.println( a.pi );
    }
    
}
