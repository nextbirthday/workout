package b3_1214;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings( "serial" )
public class StudentGradeUI extends JFrame {
    
    StudentGradeLogic logic;
    
    JButton    button;
    JButton    createButton = new JButton( "만들기" );
    JPanel     northPanel   = new JPanel();
    JPanel     southPanel   = new JPanel();
    JPanel     centerPanel  = new JPanel();
    JLabel     north1       = new JLabel( "성적처리인원수:" );
    JLabel     north2       = new JLabel( "명" );
    JTextField jta          = new JTextField( 25 );
    
    DefaultTableModel model;
    JTable            table;
    JScrollPane       scrollPane;
    
    public StudentGradeUI() {
        logic = new StudentGradeLogic( this );
        init();
    }
    
    public void init() {
        this.setTitle( "성적 처리" );
        this.setLayout( new BorderLayout() );
        this.setSize( 700, 600 );
        
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        
        String[] buttonText = { "연산", "3명 샘플", "지우기", "종료" };
        
        for ( int i = 0; i < buttonText.length; i++ ) {
            button = new JButton( buttonText[i] );
            button.addActionListener( logic );
            southPanel.add( button );
        }
        createButton.addActionListener( logic );
        this.add( "North", northPanel );
        northPanel.add( north1 );
        northPanel.add( jta );
        northPanel.add( north2 );
        northPanel.add( createButton );
        southPanel.setLayout( new FlowLayout( FlowLayout.RIGHT ) );
        
        String[]   header = { "이름", "국어", "영어", "수학", "총점", "평균", "석차" };
        String[][] data   = { { "홍길동", "80", "75", "85" }, { "이성계", "90", "85", "80" }, { "강감찬", "70", "75", "70" } };
        model = new DefaultTableModel( data, header );
        table = new JTable( model );
        table.setEnabled( false );
        scrollPane = new JScrollPane( table );
        
        northPanel = new JPanel( new FlowLayout() );
        northPanel.setBackground( Color.ORANGE );
        
        centerPanel = new JPanel( new BorderLayout() );
        centerPanel.add( "Center", scrollPane );
        
        this.add( "Center", centerPanel );
        
        this.add( "South", southPanel );
        
        this.setVisible( true );
    }
    
    public static void main( String[] args ) {
        new StudentGradeUI();
    }
}
