package singleton;

public class Singleton2 {
    
    private static Singleton2 instance;
    
    private Singleton2() {}
    
    /**
     * Singleton2 클래스 타입 인스턴스가 null인지 확인한 후
     * 인스턴스가 존재하면 인스턴스를, null일 경우 인스턴스화를 하고 하나의 인스턴스만 리턴
     * <p>
     * <b>Thread-safe 하지만 synchronized 키워드는 속도 저하를 유발함</b>
     * 
     * @return Singleton2 타입 인스턴스
     */
    public static synchronized Singleton2 getInstance() {
        if ( instance == null )
            instance = new Singleton2();
        return instance;
    }
}
