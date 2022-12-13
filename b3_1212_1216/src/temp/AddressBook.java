package temp;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AddressBook implements ActionListener {
    
    private AddressDialog addressDialog;
    private JFrame        frame;
    private JPanel        northPanel, centerPanel;
    private JButton       selectButton, insertButton, updateButton, detailButton;
    
    public AddressBook() {
        initDisplay();
    }
    
    private void initDisplay() {
        frame = new JFrame( "AddressBook ver 1.0" );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setSize( 600, 500 );
        
        northPanel = new JPanel();
        northPanel.setLayout( new FlowLayout( 0 ) );
        
        selectButton = new JButton( "조회" );
        insertButton = new JButton( "입력" );
        updateButton = new JButton( "수정" );
        detailButton = new JButton( "상세보기" );
        
        selectButton.addActionListener( this );
        insertButton.addActionListener( this );
        updateButton.addActionListener( this );
        detailButton.addActionListener( this );
        
        northPanel.add( selectButton );
        northPanel.add( insertButton );
        northPanel.add( updateButton );
        northPanel.add( detailButton );
        
        centerPanel = new JPanel();
        centerPanel.setBackground( Color.ORANGE );
        
        frame.add( "North", northPanel );
        frame.add( "Center", centerPanel );
        frame.setVisible( true );
    }
    
    @Override
    public void actionPerformed( ActionEvent e ) {
        Object obj = e.getSource();
        
        if ( obj == selectButton ) {
            /*
             * 1. addressDialog 를 인스턴스화하고, changeTitle( String title ) 을 호출
             * 각 버튼의 getText() 메서드를 이용하여 버튼 이름을 가져와 파라미터로 넘긴다.
             */
//            addressDialog = new AddressDialog();
//            addressDialog.changeTitle( selectButton.getText(), true );
            
            /*
             * 2. 생성자를 이용하여 다이얼로그 인스턴스 생성과 동시에 버튼 이름을 파라미터로 받아 타이틀을 설정한다.
             */
            addressDialog = new AddressDialog( selectButton.getText() );
            
            /*
             * 3. 생성자, changeTitle() 메서드를 사용하지 않고 다이얼로그 참조변수를 직접 사용한다.
             * AddressDialog 클래스의 dialog 변수의 Access modifier 를 private 으로 설정할 경우 접근할 수 없다.
             * ('protected' Access modifier 는 같은 패키지, 혹은 Child class만 접근할 수 있음)
             */
            // addressDialog = new AddressDialog();
            // addressDialog.dialog.setTitle( selectButton.getText() );
        }
//        else if ( obj == insertButton ) {
//            addressDialog = new AddressDialog();
//            addressDialog.changeTitle( insertButton.getText(), true );
//            
//            // addressDialog = new AddressDialog( insertButton.getText() );
//            
//            // addressDialog = new AddressDialog();
//            // addressDialog.dialog.setTitle( insertButton.getText() );
//        }
//        else if ( obj == updateButton ) {
//            addressDialog = new AddressDialog();
//            addressDialog.changeTitle( updateButton.getText(), true );
//            
//            // addressDialog = new AddressDialog( updateButton.getText() );
//            
//            // addressDialog = new AddressDialog();
//            // addressDialog.dialog.setTitle( updateButton.getText() );
//        }
//        else {
//            addressDialog = new AddressDialog();
//            addressDialog.changeTitle( detailButton.getText(), true );
//            
//            // addressDialog = new AddressDialog( detailButton.getText() );
//            
//            // addressDialog = new AddressDialog();
//            // addressDialog.dialog.setTitle( detailButton.getText() );
//        }
    }
    
    public static void main( String[] args ) {
        new AddressBook();
    }
}
