package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import controller.Shop;
import dto.Coffee;

public class Customer implements ActionListener {
    
    JFrame       frame;
    JPanel       panel;
    JRadioButton americano, latte;
    ButtonGroup  group;
    JButton      orderButton;
    Shop         shop;
    
    public Customer() {
        shop = Shop.getInstance();
        kiosk();
    }
    
    private void kiosk() {
        frame = new JFrame( "키오스크" );
        frame.setSize( 700, 600 );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setResizable( false );
        
        Font font = new Font( "맑은 고딕", Font.BOLD, 100 );
        orderButton = new JButton( "주문하기" );
        orderButton.setFont( font );
        orderButton.setBackground( Color.ORANGE );
        orderButton.addActionListener( this );
        
        americano = new JRadioButton( "아메리카노" );
        americano.setFont( font );
        latte = new JRadioButton( "라떼" );
        latte.setFont( font );
        
        group = new ButtonGroup();
        group.add( americano );
        group.add( latte );
        
        panel = new JPanel( new GridLayout( 2, 1 ) );
        panel.add( americano );
        panel.add( latte );
        
        frame.add( "South", orderButton );
        frame.add( "Center", panel );
        frame.setVisible( true );
    }
    
    @Override
    public void actionPerformed( ActionEvent e ) {
        Object object        = e.getSource();
        Coffee orderedCoffee = null;
        
        if ( object == orderButton ) {
            
            try {
                
                if ( americano.isSelected() ) {
                    orderedCoffee = shop.getCoffee( new Coffee( americano.getText() ) );
                }
                else if ( latte.isSelected() ) {
                    orderedCoffee = shop.getCoffee( new Coffee( latte.getText() ) );
                }
                else {
                    JOptionPane.showMessageDialog( frame, "메뉴를 선택하세요.", "확인", JOptionPane.INFORMATION_MESSAGE );
                }
            }
            catch ( InterruptedException ie ) {
                ie.printStackTrace();
            }
        }
        JOptionPane.showMessageDialog( frame, "주문하신 " + orderedCoffee.getName() + " " + orderedCoffee.getCount() + "잔 나왔습니다.", "픽업", JOptionPane.INFORMATION_MESSAGE );
    }
    
    public static void main( String[] args ) {
        new Customer();
    }
}
