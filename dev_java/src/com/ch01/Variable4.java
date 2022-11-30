package com.ch01;

public class Variable4 {
    
    void methodA() {
        int i;
        i = 10;
        System.out.println( i ); // 지역변수는 초기화를 생략할 수 없다.
    }
    
    public static void main( String[] args ) {
        
        Variable4 vp = new Variable4(); // 인스턴스화
        vp.methodA(); // vp안에 들어있는 methodA()
        
    }
    
}
