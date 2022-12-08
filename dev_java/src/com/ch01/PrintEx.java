package com.ch01;

public class PrintEx {
    
    public void print() {
        System.out.println( "print call" );
    }
    
    public void print( int i ) {
        System.out.println( "print method 에서 parameter로 받아온 변수 i의 값 = "+i );
        System.out.println( "print(int i) call" );
    }
    
    public void print( String str ) { // 호출될 때 초기화
        System.out.println( "print(String str) call" );
        System.out.println( str );
        
    }
    
    public static void main( String[] args ) {
        PrintEx pt = new PrintEx();
        pt.print();
        pt.print( 10 );
        pt.print( "10" );
    }
    
}
