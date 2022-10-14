package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class View extends JFrame implements ActionListener {
    
    private JButton colorChangeButton, closeButton;
    private JPanel  centerPanel;
    
    // LazyHolder Singleton Pattern
    public static View getInstance() { return LazyHolder.INSTANCE; }
    
    // Inner Class
    private static class LazyHolder {
        private static final View INSTANCE = new View();
    }
    
    private View() {
        init();
    }
    
    private void init() {
        // 프레임 초기화
        this.setTitle( "연습용 뷰" );
        this.setSize( 400, 300 );
        this.setVisible( true );
        this.setDefaultCloseOperation( EXIT_ON_CLOSE );
        this.setLayout( new BorderLayout() );
        
        Font font = new Font( "맑은 고딕", Font.BOLD, 20 );
        
        // 패널 초기화 및 프레임 배치
        centerPanel = new JPanel();
        centerPanel.setBackground( Color.ORANGE );
        this.add( centerPanel, BorderLayout.CENTER );
        
        // 버튼 초기화 및 프레임 배치
        colorChangeButton = new JButton( "변경" );
        colorChangeButton.setFont( font );
        colorChangeButton.addActionListener( this );
        closeButton = new JButton( "닫기" );
        closeButton.setFont( font );
        closeButton.addActionListener( this );
        this.add( colorChangeButton, BorderLayout.NORTH );
        this.add( closeButton, BorderLayout.SOUTH );
    }
    
    @Override
    public void actionPerformed( ActionEvent e ) {
        String cmd = e.getActionCommand();
        
        switch ( cmd ) {
            case "변경":
                centerPanel.setBackground( Color.GREEN );
                colorChangeButton.setText( "색이 변경되었습니다" );
                break;
            case "색이 변경되었습니다":
                centerPanel.setBackground( Color.ORANGE );
                colorChangeButton.setText( "변경" );
                break;
            case "닫기":
                this.dispose();
                break;
        }
    }
}
