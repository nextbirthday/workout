package b3_1212;

public class Notepad {
    // Array - Class - new - address - 간접 참조 방식
    // 전역변수 scope, 지역변수 scope
    // scope 란 변수를 사용할 수 있는 범위
    // {} 안에서 변수를 선언했을 경우 영역이 끝나기 전까지는 어디서든 사용이 가능하다.
    // 초기화 (initialization)
    // 변수 - 하나의 변수에 하나의 값만 담을 수 있다.
    // Array - size를 변경할 수 없다. 늘었다 줄었다 불가능하다.
    // Array of Objects
    // JAVA뿐만 아니라 프로그래밍에서의 영속성
    
    // 선언과 동시에 인스턴스화를 하지 않는 경우를 게으른 인스턴스화라고 한다.
    // 선언과 생성을 동시에 하지 않고 메서드를 통해서 객체 주입을 받을 수 있다.
    // 이럴 경우 메서드 안에서 if 문을 통해 null check를 할 수 있어 singleton pattern으로 객체를 주입 받을 수 있다.
    // 현업에서 선호하는 객체 주입 방법 중 하나 .
    
    // Callback method
    // 추상 클래스, 메서드 (abstract class, abstract method)
    // "Spring"
    // "annotation"
    // Java의 static과 instance와 차이점
    // ※생성자 안에서 메서드를 호출하는 행위
    // annotation - 문법적인 제약을 가지고 있다. 선언부가 일치해야 한다.
    // 메서드 오버라이드는 선언부를 절대로 손댈 수 없다.
    // 접근제한자 리턴타입 메서드이름 파라미터
    
    // default constructor는 생략이 가능하다. why? JVM이 생성해준다.
    // constructor 언제 호출? instance화 하면 ex.) new constructor();
    // constructor도 method처럼 호출이 가능하다.
    // constructor는 return type이 없다.
    // parameter가 있는 constructor가 하나라도 있다면 디폴트 생성자가 제공되지 않는다.
    // 어떠한 constructor도 선언하지 않았을 때만 제공된다. 생략할 수 있다.
    // constructor를 통해서 할 수 있는 역할은 초기화 (initialization)에 있다.
    
    // memory StackOverFlow 발생 - server가 터질 수 있다. - 인스턴스화의 위치 판단    
}
