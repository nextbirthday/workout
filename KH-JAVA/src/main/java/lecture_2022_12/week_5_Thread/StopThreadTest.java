package lecture_2022_12.week_5_Thread;

class StopThread implements Runnable {
    boolean stopped = false;
    
    @Override
    public void run() {
        
        while ( !stopped ) {// true
            System.out.println( "Thread is alive...." ); // 출력
            
            try {
                Thread.sleep( 500 ); // 0.5초 후 "Thread is alive...." 출력
            }
            catch ( InterruptedException e ) {
                e.printStackTrace();
            }
        }
        // 아래 코드는 9번과 16번 구간중 13번 에서 멈춰 있을 때 다른 스레드가 인터셉트 가능함
        System.out.println( "Thread is deaded" );
    }
    
    public void stop() {
        stopped = true;
    }
}

public class StopThreadTest {
    
    public static void main( String[] args ) {
        System.out.println( "main start" );
        StopThreadTest stt = new StopThreadTest();
        stt.process(); // stack 영역
        System.out.println( "main end" ); // app이 죽는다 - 메인스레드 회수
    }
    
    public void process() {
        StopThread st = new StopThread(); // 지역변수로 객체생성 - automatic 이 영역에서만 살고 죽는다.
        Thread     th = new Thread( st ); // 스레드 생성(객체 파라미터)
        th.start(); // run 호출
        
        try {
            Thread.sleep( 1000 );
        }
        catch ( InterruptedException e ) {
            e.printStackTrace();
        }
        st.stop();
    }
}
