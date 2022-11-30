package com.ch01;

// boolean -> true or false
public class Variable2 {
    
    public static void main( String[] args ) {
        
        int i = 2;
        int j = 2;
        
        System.out.println( i );
        System.out.println( i == j ); // true
        System.out.println( j != i ); // false
        
        double d = 2.4;
        // 대입연산자 오른쪽에 더 큰 타입이 오는것은 안된다.
        // 괄호가 변수명 앞에 오면 형 변환 연산자 casting
        // 강제 형변환
        j = ( int ) d;
        System.out.println( j );
        
        boolean isOk = false;
        // j = (int)isOk; Cannot cast from boolean to int
    }
    
}
