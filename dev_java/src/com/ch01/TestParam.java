package com.ch01;

class Param {
    int ival;   // 전역변수 ival 선언
}

public class TestParam {
    
    void effectParam( Param p ) {
        // insert here - 여기에 p = new Param()이 있으면 결과가 달라진다 아니다 같다???
        //p = new Param();
        p.ival = 500;
                
        System.out.println( "sub ival ===>" + p.ival );
    }       
    
    public static void main( String[] args ) {
        
        TestParam testparam = new TestParam(); //인스턴스화
        Param     p         = new Param(); //인스턴스화
        
        testparam.effectParam( p ); //
        
        // p.ival = 500;
        
        System.out.println( "main ival ===>" + p.ival );
    }
}