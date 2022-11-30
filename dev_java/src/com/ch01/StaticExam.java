package com.ch01;

public class StaticExam {
    // static은 변수 앞에 또는 메소드 앞에 올 수 있다.
    // static이 있으면 정적 변수, 정적 메소드라 한다.
    // 인스턴스화 없이 어디서나 호출할 수 있다.
    
    int        i; //전역 변수는 초기화를 생략할 수 있다.  default value는 0이다.
    int j; //정적 변수 j
    
    void methodA() {
        
        i = i + 1;
        j = i * 2;
        System.out.println( "i" + String.valueOf( i ) ); // i1
        System.out.println( "j" + String.valueOf( j ) ); //j2
        
    }
    
    public static void main( String[] args ) {
        
        StaticExam staticExam1 = new StaticExam();
        staticExam1.methodA();
        
    }
    
}
