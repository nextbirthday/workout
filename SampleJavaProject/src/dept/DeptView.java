package dept;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    
    private void getDept() {
        
        if ( model.getRowCount() > 0 ) {
            
            while ( model.getRowCount() > 0 ) {
                model.removeRow( 0 );
            }
        }
        controller.getDept().forEach( e -> addRow( e ) );
    }
    
    private void addRow( DeptDTO dto ) {
        Object[] row = { dto.getDeptno(), dto.getDname(), dto.getLoc() };
        model.addRow( row );
    }
    
    @Override
    public void actionPerformed( ActionEvent e ) {
        String      cmd        = e.getActionCommand();
        Component[] components = null;
        int         index      = 0;
        int         result     = -1;
        
        switch ( cmd ) {
            /*
             * SELECT 부분을 메서드로 분리하면 INSERT, UPDATE, DELETE 시
             * 메서드 호출로 테이블을 새로고침 할 수 있음.
             */
            case "SELECT":
                getDept();
                break;
            
            // 커맨드만 다이얼로그로 넘겨주는 역할
            case "INSERT":
                dialog = new InsertDialog( this, Command.INSERT );
                break;
            
            // 테이블에서 선택한 레코드값을 다이얼로그로 전달
            case "UPDATE":
                if ( table.getSelectedRow() != -1 ) {
                    dialog = new InsertDialog( this, Command.UPDATE );
                    components = dialog.centerPanel.getComponents();
                    
                    for ( Component component : components ) {
                        if ( component instanceof JTextField )
                            ( ( JTextField ) component ).setText( String.valueOf( model.getValueAt( table.getSelectedRow(), index++ ) ) );
                    }
                }
                else {
                    JOptionPane.showMessageDialog( this, "수정할 레코드를 선택해주세요.", "ERROR", JOptionPane.ERROR_MESSAGE );
                }
                break;
            
            // deptno ( PK : Primary Key ) 기준으로 레코드 삭제
            case "DELETE":
                if ( table.getSelectedRow() != -1 ) {
                    int deptno = Integer.parseInt( String.valueOf( model.getValueAt( table.getSelectedRow(), 0 ) ) );
                    result = controller.cudDept( new DeptDTO( deptno, null, null ), Command.DELETE );
                    
                    if ( result == 1 ) {
                        log.info( result + " : DELETE 성공" );
                        getDept();
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
                
                components = dialog.centerPanel.getComponents();
                for ( Component component : components ) {
                    
                    if ( component instanceof JTextField ) {
                        userText[index++] = ( ( JTextField ) component ).getText();
                    }
                }
                
                try {
                    int    deptno = Integer.parseInt( userText[0] );
                    String dname  = userText[1];
                    String loc    = userText[2];
                    
                    if ( Command.INSERT.equals( command ) ) {
                        result = controller.cudDept( new DeptDTO( deptno, dname, loc ), command );
                        
                        if ( result == 1 ) {
                            log.info( result + " : INSERT 성공" );
                            getDept();
                        }
                        else
                            log.info( result + " : INSERT 실패" );
                    }
                    else {
                        result = controller.cudDept( new DeptDTO( deptno, dname, loc ), command );
                        
                        if ( result == 1 ) {
                            log.info( result + " : UPDATE 성공" );
                            getDept();
                        }
                        else
                            log.info( result + " : UPDATE 실패" );
                    }
                }
                catch ( NumberFormatException nfe ) {
                    JOptionPane.showMessageDialog( dialog, nfe + " : deptno는 정수만 입력할 수 있습니다." );
                    return;
                }
                dialog.dispose();
                
                break;
        }
    }
    
    public static void main( String[] args ) {
        new DeptView();
    }
}
