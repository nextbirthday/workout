package com.ch01;

// 변수의 종류
// 1. 원시형 변수 - 8가지 byte, short, int, long,----
// 2. 참조형 변수 - 호출하면 주소번지가 나온다 ex)@avwz1231284712
// 클래스 타입은 모두 참조형이다.
public class Variable {
    
    // 클래스 선언
    // 선언부 = 코딩하는 위치가 XXX이면 전역변수(멤버변수)이다.
    // 변수 선언하기
    // 타입 변수명(직관적이름 ,age,men_id,email)
    int        age  = 30; // 변수선언+초기화
    static int age2 = 50;
    // 이름뒤에 괄호가 있으면 메소드이다.
    // 나는 메소드를 선언{좌중괄호, 우중괄호} 할 수 있다.
    // 메소드를 호출할 땐 세미콜론 ;
    // 메소드 안에 메소드를 선언할 수 있다.
    
    public static void main( String[] args ) {
        // 메소드 안에 선언하면 지역변수 줄여서 지변
        // (local variable, automatic variable:메소드안에서만 사용가능함, 메소드내에서만 호출가능)
        int age = 5; // 지변
        // insert here methodA를 호출해보세요
        // methodA(); static이 있는 메소드 안에서 static이 없는 메소드를 호출할 수 없다.
        // 그런데 꼭 하고 싶다면 인스턴스화를 하면 메소드를 호출할 수 있다. - 문제해결 능력
        
        Variable v1 = null; // 클래스를 선언만 하였다. 실제로 객체는 만들어지지 않았다.
        v1 = new Variable();
        
        //Variable v1 = new Variable();
        v1.age = 7; // 매우 중요 why? 위의 int age = 30;을 5로 바꾸지말고 지역변수와 멤버변수를 구분해서 변경가능
        v1.methodA(); // Variable클래스가 methodA의 소유주이다.
        // 이 때 비로소 객체가 생성됨 - heap메모리 영역에 로딩이 된다.
        // 메모리에 있으니 호출이 가능하다. -> 재사용할 수 있다.
        
        methodB();
    }
    
    void methodA() {
        System.out.println( age );// 30 - 전변 출력
        // 5를 출력하고 싶어요 가능할까요?
    }
    
    static void methodB() {
        System.out.println( age2 );
    }
    
}
