package com.ch01;

public class ForEvenOdd {
    
    public static void main( String[] args ) {
        
        int num1 = 10; // 정수형 int type 형 변수 num1을 선언과 동시에 10으로 초기화
        
        if ( num1 < 5 ) {
            System.out.println( "num1은 5보다 크다." );
        }
        else {
            System.out.println( "num1" );
        }
        
        int even = 0;
        int odd  = 0;
        
        for ( int i = 1; i < 101; i++ ) {
            
            if ( i % 2 == 0 ) {
                even += i; // even = even + i;
            }
            else {
                odd += i;
            }
        }
        System.out.println( even );
        System.out.println( odd );
    }
}
