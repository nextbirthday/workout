package singleton;

public class Singleton1 {
    
    // 클래스 변수로 선언
    private static Singleton1 instance;
    
    // 생성자(Constructor)를 통한 인스턴스화(Instantiation) 방지를 위하여 private
    private Singleton1() {}
    
    /**
     * Singleton1 클래스 타입 인스턴스가 null인지 확인한 후
     * 인스턴스가 존재하면 인스턴스를, null일 경우 인스턴스화를 하고 하나의 인스턴스만 리턴
     * <p>
     * <b>MultiThread 환경에서 Thread-safe 하지 않음에 주의</b>
     * 
     * @return Singleton1 타입 인스턴스
     */
    public static Singleton1 getInstance() {
        if ( instance == null )
            instance = new Singleton1();
        return instance;
    }
}
