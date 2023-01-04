package test;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.ZipCodeDTO;
import lombok.extern.log4j.Log4j2;
import util.OracleConnection;

@Log4j2
public class ZipCode implements ActionListener {
    
    JFrame            frame;
    JPanel            panel;
    JComboBox<String> zdoBox, siguBox, dongBox, riBox;
    
    @Override
    public void actionPerformed( ActionEvent e ) {
        String action = e.getActionCommand();
//        JOptionPane.showMessageDialog( null, action );
        
        switch ( action ) {
            case "zdoBox":
                String zdo = String.valueOf( zdoBox.getSelectedItem() );
                siguBox.removeAllItems();
                getSigu( zdo ).forEach( sigu -> siguBox.addItem( sigu.getSigu() ) );
                
                break;
            case "siguBox":
                String sigu = String.valueOf( siguBox.getSelectedItem() );
                dongBox.removeAllItems();
                getDong( sigu ).forEach( dong -> dongBox.addItem( dong.getDong() ) );
                
                break;
        }
    }
    
    private ZipCode() {
        init();
    }
    
    private void init() {
        frame = new JFrame();
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setTitle( "우편번호 탐색기" );
        frame.setSize( 700, 600 );
        
        panel = new JPanel( new FlowLayout() );
        List<ZipCodeDTO> zdoList = getZdo();
        String[]         zdos    = new String[zdoList.size()];
        String[]         temp    = { "전체" };
        for ( int i = 0; i < zdoList.size(); i++ )
            zdos[i] = zdoList.get( i ).getZdo();
        
        zdoBox = new JComboBox<>( zdos );
        zdoBox.addActionListener( this );
        zdoBox.setActionCommand( "zdoBox" );
        
        siguBox = new JComboBox<>( temp );
        siguBox.addActionListener( this );
        siguBox.setActionCommand( "siguBox" );
        
        dongBox = new JComboBox<>( temp );
        dongBox.addActionListener( this );
        dongBox.setActionCommand( "dongBox" );
        
        riBox = new JComboBox<>( temp );
        riBox.addActionListener( this );
        riBox.setActionCommand( "riBox" );
        
        panel.add( zdoBox );
        panel.add( siguBox );
        panel.add( dongBox );
        panel.add( riBox );
        frame.add( "North", panel );
        
        frame.setVisible( true );
    }
    
    private List<ZipCodeDTO> getZdo() {
        SqlSessionFactory sqlSessionFactory = OracleConnection.getSqlSessionFactory();
        SqlSession        session           = sqlSessionFactory.openSession();
        List<ZipCodeDTO>  zdoList           = session.selectList( "getZdo" );
        zdoList.forEach( e -> log.info( e.toString() ) );
        return zdoList;
    }
    
    private List<ZipCodeDTO> getSigu( String zdo ) {
        SqlSessionFactory sqlSessionFactory = OracleConnection.getSqlSessionFactory();
        SqlSession        session           = sqlSessionFactory.openSession();
        List<ZipCodeDTO>  siguList          = session.selectList( "getSigu", zdo );
        siguList.forEach( e -> log.info( e.toString() ) );
        return siguList;
    }
    
    private List<ZipCodeDTO> getDong( String sigu ) {
        SqlSessionFactory sqlSessionFactory = OracleConnection.getSqlSessionFactory();
        SqlSession        session           = sqlSessionFactory.openSession();
        List<ZipCodeDTO>  dongList          = session.selectList( "getDong", sigu );
        dongList.forEach( e -> log.info( e.toString() ) );
        return dongList;
    }
    
    public static void main( String[] args ) {
        new ZipCode();
    }
}
