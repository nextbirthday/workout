package singleton;

public class Singleton3 {
    
    private Singleton3() {}
    
    /**
     * 내부 스태틱 클래스 LazyHolder 가 초기화되면서 Singleton3 타입
     * 인스턴스를 생성하고 그것을 리턴하는 메서드
     * 
     * @return 내부클래스에서 초기화한 final 인스턴스
     */
    public static Singleton3 getInstance() { return LazyHolder.INSTANCE; }
    
    /**
     * 내부 스태틱 클래스 LazyHoler
     * <p>
     * getInstance() 메서드가 호출될 때 초기화되며
     * JVM의 클래스 초기화는 비동시성을 보장하기 때문에 하나의 인스턴스만 생성되고,
     * final 키워드로 다른 값이 들어가는 것을 막는다
     * <p>
     * 그리고 MultiThread 환경에서 Thread-safe 를 보장하고 synchronized, volatile 키워드 등을 사용하는 것보다 성능 면에서도 우월하다
     * 
     * @author geundu
     * 
     */
    private static class LazyHolder {
        private static final Singleton3 INSTANCE = new Singleton3();
    }
}
