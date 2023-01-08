package lecture_2022_12.week_4_CRUD;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SuppressWarnings( "serial" )
public class DeptView extends JFrame implements ActionListener {
    
    // 1번 브랜치
    
    private JPanel            northPanel, centerPanel;
    private JButton           button;
    private DefaultTableModel model;
    private JTable            table;
    private JScrollPane       scrollPane;
    Font                      font       = new Font( "맑은 고딕", Font.PLAIN, 10 );
    IUDialog                  dialog;
    DeptController            controller = new DeptController();
    
    public DeptView() {
        init();
    }
    
    protected void getData() {
        
        // 2번 브랜치가 수정한 메서드
        // ㅁㅂqwewq
        while ( model.getRowCount() > 0 ) {
            model.removeRow( 0 );
        }
        
        List<TeamInfo> tempList = controller.getTeam();
        log.info( tempList );
        
        for ( TeamInfo team : tempList ) {
            Object[] temp = { team.teamNumber, team.teamName, team.teamLoc, team.memberNumber };
            // tempList.get( 0 ).teamNumber == team.teamNumber
            model.addRow( temp );
        }
    }
    
    public void init() {
        // 1번 브랜치 수정사항
        // ㅁ
        // ㅁ
        // ㅁ
        // ㅁㅇㅁㄴ
        //
        // ㄴ
        northPanel = new JPanel( new FlowLayout( FlowLayout.RIGHT ) );
        centerPanel = new JPanel();
        northPanel.setBackground( Color.cyan );
        
        String[] buttonText = { "INSERT", "SELECT", "UPDATE", "DELETE", "CLOSE" };
        
        for ( int i = 0; i < buttonText.length; i++ ) {
            button = new JButton( buttonText[i] );
            button.addActionListener( this );
            northPanel.add( button );
        }
        String[] columnNames = { "팀 번호", "팀 네임", "팀 위치", "팀원 수" };
        model = new DefaultTableModel( columnNames, 0 );
        table = new JTable( model );
        scrollPane = new JScrollPane( table );
        centerPanel.add( scrollPane );
        this.add( "North", northPanel );
        this.add( "Center", centerPanel );
        this.setSize( 800, 700 );
        this.setVisible( true );
        this.setDefaultCloseOperation( EXIT_ON_CLOSE );
    }
    
    @Override
    public void actionPerformed( ActionEvent e ) {
        String cmd = e.getActionCommand();
        
        switch ( cmd ) {
            case "SELECT":
                getData();
                break;
            
            case "INSERT":
                dialog = new IUDialog( this, cmd );
                break;
            
            case "UPDATE":
                
                if ( table.getSelectedRow() != -1 ) {
                    dialog = new IUDialog( this, cmd );
                    Object[] temp = new Object[4];
                    
                    for ( int i = 0; i < model.getColumnCount(); i++ ) {
                        temp[i] = model.getValueAt( table.getSelectedRow(), i ); // 10 - 인사 - 송파 - 7
                    }
                    int    teamNumber   = Integer.parseInt( String.valueOf( temp[0] ) );
                    String teamName     = String.valueOf( temp[1] );
                    String teamLoc      = String.valueOf( temp[2] );
                    int    memberNumber = Integer.parseInt( String.valueOf( temp[3] ) );
                    log.info( Arrays.toString( temp ) );
                    dialog.setText( teamNumber, teamName, teamLoc, memberNumber );
                }
                else {
                    JOptionPane.showMessageDialog( null, "수정 실패 (사유 : 선택된 레코드가 없습니다.)" );
                }
                break;
            
            case "DELETE":
                if ( table.getSelectedRow() != -1 ) {
                    int teamNumber = ( Integer ) model.getValueAt( table.getSelectedRow(), 0 );
                    
                    int result = controller.cudTeam( TeamInfo.builder().teamNumber( teamNumber ).build(), "DELETE" );
                    
                    if ( result == 1 ) {
                        JOptionPane.showMessageDialog( null, "선택하신 열의 팀 정보가 삭제되었습니다." );
                        getData();
                    }
                }
                break;
            
            case "CLOSE":
                this.dispose();
                break;
            
            case "SAVE":
                
                int result = controller.cudTeam( dialog.getText( TeamInfo.builder().build() ), dialog.cmd );
                if ( dialog.cmd.equals( "INSERT" ) ) {
                    
                    if ( result == 1 ) {
                        JOptionPane.showMessageDialog( null, "팀 입력 성공" );
                        dialog.dispose();
                        getData();
                    }
                    else {
                        JOptionPane.showMessageDialog( null, "입력 실패 ( 사유 : 부서 번호가 중복되었습니다.)" );
                    }
                }
                else {
                    
                    if ( result == 1 ) {
                        getData();
                        JOptionPane.showMessageDialog( null, "선택하신 팀 번호 정보를 변경하였습니다." );
                        dialog.dispose();
                    }
                    else {
                        JOptionPane.showMessageDialog( null, "수정 실패 ( 사유 : 일치하는 부서 번호가 없습니다.)" );
                    }
                }
                
                break;
            
            case "EXIT":
                dialog.dispose();
                break;
        }
    }
    
    public static void main( String[] args ) {
        new DeptView();
    }
}
