package b3_1215;

public class Notepad {
    // A a = null; 선언만 했다. Paper myPaper = new Paper(); - 인스턴스화
    // Car myCar = new Sonata(); 이런 인스턴스화도 가능하다 (다형성)
    // Constructor의 제1역할은 전역변수의 초기화이다.
    // 생성자 결정은 사용하려는 쪽에서 결정한다.
    // Constructor를 호출하려면 parameter를 결정해야 한다.
    // parameter의 값은 호출하려는 클래스에서 결정한다.
    // 그래서 전역변수의 초기화를 Constructor가 담당한다.
    
    // 어떤 class를 상속 받을 때에는 extends라는 예약어를 사용한다.
    // 어떤 관계일 때 상속으로 처리하는가? A is a B 관계이면 상속으로 처리한다.
    // Sonata 는 car이다. car는 Sonata이다.
    // 부모 class가 가진 변수와 메서드도 사용가능하다.
    // child class가 더 많이 누릴 수 있다.
    
    // 스코프란 변수를 사용할 수 있는 범위를 얘기하는데
    // {} 안에서 변수를 선언했을 경우 영역이 끝나기 전까지는 어디서든 사용이 가능하다
    
    // static method는 static method call '가능'
    // static method 는 instance variable 사용 '불가능'
    // static method는 instance method call '불가능'
    // 왜 static method는 인스턴스 멤버를 쓸 수 없나요?
    // static method 호출 시 객체가 없을 수도 있어서 ( static 은 항상 호출 가능)
    long add( int a, long b ) {
        return a + b;
    }
    
    long add( long a, int b ) {
        return a + b;
    }
}
