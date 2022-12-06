package com.ch01;

public class Return1 {
    void m() {}
    
    int m1() {
        int power = 100;
        return power;
    }
    
    double m2() {
        return 3.0;
    }
    
   boolean isView() {
        boolean bool = false;
        return bool;
    }
    
    boolean isView1() {
        boolean bool2 = true;
        return bool2;
    }
    
    String getName() {
        String name = "이순신";
        return name;
    }
    
    public static void main( String[] args ) {
        
        Return1 r1 = new Return1();
        
        System.out.println( r1.m1() );
    }
    
}
