package lecture_2022_12.week_5_Server;

public class Notepad extends Thread {
    // Thread - Junior 개발자에게 맡기지 않는다.
    // 언제 필요한가?
    // 어떻게 생성하는가
    
    // 웹 서버 - Web Application Server(WAS) - thread가 구현되어 있다.
    
    // 구현 방법
    
    // 상속 - extends Thread
    // @overrid run()
    @Override
    public void run() {}
    
    public static void main( String[] args ) {
        // 선언부 타입 = 생성부 타입
        Notepad t = new Notepad();
        t.start();
        // 다형성을 누리고 싶으면 선언부와 생성부 타입을 다르게 가져간다.
        // 유지 보수시 코드를 최소한으로 수정하고 기능 수정이 가능하게 된다.
        // 선언부 타입 (추상 클래스, 인터페이스) != 생성부 타입 (구현체 클래스)
        Thread th = new Notepad();
        th.start();
    }
    
    // interface - class A implements Runnable
    // A a = new A();
    // Thread th = new Thread(a);
    // th.start();
}
