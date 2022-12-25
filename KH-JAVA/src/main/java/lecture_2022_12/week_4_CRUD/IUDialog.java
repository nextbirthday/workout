package lecture_2022_12.week_4_CRUD;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SuppressWarnings( "serial" )
public class IUDialog extends JDialog {
    DeptView view;
    String   cmd = "";
    
    public IUDialog() {}
    
    public IUDialog( DeptView view, String cmd ) {
        log.info( cmd );
        this.view = view;
        this.cmd = cmd;
        init();
    }
    
    private JButton saveButton = new JButton( "SAVE" );
    private JButton exitButton = new JButton( "EXIT" );
    private JPanel  centerPanel, southPanel;
    
    private JLabel     teamNumberLabel   = new JLabel( "팀 번호" );
    private JLabel     teamNameLabel     = new JLabel( "팀 이름" );
    private JLabel     teamLocLabel      = new JLabel( "팀 위치" );
    private JLabel     memberNumberLabel = new JLabel( "팀원 수" );
    private JTextField teamNumberField   = new JTextField( 2 );
    private JTextField teamNameField     = new JTextField( 2 );
    private JTextField teamLocField      = new JTextField( 2 );
    private JTextField memberNumberField = new JTextField( 2 );
    
    public TeamInfo getText( TeamInfo data ) {
        data.setTeamNumber( Integer.parseInt( teamNumberField.getText() ) );
        data.setTeamName( teamNameField.getText() );
        data.setTeamLoc( teamLocField.getText() );
        data.setMemberNumber( Integer.parseInt( memberNumberField.getText() ) );
        log.info( data.toString() );
        return data;
    }
    
    public void setText( int teamNumber, String teamName, String teamLoc, int memberNumber ) {
        log.info( "teamNumber = " + teamNumber + " teamName = " + teamName + " teamLoc = " + teamLoc + "memberNumber = " + memberNumber );
        teamNumberField.setText( String.valueOf( teamNumber ) );
        teamNameField.setText( teamName );
        teamLocField.setText( teamLoc );
        memberNumberField.setText( String.valueOf( memberNumber ) );
        teamNumberField.setEditable( false );
        
    }
    
    private void init() {
        centerPanel = new JPanel( ( new GridLayout( 4, 1 ) ) );
        southPanel = new JPanel( new FlowLayout( FlowLayout.RIGHT ) );
        
        centerPanel.add( teamNumberLabel );
        centerPanel.add( teamNumberField );
        centerPanel.add( teamNameLabel );
        centerPanel.add( teamNameField );
        centerPanel.add( teamLocLabel );
        centerPanel.add( teamLocField );
        centerPanel.add( memberNumberLabel );
        centerPanel.add( memberNumberField );
        
        saveButton.addActionListener( view );
        exitButton.addActionListener( view );
        
        southPanel.add( saveButton );
        southPanel.add( exitButton );
        this.add( "Center", centerPanel );
        this.add( "South", southPanel );
        this.setSize( 500, 400 );
        this.setVisible( true );
        this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
    }
}
