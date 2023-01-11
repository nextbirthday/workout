package crud02;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SuppressWarnings( "serial" )
public class InsertDialog extends JDialog implements ActionListener {
    ProductView view;
    Product     product;
    
    public InsertDialog() {
        
    }
    
    public InsertDialog( ProductView view, boolean isEdit ) {
        this.view = view;
        productcodeField.setEditable( isEdit );
        init();
    }
    
    private JButton insertButton = new JButton( "SAVE" );
    private JButton updateButton = new JButton( "UPDATE" );
    private JButton deleteButton = new JButton( "DELETE" );
    private JButton closeButton  = new JButton( "CLOSE" );
    private JPanel  northPanel, centerPanel, southPanel;
    
    private JLabel       productcodeLabel   = new JLabel( "productcode" );
    private JLabel       productLabel       = new JLabel( "product" );
    private JLabel       productnameLabel   = new JLabel( "productname" );
    private JLabel       priceLabel         = new JLabel( "price" );
    private JLabel       availabilityLabel  = new JLabel( "availability" );
    private JLabel       deleteproductLabel = new JLabel( "상품삭제" );
    protected JTextField productcodeField   = new JTextField();
    protected JTextField productField       = new JTextField();
    protected JTextField productnameField   = new JTextField();
    protected JTextField priceField         = new JTextField();
    protected JTextField availabilityField  = new JTextField();
    protected JTextField deleteproductField = new JTextField();
    
    public void init() {
        northPanel = new JPanel();
        centerPanel = new JPanel( ( new GridLayout( 6, 1 ) ) );
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
        centerPanel.add( deleteproductLabel );
        centerPanel.add( deleteproductField );
        
        insertButton.addActionListener( this );
        closeButton.addActionListener( this );
        deleteButton.addActionListener( this );
        southPanel.add( insertButton );
        southPanel.add( updateButton );
        southPanel.add( deleteButton );
        southPanel.add( closeButton );
        northPanel.setBackground( Color.cyan );
        this.add( "North", northPanel );
        this.add( "Center", centerPanel );
        this.add( "South", southPanel );
        this.setSize( 500, 400 );
        this.setVisible( true );
        this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        this.setTitle( "productInsert" );
    }
    
    public static void main( String[] args ) {
        InsertDialog test = new InsertDialog();
        test.init();
    }
    
    @Override
    public void actionPerformed( ActionEvent e ) {
        Object object = e.getSource();
        int    result = 0;
        
        if ( object == insertButton ) {
            
            if ( productcodeField.getText() != null && productField.getText() != null && productnameField.getText() != null
                            && priceField.getText() != null && availabilityField.getText() != null ) {
                product = new Product( Integer.parseInt( productcodeField.getText() ), productField.getText(), productnameField.getText(),
                                Integer.parseInt( priceField.getText() ), Integer.parseInt( availabilityField.getText() ) );
                log.info( product );
                view.insertProduct( product );
                result++;
            }
            else {
                JOptionPane.showMessageDialog( null, "상품정보를 전부 입력해주세요." );
            }
            
            if ( result > 0 ) {
                this.dispose();
                JOptionPane.showMessageDialog( null, "상품정보 입력에 성공하셨습니다." );
            }
            
        }
        
        if ( object == deleteButton ) {
            System.out.println( "dialog deletebutton" );
            
            // if ( String.valueOf( product.getProductcode() ) == null ) {
            // JOptionPane.showMessageDialog( null, "삭제하실 상품코드가 선택되지 않았습니다." );
            // }
            log.info( product );
            
            result = view.deleteProduct( Integer.parseInt( deleteproductField.getText() ) );
            
            if ( result > 0 ) {
                this.dispose();
                JOptionPane.showMessageDialog( view, "선택하신 상품코드 정보가 삭제되었습니다." );
            }
            else {
                JOptionPane.showMessageDialog( view, "선택하신 상품코드 정보가 삭제되지 않았습니다." );
            }
            
        }
        
        if ( object == updateButton ) {
            
        }
        
        if ( object == closeButton ) {
            this.dispose();
        }
        
    }
    
}
