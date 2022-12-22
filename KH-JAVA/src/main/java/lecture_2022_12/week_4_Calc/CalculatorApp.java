package lecture_2022_12.week_4_Calc;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings( "serial" )
public class CalculatorApp extends JFrame implements ActionListener {
    
    JTextField display     = new JTextField( 10 );
    JPanel     centerPanel = new JPanel();
    JButton    operButton;
    JButton    plusButton  = new JButton( "+" );
    JButton    minusButton = new JButton( "-" );
    JButton    multiButton = new JButton( "*" );
    JButton    divButton   = new JButton( "/" );
    JButton    equalButton = new JButton( "=" );
    JButton    clearButton = new JButton( "C" );
    JButton    oneButton   = new JButton( "1" );
    JButton    twoButton   = new JButton( "2" );
    Font       font        = new Font( "Paryrus", Font.BOLD, 40 );
    JLabel     operLable   = new JLabel( "연산자" );
    
    public CalculatorApp() {
        init();
    }
    
    public void init() {
        oneButton.setFont( font );
        twoButton.setFont( font );
        oneButton.setForeground( Color.RED );
        twoButton.setForeground( Color.GREEN );
        centerPanel.setBackground( Color.cyan );
        centerPanel.setLayout( new GridLayout( 2, 6 ) );
        centerPanel.add( plusButton );
        centerPanel.add( minusButton );
        centerPanel.add( multiButton );
        centerPanel.add( divButton );
        centerPanel.add( equalButton );
        centerPanel.add( clearButton );
        centerPanel.add( oneButton );
        centerPanel.add( twoButton );
        this.setTitle( "Calculation ver 1.0" );
        this.add( "North", display );
        this.add( "Center", centerPanel );
        this.setSize( 800, 400 );
        this.setVisible( true );
        display.setEditable( false );
        this.setDefaultCloseOperation( EXIT_ON_CLOSE );
    }
    
    public static void main( String[] args ) {
        new CalculatorApp();
    }
    
    @Override
    public void actionPerformed( ActionEvent e ) {
        Object object = e.getSource();
        
        if ( object == oneButton ) {
            
        }
        
        if ( object == twoButton ) {
            
        }
        
        if ( object == oneButton ) {
            
        }
        
        if ( object == plusButton ) {
            
        }
        
        if ( object == minusButton ) {
            
        }
        
        if ( object == multiButton ) {
            
        }
        
        if ( object == divButton ) {
            
        }
        
        if ( object == equalButton ) {
            
        }
        
        if ( object == clearButton ) {
            
        }
    }
}
