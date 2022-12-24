package lecture_2022_12.week_4_NetWork;

public class ThreadEx extends Thread {
    
    @Override
    public void run() {
        
        for ( int i = 0; i < 100; i++ ) {
            System.out.println( ( i + 1 ) + " run" );
        }
    }
    
    public static void main( String[] args ) {
        ThreadEx th = new ThreadEx();
        th.start(); // Thread는 각각 동시에 개별로 돌아간다.
        
        for ( int i = 0; i < 100; i++ ) {
            System.out.println( ( i + 1 ) + " main" );
        }
    }
}
