package com.ch01;

public class StringEx {
    
    public static void main(String[] args) {
        String s1 = "안녕";        
        String s2 = "안녕";
        String s3 = new String("안녕");
        String s4 = new String("안녕");

        //s1과 s2 주소번지는 같은지 비교하시오. T or F
        //s3과 s4의 주소번지를 비교하시오. 
        // s3이 가리키는 문자열이 s4와 같은지를 비교하려면 어떻게 해야할까?
        boolean result = s1.equals(s2);        
        System.out.println("boolean result = " + result);
        System.out.println(System.identityHashCode(s1));
        System.out.println(System.identityHashCode(s2));
        
        boolean result2 = s3.equals(s4);
        System.out.println("=========");   
        System.out.println(result2);    
        System.out.println(System.identityHashCode(s3));
        System.out.println(System.identityHashCode(s4));
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s3 == s4);        
        System.out.println(System.identityHashCode(s3) == System.identityHashCode(s4));

    }
    
}
