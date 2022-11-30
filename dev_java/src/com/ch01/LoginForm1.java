package com.ch01;

public class LoginForm1 {
    
    public String login( String id, String password ) {
        System.out.println( "로그인 호출 성공" );
        String name = null; // 변수를 선언만 했다. 초기화는 하지 않았다.null은 아직 미정
        name = "강감찬"; // 6번에서 선언한 변수의 초기화 default값이 강감찬
        
        return name;
    }
    
    void methodA() {
        login( "tomato", "123" );
    }
    
    // 괄호가 있으면 메소드이거나 생성자이다.
    
    public static void main( String[] args ) {
        // static 영역 안에서 non-static 메소드는 호출이 불가함
        // login("tomato","123");
        LoginForm1 loginForm1 = new LoginForm1(); // 인스턴스화 생성자
        String     pname      = loginForm1.login( "tomato", "123" );
        // insert here - 강감찬
        System.out.println( pname );
    }
}
