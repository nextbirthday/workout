package lecture_2023_01.week_1_Oracle;

import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings( "serial" )
public class MemberShipClone extends JFrame implements ActionListener {
    JPanel       jp_center     = new JPanel();
    JFileChooser myFileChooser = new JFileChooser();
    
    JLabel     jlb_zipcode  = new JLabel( "우편번호" );
    JTextField jtf_zipcode  = new JTextField( 6 );
    JButton    jbtn_zipcode = new JButton( "우편번호찾기" );
    
    JLabel     jlb_address = new JLabel( "주소" );
    JTextField jtf_address = new JTextField( 30 );
    
    JButton    jbtn_file = new JButton( "파일찾기" );
    JTextField jtf_file  = new JTextField( 45 );
    JLabel     jlb_img   = new JLabel( "이미지" );
    Container  cont      = this.getContentPane();
    
    ZipCodeSearchViewClone zcsv = new ZipCodeSearchViewClone( this );
    
    public void initDisplay() {
        jbtn_file.addActionListener( this );
        jbtn_zipcode.addActionListener( this );
        
        // 윈도우 리스너 설정 - 윈도우 창에서 x 버튼 눌렀을 때 창 닫기 구현
        this.addWindowListener( new WindowAdapter() {
            public void windowClosing( WindowEvent evt ) {
                System.out.println( "윈도우 종료" );
                System.exit( 0 );
            }
        } );
        jp_center.setLayout( null );
        jlb_zipcode.setBounds( 20, 20, 100, 20 );
        jtf_zipcode.setBounds( 120, 20, 100, 20 );
        jbtn_zipcode.setBounds( 230, 20, 120, 20 );
        
        jlb_address.setBounds( 20, 45, 100, 20 );
        jtf_address.setBounds( 120, 45, 250, 20 );
        
        jbtn_file.setBounds( 20, 70, 90, 20 );
        jtf_file.setBounds( 120, 70, 350, 20 );
        jlb_img.setBorder( BorderFactory.createEtchedBorder() );
        jlb_img.setBounds( 120, 95, 200, 270 );
        jp_center.add( jlb_zipcode );
        jp_center.add( jtf_zipcode );
        jp_center.add( jbtn_zipcode );
        jp_center.add( jlb_address );
        jp_center.add( jtf_address );
        jp_center.add( jbtn_file );
        jp_center.add( jtf_file );
        jp_center.add( jlb_img );
        this.add( "Center", jp_center );
        this.setTitle( "이미지 미리보기" );
        this.setSize( 500, 580 );
        this.setVisible( true );
    }
    
    @Override
    public void actionPerformed( ActionEvent e ) {
        Object obj = e.getSource();
        
        if ( jbtn_zipcode == obj ) {
            zcsv.setVisible( true );
        }
        
        if ( jbtn_file == obj ) {
            // [열기] 대화상자를 오픈한다
            myFileChooser.setCurrentDirectory( new File( "C:\\Users\\HOUSE 2nd\\Desktop\\[Oracle] ORA-01031 insufficient privileges_files" ) );
            int intRet = myFileChooser.showOpenDialog( MemberShipClone.this );
            
            // yes 혹은 ok 버튼이 눌린 경우
            if ( intRet == JFileChooser.APPROVE_OPTION ) {
                
                // 파일을 여는 처리를 수행한다
                try {
                    // 읽어들이기용 String 객체
                    String strLine;
                    // FileChooser로 선택된 파일을 File 객체에 대입
                    File myFile = myFileChooser.getSelectedFile();
                    // 선택된 파일의 절대 경로를 지정하여
                    // BufferedReader 객체를 작성
                    BufferedReader myReader = new BufferedReader( new FileReader( myFile.getAbsolutePath() ) );
                    System.out.println( "myFile.getAbsolutePath():" + myFile.getAbsolutePath() );
                    String cpath = "";
                    cpath = myFile.getAbsolutePath();
                    jtf_file.setText( myFile.getAbsolutePath() );
                    /////////////////////// 이미지 미리보기 시작 //////////////////////
                    ImageIcon originIcon = new ImageIcon( cpath );
                    // ImageIcon에서 Image를 추출
                    Image originImg = originIcon.getImage();
                    // 추출된 Image의 크기를 조절하여 새로운 Image객체 생성
                    Image changedImg = originImg.getScaledInstance( 200, 270, Image.SCALE_SMOOTH );
                    // 새로운 Image로 ImageIcon객체를 생성
                    ImageIcon Icon = new ImageIcon( changedImg );
                    jlb_img.setIcon( Icon );
                    /*
                     * revalidate새 구성 요소가 추가되거나 이전 구성 요소가 제거되면 컨테이너에서 호출됩니다. 이 호출은 레이아웃 관리자에게 새 구성
                     * 요소 목록을 기반으로 재설정하도록 지시하는 명령입니다.
                     */
                    cont.revalidate();
                    /////////////////////// 이미지 미리보기 끝 //////////////////////
                }
                catch ( IOException ie ) {}
            } ///////// end of if
        }
    }
    
    public static void main( String[] args ) {
        MemberShipClone msc = new MemberShipClone();
        msc.initDisplay();
    }
    
}
