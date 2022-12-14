package b3_1214;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Sub implements ActionListener {
    
    Main main = null; // 선언만 했다. null의 의미 : 결정되지 않았다. -원본을 사용하겠다는 뜻
    
    // Main main = new Main(); 선언과 동시에 생성도 했고 생성자도 호출한다. - 복제본이 만들어짐
    // ↑ 왜 복제본일까?
    
    JDialog dialog  = new JDialog();
    JButton jButton = new JButton( "저장" );
    JPanel  southPanel;
    
    public Sub( Main main ) { // Main main = null 의미가된다.
        System.out.println( main );
        
        if ( main == null ) {
            System.out.println( "main은 null입니다." + "객체 생성이 안된 상태입니다." );
        }
        // 나는 언제 호출되나요? Main app이 실행될 때
        // 나는 어디서 호출되나요 Main class에서
        // 나는 왜 호출되나요? 입력을 눌렀을 때, 주문을 할 때, 회원가입을 할 때... (insert)
        this.main = main; // 객체 치환
        initDisplay();
    }
    
    public Sub() {}
    
    public void initDisplay() {
        dialog.add( "South", jButton );
        dialog.setTitle( "Sub" );
        dialog.setSize( 800, 700 );
        dialog.setVisible( true );
        jButton.addActionListener( this );
    }
    
    int insert() { // 1: 입력 성공 0: 입력 실패
        
        return 1;
    }
    
    // Callback method (ex. save button이 click되었을 때 JVM이 감지하고 인터셉트하여 method 호출을 해준다.
    // parameter인 ActionEvent 객체를 통해서 event가 감지된 버튼을 구분할 수 있다.
    // 이 객체는 parameter에 있으므로 JVM으로부터 주입이 되는 객체이다.
    // 개발자가 instance화 하지 않고 JVM이 대신 해준다.
    @Override
    public void actionPerformed( ActionEvent e ) {
        Object obj = e.getSource();
        
        // 반복문을 탈출할 때는 break;문을 사용하고
        // 조건문을 탈출할 때는 return을 사용한다.
        if ( obj == jButton ) {
            int result = insert(); //insert(); method return value 1이 int type 변수 result에 저장
            
            if ( result == 1 ) {
                JOptionPane.showMessageDialog( dialog, "입력 성공하였습니다." );
            }
            else if ( result == 0 ) {
                JOptionPane.showMessageDialog( dialog, "입력 실패하였습니다." );
                return; // actionPerformed를 탈출함
            }
            main.refresh(); // 메서드 호출 선언 위치가 매우 중요하다.
            dialog.dispose();
        }
    }
    
    // public static void main( String[] args ) {
    // new Sub( null ); 단위테스트를 위한 
    // }
    
}
