package lecture_2022_12.week_5_Thread;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

// DeamonThreadTest.java - > DeamonThreadTest.class, DeamonThreadTest$1.class(익명클래스)
// Node.js, ES5,6,7 arrow function, 람다식 최신 문법의 base
public class DeamonThreadTest {
    JButton jButton = new JButton( "전송" );
    
    public DeamonThreadTest() {
        jButton.addActionListener( new ActionListener() {
            
            public void actionPerformed( ActionEvent ae ) {
                System.out.println( "전송 버튼 클릭" );
            }
        } );
    }
    
    public static void main( String[] args ) {
        Thread th = new Thread() {
            public void run() {
                
                try {
                    Thread.sleep( 5000 ); // 5초 동안 슬립
                    System.out.println( "MyThread 종료" );
                }
                catch ( InterruptedException e ) {
                    
                }
            }
        };
        // 데몬 스레드로 설정함.
        // 아래와 같이 데몬스레드를 설정(th.setDaemon(true))하면 내부의 모든 스레드가 종료되지 않아도 어플리케이션이 종료된다.
        // setDaemon을 사용하여 option을 true로 주면 thread와 상관없이 app을 강제종료시킨다.
        // 프로그램에서 처리하는 것과 상관없이 별개로 동작해야 하는 것들이 있다면
        // 이 메서드를 호출하지 말거나 추가했다면 false로 설정할 것.
        th.setDaemon( false );// false로 하면 MyThread 종료가 출력된다. 이문장이 없으면 false와 결과같음.
        th.start();
        System.out.println( "main() 종료" );
    }/////////////// end of main
}
