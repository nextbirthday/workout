package b3_1212;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JTextAreaUI implements ActionListener {
   
    // 선언부
    JTextAreaUILogic jtaUILogic = new JTextAreaUILogic( this );
    JFrame           jf         = new JFrame();
    JTextArea        jta        = new JTextArea( 10, 20 );
    JTextField       jtf        = new JTextField( 10 );
    
    // ActionListener aListener = new ActionListener();
    // 인터페이스는 반드시 구현체클래스가 있어야 한다.
    // 단독으로 인스턴스화 불가
    
    // ActionListener aListener = new JTextAreaUI();
    // 선언부와 생성부의 타입이 다르다. - 그래서 다형성이 가능하다.
    // -폴리모피즘 - 재사용성을 높이고 결합도는 낮추는 코드를 작성하는 인스턴스화 방법
    
    public JTextAreaUI() { // default constructor 선언
        initDisplay();
    }
    
    public void initDisplay() { 
        // UI를 그려주는 method + event 처리
        // 이벤트소스와 이벤트 핸들러 클래스 매핑하기(매칭)
        
        jtf.addActionListener( this );
        // 추상 메서드 (abstract method)선언은 interface 안에서 일어난다.
        // 추상 메서드는 메서드 호출이 아닌데 ;(세미콜론)으로 끝난다.
        // 추상 메서드는 정의할 수 없다. 결정되지 않았다. 구현 내용이 달라진다. (device가)
        // 추상 메서드를 가지고 있다는 것은 재정의를 해줘야 한다는 뜻이다.
        // 'method overriding'
        // parameter자리에 this(나 자신) event handler class의 주소번지가 와야한다.
        // ActionListener는 interface - 구현체 클래스를 가져야한다.
        // method override를 해야한다.
        // 인터페이스 중심의 코딩을 전개하는 것이 클래스간의 결합도를 낮춰주고 재사용성은 높여주는 코딩 방법이다.
        
        // 멀티라인 작성 가능한 컴포넌트 배경색 설정
        jta.setBackground( Color.cyan );
        // JFrame은 default layout이 BorderLayout이라서 동,서,남,북,중앙 배치 가능
        jf.add( "Center", jta ); // JTextArea는 중앙에 배치함
        jf.add( "South", jtf ); // 남쪽에는 JTextField 배치함
        jf.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); // window 창 x 버튼 클릭시 자원회수
        jf.setSize( 400, 300 ); // 윈도우 창 가로 세로 크기 설정
        jf.setVisible( true ); // 화면을 출력
    }
    
    public static void main( String[] args ) { // entry point
        new JTextAreaUI(); // constructor 호출되고 그 안에 화면 그리는 메서드 호출됨
        // new JTextAreaUI(); 생성자 호출을 두 번 했을 때 어떻게 될지?
        // Java의 static과 instance와 차이점
    }
    
    // 메서드 오버라이드는 선언부를 절대로 손댈 수 없다.
    // 접근제한자 리턴타입 메서드이름 파라미터
    @Override // annotation
    public void actionPerformed( ActionEvent e ) {
        // 추상 메서드의 parameter를 통해서 감지된 컴포넌트의 주소번지를 얻어오는
        // ActionEvent class가 getSource 메서드의 소유주이다.
        
        Object obj = e.getSource();
        
        if ( jtf == obj ) {
            // JTextField에 입력한 문자열 받기
            String input = jtf.getText();
            jta.append( "JTextAreaUI원본 : " + input + "\n" );
            jtaUILogic.account( input ); //Logic에서 찍어온 String input
            jtf.setText( "" );
        }
    }
}
