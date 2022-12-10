package com.ch01;

public class LoginForm {
    
    public static String login( String id, String password ) {
        System.out.println( "로그인 호출 성공" );
        String name = null; // 변수를 선언만 했다. 초기화는 하지 않았다. null은 아직 미정
        name = "강감찬"; // 6번에서 선언한 변수의 초기화 default값이 강감찬
        // return name;
        return id;
        // return name;
    }
    
    public static void main( String[] args ) {
        String pname = login( "tomato", "123" );
        // insert here - 강감찬
        // login("","");
        login( "tomato", "123" );
        
        System.out.println( pname );
        System.out.println( login( "tomato", "123" ) );
        // println이라는 메소드 안에서 또 다른 메소드를 호출
        // 단, 반환타입이 있어야만한다.
        // login은 메소드(파라미터 자리에 선언된 변수는 지역변수)
        // 파라미터에 선언된 변수는 메소드가 호출될 때 결정(초기화)
    }
}
