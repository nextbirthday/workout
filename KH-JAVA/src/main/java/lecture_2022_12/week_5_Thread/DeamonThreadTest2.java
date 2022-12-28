package lecture_2022_12.week_5_Thread;

/*
 * 상황에 따라 분리된 스레드로 백그라운드 작업을 해야 하는 경우도 있다.
 * JVM안의 가비지 컬렉션과 같은 작업이 대표적이다.
 * 이런 백그라운드 작업이 일반 스레드로 설정되어 있다면 전원이 종료되거나 사용자가 강제 종료하지 않는 한
 * 애플리케이션은 영원히 정지 하지 않을 것이다.
 * 
 */
public class DeamonThreadTest2 {
    
    public static void main( String[] args ) {
        Thread th = new Thread() {
            public void run() {
                
                try {
                    Thread.sleep( 5000 );
                    System.out.println( "MyThread 종료" );
                }
                catch ( InterruptedException e ) {
                    
                }
            }
        };
        // 데몬 스레드로 설정함.
        // 아래와 같이 데몬스레드를 설정하면 내부의 모든 스레드가 종료되지 않아도 어플리케이션이 종료된다.
        th.setDaemon( false );
        th.start();
        System.out.println( "main() 종료" );
    }/////////////// end of main
    
}