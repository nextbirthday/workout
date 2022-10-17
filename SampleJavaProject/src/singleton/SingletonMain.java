package singleton;

public class SingletonMain {
    
    public static void main( String[] args ) {
        
        /* 현재는 main() 메서드 하나에서만 Singleton 클래스의 인스턴스를 사용하지만
         * 싱글턴 패턴을 이해하려면 먼저 스레드 개념을 이해하고,
         * 하나의 리소스에 대한 동시접근에서 '순서'에 대해 생각해야 한다.
         * 사용 중인 리소스에 락을 걸고 리턴할 때까지 다른 스레드의 접근을 막는 키워드가
         * Singleton2 클래스에 있는 synchronized 키워드이다.
         * (그러나 호출된 메서드가 리턴될 때까지 다른 스레드의 접근 자체를 막기 때문에 속도저하가 있음)
         * volatile 키워드 등을 사용하는 DCL(Double-checked locking) 방법도 있지만 생략한다.
         * Singleton3 클래스에서 사용한 LazyHolder 방법이 이 중에서는 가장 깔끔한 방법이라고 보면 됨 
         */
        
        Singleton1 s1_1 = Singleton1.getInstance();
        System.out.println( s1_1 );
        
        Singleton1 s1_2 = Singleton1.getInstance();
        System.out.println( s1_2 + "\n" );
        
        Singleton2 s2_1 = Singleton2.getInstance();
        System.out.println( s2_1 );
        
        Singleton2 s2_2 = Singleton2.getInstance();
        System.out.println( s2_2 + "\n" );
        
        Singleton3 s3_1 = Singleton3.getInstance();
        System.out.println( s3_1 );
        
        Singleton3 s3_2 = Singleton3.getInstance();
        System.out.println( s3_2 );
    }
}
