package temp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings( "serial" )
public class GradeCalculatorView extends JFrame {
    
    GradeCalculatorLogic logic;
    
    JPanel            centerPanel, northPanel;
    JButton           button;
    DefaultTableModel model;
    JTable            table;
    JScrollPane       scrollPane;
    
    public GradeCalculatorView() {
        logic = new GradeCalculatorLogic( this );
        init();
    }
    
    private void init() {
        this.setTitle( "학점 계산기" );
        this.setLayout( new BorderLayout() );
        this.setSize( 700, 600 );
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        
        String[]   columnNames = { "이름", "국어", "영어", "수학", "총점", "평균", "석차" };
        String[][] data        = { { "홍길동", "80", "75", "85" }, { "이성계", "90", "85", "80" }, { "강감찬", "70", "75", "70" } };
        model = new DefaultTableModel( data, columnNames );
        table = new JTable( model );
        table.setEnabled( false );
        scrollPane = new JScrollPane( table );
        
        centerPanel = new JPanel( new BorderLayout() );
        centerPanel.add( "Center", scrollPane );
        
        northPanel = new JPanel( new FlowLayout() );
        northPanel.setBackground( Color.ORANGE );
        
        String[] buttonText = { "편집(토글)", "계산", "삭제", "종료" };
        
        for ( int i = 0; i < buttonText.length; i++ ) {
            button = new JButton( buttonText[i] );
            button.addActionListener( logic );
            northPanel.add( button );
        }
        this.add( "Center", centerPanel );
        this.add( "North", northPanel );
        this.setVisible( true );
    }
    
    public static void main( String[] args ) {
        new GradeCalculatorView();
    }
}
