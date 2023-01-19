package test;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import lombok.extern.log4j.Log4j2;

@Log4j2( topic = "logger" )
public class JTabbedPaneSample implements ListSelectionListener {
    
    public JTabbedPaneSample() {
        init();
    }
    
    ListSelectionModel listSelectionModel;
    
    private JPanel friendListPanel( Font font ) {
        JPanel                   panel     = new JPanel();
        DefaultListModel<String> listModel = new DefaultListModel<String>();
        String[]                 elements  = { "친구1", "친구2", "친구3", "친구4" };
        
        for ( String e : elements ) {
            listModel.addElement( e );
        }
        JList<String> friendList = new JList<String>( listModel );
        friendList.setFont( font );
        listSelectionModel = friendList.getSelectionModel();
        listSelectionModel.addListSelectionListener( this );
        panel.add( friendList );
        return panel;
    }
    
    private void init() {
        JFrame frame = new JFrame( "JTabbedPane" );
        frame.setSize( 400, 700 );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        
        Font font = new Font( "맑은 고딕", Font.BOLD, 30 );
        
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab( "친구", friendListPanel( font ) );
        tabbedPane.addTab( "채팅", new JPanel() );
        tabbedPane.addTab( "채널", new JPanel() );
        tabbedPane.addTab( "설정", new JPanel() );
        tabbedPane.setTabLayoutPolicy( JTabbedPane.SCROLL_TAB_LAYOUT );
        tabbedPane.setFont( font );
        frame.add( tabbedPane, BorderLayout.CENTER );
        frame.setVisible( true );
    }
    
    public static void main( String[] args ) {
        new JTabbedPaneSample();
    }
    
    @Override
    public void valueChanged( ListSelectionEvent e ) {
        log.info( "{}\n", e.getSource() );
    }
}
