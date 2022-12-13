package b3_1213;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class StudentGradeUI implements ActionListener {
    
    String[]   header = { "이름", "국어", "영어", "수학", "총점", "평균", "석차" };
    String[][] data   = { { "홍길동", "80", "75", "85" }, { "이성계", "90", "85", "80" }, { "강감찬", "70", "75", "70" } };
    
    JFrame  jf;
    JButton calcButton, sampleButton, deleteButton, exitButton, createButton;
    JPanel  northPanel, centerPanel, southPanel;
    
    DefaultTableModel model = new DefaultTableModel( data, header );
    JTable            table = new JTable( model );
    
    private StudentGradeUI() {
        init();
    }
    
    public void init() {
        
        // 프레임 초기화
        jf.setTitle( "성적처리" );
        jf.setSize( 600, 500 );
        jf.setVisible( true );
        
        jf.add( "Center", centerPanel );
        jf.add( "North", northPanel );
        jf.add( "South", southPanel );
        
        createButton = new JButton( "만들기" );
        calcButton = new JButton( "연산" );
        sampleButton = new JButton( "3명 샘플" );
        deleteButton = new JButton( "지우기" );
        exitButton = new JButton( "종료" );
        
        jf.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        
        createButton.addActionListener( this );
        calcButton.addActionListener( this );
        sampleButton.addActionListener( this );
        deleteButton.addActionListener( this );
        exitButton.addActionListener( this );
    }
    
    public static void main( String[] args ) {
        new StudentGradeUI();
    }
    
    @Override
    public void actionPerformed( ActionEvent e ) {
        Object object = e.getSource();
        
        if ( object == createButton ) {
            
        }
        
    }
}
