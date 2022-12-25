package lecture_2022_12.week_4_Calc;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.StringTokenizer;

@SuppressWarnings( "serial" )
public class CalcView extends JFrame implements ActionListener {
    static Scanner scanner   = new Scanner( System.in );
    CalcLogic      calcLogic = new CalcLogic();
    
    String[]   operButtonText = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "=", "C", "+", "-", "*", "/" };
    Font       font;
    JButton    operButton;
    JTextField display        = new JTextField( 10 );
    JTextField inputDisplay   = new JTextField( 10 );
    JPanel     centerPanel    = new JPanel();
    
    public CalcView() {
        init();
    }
    
    public void init() {
        font = new Font( "Paryrus", Font.BOLD, 40 );
        centerPanel.setBackground( Color.cyan );
        centerPanel.setLayout( new GridLayout( 4, 4 ) );
        
        for ( int i = 0; i < operButtonText.length; i++ ) {
            operButton = new JButton( operButtonText[i] );
            centerPanel.add( operButton );
            operButton.setFont( font );
            operButton.setActionCommand( operButtonText[i] );
            operButton.addActionListener( this );
            operButton.setFont( font );
        }
        
        display.setEditable( false );
        display.setFont( new Font( "Paryrus", Font.BOLD, 30 ) );
        display.setHorizontalAlignment( JTextField.RIGHT );
        
        inputDisplay.setFont( font );
        inputDisplay.addActionListener( this );
        inputDisplay.setHorizontalAlignment( JTextField.RIGHT );
        
        centerPanel.setBackground( Color.cyan );
        centerPanel.setLayout( new GridLayout( 4, 4 ) );
        this.setTitle( "Calculation ver 1.0" );
        this.add( "North", display );
        this.add( "South", inputDisplay );
        this.add( "Center", centerPanel );
        this.setSize( 700, 400 );
        this.setVisible( true );
        this.setDefaultCloseOperation( EXIT_ON_CLOSE );
    }
    
    @Override
    public void actionPerformed( ActionEvent e ) {
        String cmd    = e.getActionCommand();
        Object object = e.getSource();
        
        int x      = 0;
        int y      = 0;
        int result = 0;
        
        if ( inputDisplay == object ) {
            // 11+22
            String          temp     = inputDisplay.getText();
            String          operator = null;
            StringTokenizer st       = new StringTokenizer( temp, "/" );
            x = Integer.parseInt( st.nextToken() );// 11
            operator = st.nextToken();
            y = Integer.parseInt( st.nextToken() );// 22
            cmd = operator;
        }
        
        switch ( cmd ) {
            
            case "+":
                result = calcLogic.calc( x, cmd, y );
                display.setText( String.valueOf( result ) );
                // display.setText( String.valueOf( calcLogic.calc( x, cmd, y ) ) );
                break;
            case "-":
                result = calcLogic.calc( x, cmd, y );
                display.setText( String.valueOf( result ) );
                break;
            case "*":
                result = calcLogic.calc( x, cmd, y );
                display.setText( String.valueOf( result ) );
                break;
            case "/":
                result = calcLogic.calc( x, cmd, y );
                display.setText( String.valueOf( result ) );
                break;
            case "=":
                break;
            case "C":
                display.setText( null );
                inputDisplay.setText( null );
                break;
            
        }
        scanner.close();
    }
    
    public static void main( String[] args ) {
        new CalcView();
    }
    
}
