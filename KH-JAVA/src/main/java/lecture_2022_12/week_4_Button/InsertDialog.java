package lecture_2022_12.week_4_Button;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import lecture_2022_12.week_4_List.DepartmentDTOBuilder;

@SuppressWarnings( "serial" )
public class InsertDialog extends JDialog implements ActionListener {
    
    DepartmentView view;
    
    JPanel centerPanel = new JPanel();
    JPanel southPanel  = new JPanel();
    
    JScrollPane centerScrollPane = new JScrollPane( centerPanel );
    
    JLabel     deptnoLabel            = new JLabel( "부서번호" );
    JTextField deptnoTextField        = new JTextField( 10 );
    JButton    duplicationCheckButton = new JButton( "중복체크" );
    JLabel     nameLabel              = new JLabel( "부서명" );
    JTextField nameTextField          = new JTextField( 20 );
    JLabel     locLabel               = new JLabel( "지역" );
    JTextField locTextField           = new JTextField( 20 );
    
    JButton saveButton      = new JButton( "저장" );
    JButton closeButton     = new JButton( "CLOSE" );
    JButton autoInputButton = new JButton( "자동입력" );
    
    DepartmentDTOBuilder dto = null;
    
    public InsertDialog() {}
    
    public InsertDialog( DepartmentView view ) {
        this.view = view;
        initDisplay();
    }
    
    public void initDisplay() {
        saveButton.addActionListener( this );
        closeButton.addActionListener( this );
        autoInputButton.addActionListener( this );
        duplicationCheckButton.addActionListener( this );
        
        centerPanel.setLayout( null );
        southPanel.setLayout( new FlowLayout( FlowLayout.RIGHT ) );
        deptnoLabel.setBounds( 20, 20, 100, 20 );
        deptnoTextField.setBounds( 120, 20, 100, 20 );
        duplicationCheckButton.setBounds( 220, 20, 120, 20 );
        nameLabel.setBounds( 20, 45, 100, 20 );
        nameTextField.setBounds( 120, 45, 150, 20 );
        locLabel.setBounds( 20, 70, 100, 20 );
        locTextField.setBounds( 120, 70, 150, 20 );
        
        centerPanel.add( deptnoLabel );
        centerPanel.add( deptnoTextField );
        centerPanel.add( duplicationCheckButton );
        centerPanel.add( nameLabel );
        centerPanel.add( nameTextField );
        centerPanel.add( locLabel );
        centerPanel.add( locTextField );
        
        southPanel.add( saveButton );
        southPanel.add( closeButton );
        southPanel.add( autoInputButton );
        
        this.add( "Center", centerPanel );
        this.add( "South", southPanel );
        this.setSize( 400, 360 );
        this.setVisible( false );
    }
    
    // 각 column(부서번호, 부서명, 지역)의 값들을 설정하거나 읽어오는 getter/setter
    
    public String getDeptno() { return deptnoTextField.getText(); }
    
    public void setDeptno( String deptno ) {
        deptnoTextField.setText( deptno );
    }
    
    public String getDname() { return nameTextField.getText(); }
    
    public void setDname( String dName ) {
        nameTextField.setText( dName );
    }
    
    public String getLoc() { return locTextField.getText(); }
    
    public void setLoc( String loc ) {
        locTextField.setText( loc );
    }
    
    // 아래 method는 DepartmentView에서 call
    
    public void set( String title, boolean isView, DepartmentDTOBuilder dto, boolean isEdit ) {
        this.setTitle( title );
        this.setVisible( isView );
        this.dto = dto;
        setEditable( isEdit );
        setValue( dto );
    }
    
    private void setEditable( boolean isEdit ) { // 입력 혹은 수정일 때는 true, 상세보기는 false
        deptnoTextField.setEditable( isEdit );
        nameTextField.setEditable( isEdit );
        locTextField.setEditable( isEdit );
    }
    
    public void setValue( DepartmentDTOBuilder dto ) {
        
        if ( dto == null ) { // 입력을 위한 윈도우 설정 - 모든 값을 빈 문자열로 setting
            setDeptno( "" );
            setDname( "" );
            setLoc( "" );
        }
        // 상세조회, 수정시에는 배열로 받은 값으로 setting
        // 부모창에서 set method 호출 시 파라미터로 넘겨준 값으로 초기화할 것
        else {
            setDeptno( String.valueOf( dto.getDeptno() ) );
            setDname( dto.getDname() );
            setLoc( dto.getLoc() );
        }
    }
    
    @Override
    public void actionPerformed( ActionEvent e ) {
        Object object = e.getSource();
        
        /*
         * record가 존재하면 수정모드, 아니면 입력모드로 처리한다.
         * 다이얼로그 화면에서 저장버튼 하나로 경우에 따라 입력처리와 수정처리를 한다.
         * 부모창에서 버튼이 눌러졌을 때 set method 호출하는데 입력이면
         * 3번째 파라미터에 null을 입력하고 수정이라면 JTable에서 선택된 row의 index로
         * DepartmentDTOBuilder를 추출해서 세번 째 파라미터에 null 대신 입력해준다.
         */
        
        if ( object == saveButton ) {
            
            if ( dto != null ) {
                
                for ( int i = 0; i < DepartmentView.dataBase.size(); i++ ) {
                    DepartmentDTOBuilder comVO = DepartmentView.dataBase.get( i );
                    // 부모창에서 (set method third parameter)받아온 부서번호와
                    // List에서 꺼낸 DepartmentDTOBuilder 부서번호가 같은지 비교
                    
                    if ( dto.getDeptno() == comVO.getDeptno() ) {
                        DepartmentDTOBuilder updateDTO = DepartmentDTOBuilder.builder().deptno( Integer.parseInt( getDeptno() ) ).dname( getDname() ).loc( getLoc() ).build();
                        DepartmentView.dataBase.remove( i );
                        DepartmentView.dataBase.add( i, updateDTO );
                        break;
                    }
                    view.refreshData();
                    this.dispose();
                }
            }
            else {
                DepartmentDTOBuilder insertDTO = DepartmentDTOBuilder.builder().deptno( Integer.parseInt( getDeptno() ) ).dname( getDname() ).loc( getLoc() ).build();
                System.out.println( "Before : " + DepartmentView.dataBase.size() );
                DepartmentView.dataBase.add( insertDTO );
                System.out.println( "After : " + DepartmentView.dataBase.size() );
                view.refreshData();
                this.dispose();
            }
        }
        else if ( object == autoInputButton ) {
            setDeptno( "50" );
            setDname( "인사팀" );
            setLoc( "을지로" );
        }
    }
    
    public static void main( String[] args ) {
        new InsertDialog( null );
    }
}
