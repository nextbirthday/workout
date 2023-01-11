package crud;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings( "serial" )
public class InsertDialog extends JDialog {
    ProductView view;
    
    public InsertDialog() {
        
    }
    
    public InsertDialog( ProductView view ) {
        this.view = view;
    }
    
    private JButton saveButton = new JButton( "SAVE" );
    private JButton exitButton = new JButton( "EXIT" );
    private JPanel  northPanel, centerPanel, southPanel;
    
    private JLabel       productcodeLabel  = new JLabel( "productcode" );
    private JLabel       productLabel      = new JLabel( "product" );
    private JLabel       productnameLabel  = new JLabel( "productname" );
    private JLabel       priceLabel        = new JLabel( "price" );
    private JLabel       availabilityLabel = new JLabel( "availability" );
    protected JTextField productcodeField  = new JTextField();
    protected JTextField productField      = new JTextField();
    protected JTextField productnameField  = new JTextField();
    protected JTextField priceField        = new JTextField();
    protected JTextField availabilityField = new JTextField();
    
    public void init() {
        northPanel = new JPanel();
        centerPanel = new JPanel( ( new GridLayout( 5, 1 ) ) );
        southPanel = new JPanel( new FlowLayout( FlowLayout.RIGHT ) );
        
        centerPanel.add( productcodeLabel );
        centerPanel.add( productcodeField );
        centerPanel.add( productLabel );
        centerPanel.add( productField );
        centerPanel.add( productnameLabel );
        centerPanel.add( productnameField );
        centerPanel.add( priceLabel );
        centerPanel.add( priceField );
        centerPanel.add( availabilityLabel );
        centerPanel.add( availabilityField );
        
        saveButton.addActionListener( view );
        exitButton.addActionListener( view );
        
        southPanel.add( saveButton );
        southPanel.add( exitButton );
        northPanel.setBackground( Color.cyan );
        this.add( "North", northPanel );
        this.add( "Center", centerPanel );
        this.add( "South", southPanel );
        this.setSize( 500, 400 );
        this.setVisible( true );
        this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        this.setTitle( "productInsert" );
    }
    
    public List<Product> setText() {
        List<Product> tempList = new ArrayList<>();
        tempList.add( new Product( Integer.parseInt( productcodeField.getText() ), productField.getText(), productnameField.getText(),
                        Integer.parseInt( priceField.getText() ), Integer.parseInt( availabilityField.getText() ) ) );
        return tempList;
    }
    
    public static void main( String[] args ) {
        InsertDialog test = new InsertDialog();
        test.init();
    }
    
}
