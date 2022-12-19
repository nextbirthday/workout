package lecture_2022_12.week_4_Dept;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings( "serial" )
public class DeptView extends JFrame implements ActionListener {
    
    JPanel            northPanel, centerPanel;
    JButton           button;
    DefaultTableModel model;
    JTable            table;
    JScrollPane       scrollPane;
    
    DeptController controller = new DeptController();
    InsertDialog   dialog;
    
    private DeptView() {
        initialize();
    }
    
    private void initialize() {
        northPanel = new JPanel( new FlowLayout( FlowLayout.RIGHT ) );
        northPanel.setBackground( Color.ORANGE );
        
        String[] buttonText  = { "조회", "입력", "수정", "삭제", "상세보기", "CLOSE" };
        String[] columnNames = { "부서번호", "부서명", "지역" };
        
        for ( int i = 0; i < buttonText.length; i++ ) {
            button = new JButton( buttonText[i] );
            button.setActionCommand( buttonText[i] );
            button.addActionListener( this );
            northPanel.add( button );
        }
        centerPanel = new JPanel();
        model = new DefaultTableModel( columnNames, 0 );
        table = new JTable( model );
        scrollPane = new JScrollPane( table );
        centerPanel.add( scrollPane );
        
        this.add( "North", northPanel );
        this.add( "Center", centerPanel );
        this.setSize( 700, 600 );
        this.setDefaultCloseOperation( EXIT_ON_CLOSE );
        this.setVisible( true );
    }
    
    @Override
    public void actionPerformed( ActionEvent e ) {
        String cmd    = e.getActionCommand();
        int    result = -1;
        
        // 조회(SELECT) 부분을 메서드로 분리하면 입력, 수정, 삭제시
        // 메서드 호출로 테이블을 새로고침 할 수 있음.
        switch ( cmd ) {
            case "조회":
                if ( model.getRowCount() > 0 ) {
                    
                    // while ( model.getRowCount() > 0 ) {
                    // model.removeRow( 0 );
                    // }
                    for ( int i = model.getRowCount() - 1; i >= 0; i-- ) {
                        model.removeRow( 0 );
                    }
                }
                
                List<DeptDTO> records = controller.getDept();
                for ( DeptDTO dto : records ) {
                    Object[] row = { dto.getDeptno(), dto.getDName(), dto.getLoc() };
                    model.addRow( row );
                }
                if ( model.getRowCount() < 0 ) {
                    JOptionPane.showMessageDialog( this, "조회결과가 없습니다", "INFO", JOptionPane.WARNING_MESSAGE );
                }
                break;
            
            case "입력":
                dialog = new InsertDialog( this, true, "C" );
                break;
            
            case "수정":
                dialog = new InsertDialog( this, true, "U" );
                break;
            
            case "삭제":
                
                break;
            
            case "상세보기":
                break;
            
            case "CONFIRM":
                
                
                
                break;
            
            case "CLOSE":
                this.dispose();
                break;
        }
    }
    
    public static void main( String[] args ) {
        new DeptView();
    }
}
