package crud;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings( "serial" )
public class ProductView extends JFrame implements ActionListener {
    
    private JPanel            northPanel, centerPanel;
    private JButton           button;
    private DefaultTableModel model;
    private JTable            table;
    private JScrollPane       scrollPane;
    Font                      font = new Font( "맑은 고딕", Font.PLAIN, 10 );
    
    ProductController controller = new ProductController();
    InsertDialog      dialog     = new InsertDialog( this );
    
    public ProductView() {}
    
    public void init() {
        northPanel = new JPanel( new FlowLayout( FlowLayout.RIGHT ) );
        centerPanel = new JPanel();
        northPanel.setBackground( Color.cyan );
        
        String[] buttonText = { "INSERT", "SELECT", "UPDATE", "DELETE", "CLOSE" };
        
        for ( int i = 0; i < buttonText.length; i++ ) {
            button = new JButton( buttonText[i] );
            button.addActionListener( this );
            northPanel.add( button );
        }
        
        String[] columnNames = { "productcode", "product", "productname", "price", "availability" };
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
    
    private void getProduct() {
        
        while ( model.getRowCount() > 0 ) {
            model.removeRow( 0 );
        }
        
        List<Product> tempList = controller.selectProduct();
        
        for ( int i = 0; i < tempList.size(); i++ ) {
            Object[] tempRow = { tempList.get( i ).productcode, tempList.get( i ).product, tempList.get( i ).productname,
                            tempList.get( i ).price, tempList.get( i ).availability };
            model.addRow( tempRow );
        }
        
    }
    
    @Override
    public void actionPerformed( ActionEvent e ) {
        String cmd    = e.getActionCommand();
        int    result = 0;
        
        switch ( cmd ) {
            
            case "SELECT":
                getProduct();
                break;
            
            case "INSERT":
                controller.cudProduct( "I" );
                break;
            
            case "UPDATE":
                break;
            
            case "DELETE":
                break;
            
            case "CLOSE":
                this.dispose();
                break;
            
            case "EXIT":
                dialog.dispose();
                break;
        }
    }
    
    public static void main( String[] args ) {
        ProductView pv = new ProductView();
        pv.init();
    }
}
