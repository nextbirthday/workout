package com.ch01;

public class Variable3 {
    public static void main( String[] args ) {
        // String은 참조형 타입dlwl만 예외적으로 값이 출력된다.
        String name = "";
        System.out.println( name );
        
        int    age   = 30;
        String s_age = "30";
        System.out.println( age + 1 ); // 31
        System.out.println( s_age + 1 ); // 301
        System.out.println( 10 + 1 );
        System.out.println( "10" + 1 );
        // 코딩을 하면서 규칙을 발견하는 것도 공부방법
    }
    
}
