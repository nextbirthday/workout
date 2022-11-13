package mybatis;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import mysql.Customer;
import mysql.Payment;

public class GridView implements ActionListener {
    
    JTable            table;
    DefaultTableModel defaultTableModel;
    JScrollPane       scrollPane;
    JButton           getDataButton;
    JButton           getData2Button;
    JLabel            label;
    JTextField        textField;
    JPanel            panel;
    JFrame            frame;
    Controller        controller;
    
    public GridView() {
        init();
    }
    
    private void init() {
        String[] columnNames = { "customer_id", "store_id", "first_name", "last_name", "email", "address_id", "active", "create_date", "payment_id", "staff_id", "rental_id",
                        "amount", "payment_date", "last_update" };
        Font     font        = new Font( "맑은 고딕", Font.BOLD, 20 );
        
        defaultTableModel = new DefaultTableModel( columnNames, 0 );
        
        table = new JTable( defaultTableModel );
        table.setPreferredScrollableViewportSize( new Dimension( 1920, 1080 ) );
        table.setFillsViewportHeight( true );
        table.setEnabled( false );
        
        scrollPane = new JScrollPane( table );
        
        label = new JLabel( "customer_id : " );
        label.setFont( font );
        
        textField = new JTextField( 10 );
        textField.setFont( font );
        
        getDataButton = new JButton( "조회" );
        getDataButton.setFont( font );
        getDataButton.addActionListener( this );
        
        getData2Button = new JButton( "종료" );
        getData2Button.setFont( font );
        getData2Button.addActionListener( this );
        
        panel = new JPanel( new FlowLayout() );
        panel.add( label );
        panel.add( textField );
        panel.add( getDataButton );
        panel.add( getData2Button );
        
        frame = new JFrame( "GRID VIEW" );
        frame.setLayout( new BorderLayout() );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.add( scrollPane, BorderLayout.CENTER );
        frame.add( panel, BorderLayout.SOUTH );
        frame.pack();
        frame.setVisible( true );
    }
    
    @Override
    public void actionPerformed( ActionEvent e ) {
        
        switch ( e.getActionCommand() ) {
            case "조회":
                try {
                    
                    if ( Integer.parseInt( textField.getText() ) > 0 && Integer.parseInt( textField.getText() ) < 600 ) {
                        defaultTableModel.setRowCount( 0 );
                        controller = new Controller();
                        Customer cust = new Customer();
                        cust.setCustomer_id( Integer.parseInt( textField.getText() ) );
                        List<Customer> customerList = controller.getCustomerPaymentList( cust );
                        Object[]       record       = new Object[14];
                        
                        for ( Customer customer : customerList ) {
                            
                            for ( Payment payment : customer.getPayments() ) {
                                record[0] = customer.getCustomer_id();
                                record[1] = customer.getStore_id();
                                record[2] = customer.getFirst_name();
                                record[3] = customer.getLast_name();
                                record[4] = customer.getEmail();
                                record[5] = customer.getAddress_id();
                                record[6] = customer.getActive();
                                record[7] = customer.getCreate_date();
                                record[8] = payment.getPayment_id();
                                record[9] = payment.getStaff_id();
                                record[10] = payment.getRental_id();
                                record[11] = payment.getAmount();
                                record[12] = payment.getPayment_date();
                                record[13] = payment.getLast_update();
                                defaultTableModel.addRow( record );
                            }
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog( frame, "1 ~ 599 사이의 정수만 입력할 수 있습니다." );
                    }
                }
                catch ( NumberFormatException nfe ) {
                    JOptionPane.showMessageDialog( frame, nfe.toString() + " : 1 ~ 599 사이의 정수만 입력할 수 있습니다." );
                }
                break;
            case "종료":
                frame.dispose();
                break;
        }
    }
    
    public static void main( String[] args ) {
        
        @SuppressWarnings( "unused" )
        GridView view = new GridView();
    }
}
