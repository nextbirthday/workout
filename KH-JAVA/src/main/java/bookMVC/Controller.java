package bookMVC;

// 단독으로 인스턴스화 할 수 없다. 반드시 구현체 클래스가 존재해야 한다.
// 인터페이스는 추상 메서드만 가질 수 있다. 일반 메서드는 가질 수 없다.
// 인터페이스는 생성자를 가질 수 없다.
// 인터페이스는 전역변수 선언이 불가능하다.

// 추상클래스는 추상 메서드 뿐만 아니라 일반 메서드도 가질 수 있다.
//
public interface Controller {
    // static은 abstract와 같이 올 수 없다.
    public abstract FrontController getController( String gubun );
}
