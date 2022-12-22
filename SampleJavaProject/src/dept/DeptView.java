package dept;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import lombok.extern.log4j.Log4j2;

@SuppressWarnings( "serial" )
@Log4j2
public class DeptView extends JFrame implements ActionListener {
    
    JPanel            northpanel, centerPanel;
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
        northpanel = new JPanel( new FlowLayout( FlowLayout.RIGHT ) );
        northpanel.setBackground( Color.ORANGE );
        
        String[] buttonText = { "SELECT", "INSERT", "UPDATE", "DELETE", "CLOSE" };
        Font     font       = new Font( "맑은 고딕", Font.BOLD, 15 );
        
        for ( int i = 0; i < buttonText.length; i++ ) {
            button = new JButton( buttonText[i] );
            button.setFont( font );
            button.setActionCommand( buttonText[i] );
            button.addActionListener( this );
            northpanel.add( button );
        }
        centerPanel = new JPanel();
        String[] columnNames = { "부서번호", "부서명", "지역" };
        model = new DefaultTableModel( columnNames, 0 );
        table = new JTable( model );
        scrollPane = new JScrollPane( table );
        centerPanel.add( scrollPane );
        
        this.add( "North", northpanel );
        this.add( "Center", centerPanel );
        this.setSize( 700, 600 );
        this.setDefaultCloseOperation( EXIT_ON_CLOSE );
        this.setVisible( true );
    }
    
    @Override
    public void actionPerformed( ActionEvent e ) {
        String cmd    = e.getActionCommand();
        int    result = -1;
        
        switch ( cmd ) {
            /*
             * SELECT 부분을 메서드로 분리하면 INSERT, UPDATE, DELETE 시
             * 메서드 호출로 테이블을 새로고침 할 수 있음.
             */
            case "SELECT":
                if ( model.getRowCount() > 0 ) {
                    
                    for ( int i = model.getRowCount() - 1; i >= 0; i-- ) {
                        model.removeRow( 0 );
                    }
                }
                List<DeptDTO> records = controller.getDept();
                
                for ( DeptDTO dto : records ) { // 자료형 변수명 : 배열명
                    Object[] row = { dto.getDeptno(), dto.getDname(), dto.getLoc() };
                    model.addRow( row );
                }
                
                break;
            
            // 다이얼로그만 열어주는 역할
            case "INSERT":
                dialog = new InsertDialog( this, "C" );
                break;
            
            // 다이얼로그만 열어주는 역할
            case "UPDATE":
                /*
                 * UPDATE 시 다이얼로그에 선택한 레코드 정보 텍스트필드에 불러오기 필요
                 */
                dialog = new InsertDialog( this, "U" );
                break;
            
            case "DELETE":
                if ( table.getSelectedRow() != -1 ) { // index는 0부터 시작이니까
                    int deptno = Integer.parseInt( String.valueOf( model.getValueAt( table.getSelectedRow(), 0 ) ) );
                    result = controller.cudDept( new DeptDTO( deptno, null, null ), "D" );
                    
                    if ( result == 1 ) {
                        log.info( result + " : DELETE 성공" );
                    }
                    else
                        log.error( result + " : DELETE 실패" );
                }
                else {
                    JOptionPane.showMessageDialog( this, "삭제할 레코드를 선택해주세요.", "ERROR", JOptionPane.ERROR_MESSAGE );
                }
                break;
            
            case "CLOSE":
                this.dispose();
                break;
            
            // INSERT, UPDATE 로직은 CONFIRM에서 수행된다.
            case "CONFIRM":
                String[] userText = new String[3];
                String command = dialog.cmd;
                int index = 0;
                
                int deptno = 0;
                String dname = "";
                String loc = "";
                
                Component[] components = dialog.centerPanel.getComponents();
                for ( Component component : components ) {
                    
                    if ( component instanceof JTextField ) {
                        userText[index++] = ( ( JTextField ) component ).getText();
                    }
                }
                
                try {
                    deptno = Integer.parseInt( userText[0] );
                }
                catch ( NumberFormatException nfe ) {
                    JOptionPane.showMessageDialog( dialog, nfe + " : deptno는 정수만 입력할 수 있습니다." );
                    return;
                }
                dname = userText[1];
                loc = userText[2];
                
                dialog.dispose();
                
                if ( "C".equals( command ) ) {
                    result = controller.cudDept( new DeptDTO( deptno, dname, loc ), command );
                    if ( result == 1 )
                        log.info( result + " : INSERT 성공" );
                    else
                        log.info( result + " : INSERT 실패" );
                }
                else {
                    result = controller.cudDept( new DeptDTO( deptno, dname, loc ), command );
                    if ( result == 1 )
                        log.info( result + " : UPDATE 성공" );
                    else
                        log.info( result + " : UPDATE 실패" );
                }
                break;
        }
    }
    
    public static void main( String[] args ) {
        new DeptView();
    }
}
