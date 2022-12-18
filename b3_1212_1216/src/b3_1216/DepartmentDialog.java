package b3_1216;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DepartmentDialog {
    
    DepartmentView view         = null;
    JDialog        dialog       = new JDialog();
    JLabel         deptno_label = new JLabel( "부서번호" );
    JLabel         dName_label  = new JLabel( "부서명" );
    JLabel         loc_label    = new JLabel( "지역" );
    JPanel         southPanel   = new JPanel( new FlowLayout( FlowLayout.RIGHT ) );
    JPanel         centerPanel  = new JPanel( new GridLayout( 3, 2 ) );
    JTextField     deptno_text  = new JTextField();
    JTextField     dName_text   = new JTextField();
    JTextField     loc_text     = new JTextField();
    
    JButton confirmButton = new JButton( "확인" );
    JButton cancelButton  = new JButton( "취소" );
    
    public DepartmentDialog( DepartmentView view, boolean isView ) {
        this.view = view;
        init( isView );
    }
    
    void init( boolean isView ) {
        southPanel.add( confirmButton );
        southPanel.add( cancelButton );
        centerPanel.add( deptno_label );
        centerPanel.add( deptno_text );
        centerPanel.add( dName_label );
        centerPanel.add( dName_text );
        centerPanel.add( loc_label );
        centerPanel.add( loc_text );
        dialog.add( "South", southPanel );
        dialog.add( "Center", centerPanel );
        confirmButton.addActionListener( view );
        cancelButton.addActionListener( view );
       
        dialog.setSize( 500, 400 );
        dialog.setVisible( isView );
        dialog.setDefaultCloseOperation( JDialog.DISPOSE_ON_CLOSE );
    }
}
