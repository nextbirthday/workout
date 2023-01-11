package crud02;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
public class ProductView extends JFrame implements ActionListener {
    
    List<Product> productList = new ArrayList<>();
    
    private JPanel            northPanel, centerPanel;
    private JButton           button;
    private DefaultTableModel model;
    private JTable            table;
    private JScrollPane       scrollPane;
    Font                      font        = new Font( "맑은 고딕", Font.PLAIN, 10 );
    String[]                  columnNames = { "productcode", "product", "productname", "price", "availability" };
    
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
    
    private void refreshData() {
        
        while ( model.getRowCount() > 0 ) {
            model.removeRow( 0 );
        }
        
        if ( productList.size() > 0 ) {
            
            for ( int i = 0; i < productList.size(); i++ ) {
                Object[] tempRow = { productList.get( i ).productcode, productList.get( i ).product, productList.get( i ).productname,
                                productList.get( i ).price, productList.get( i ).availability };
                model.addRow( tempRow );
                log.info( tempRow );
            }
        }
        else {
            JOptionPane.showMessageDialog( null, "조회된 상품정보가 없습니다." );
        }
        
    }
    
    protected int deleteProduct( Integer productcode ) {
        int result = 0;
        
        if ( productList.size() > 0 ) {
            
            for ( int i = 0; i < productList.size(); i++ ) {
                
                if ( productList.get( i ).productcode == productcode ) {
                    productList.remove( i );
                    model.removeRow( i );
                }
            }
            result++;
        }
        else {
            JOptionPane.showMessageDialog( null, "삭제하실 레코드가 없습니다." );
        }
        
        return result;
    }
    
    public int insertProduct( Product productList ) {
        int result = 0;
        log.info( productList );
        this.productList.add( productList );
        
        if ( productList != null ) {
            List<Product> tempList = new ArrayList<>();
            tempList.add( productList );
            
            for ( int i = 0; i < tempList.size(); i++ ) {
                Object[] tempRow = { tempList.get( i ).productcode, tempList.get( i ).product, tempList.get( i ).productname,
                                tempList.get( i ).price, tempList.get( i ).availability };
                model.addRow( tempRow );
            }
            result++;
        }
        return result;
    }
    
    @Override
    public void actionPerformed( ActionEvent e ) {
        String cmd = e.getActionCommand();
        
        switch ( cmd ) {
            
            case "SELECT":
                
                refreshData();
                break;
            
            case "INSERT":
                
                new InsertDialog( this, true );
                break;
            
            case "UPDATE":
                
                new InsertDialog( this, false );
                break;
            
            case "DELETE":
                
                if ( productList.size() == 0 ) {
                    refreshData();
                }
                else {
                    String[] temp = null;
                    
                    for ( int i = 0; i < columnNames.length; i++ ) {
                        temp[i] = String.valueOf( model.getValueAt( table.getSelectedRow(), i ) );
                    }
                    System.out.println( temp );
                    
                    new InsertDialog( this, true );
                }
                break;
            
            case "CLOSE":
                
                this.dispose();
                break;
        }
    }
    
    public static void main( String[] args ) {
        ProductView pv = new ProductView();
        pv.init();
    }
}
