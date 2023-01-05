package test;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.ZipCodeDTO;
import lombok.extern.log4j.Log4j2;
import util.OracleConnection;

@Log4j2
public class ZipCodeTest {
    
    JFrame            frame;
    JPanel            panel;
    JComboBox<String> zdoBox, siguBox, dongBox, riBox;
    
    private void test( ItemEvent e ) {
        
        if ( e.getStateChange() == ItemEvent.SELECTED ) {
            
            if ( e.getSource() == zdoBox ) {
                String zdo = String.valueOf( e.getItem() );
                removeItem( siguBox );
                getSigu( zdo ).forEach( sigu -> siguBox.addItem( sigu.getSigu() ) );
            }
            else if ( e.getSource() == siguBox ) {
                String sigu = String.valueOf( e.getItem() );
                removeItem( dongBox );
                getDong( sigu ).forEach( dong -> dongBox.addItem( dong.getDong() ) );
            }
            else if ( e.getSource() == dongBox ) {
                String dong = String.valueOf( e.getItem() );
                removeItem( riBox );
                getRi( dong ).forEach( ri -> riBox.addItem( ri.getRi() ) );
            }
        }
    }
    
    private void removeItem( JComboBox<?> comboBox ) {
        
        /*
         * comboBox.removeAllItems() 를 사용할 경우 itemStateChanged 가 발생해버림
         * 임시방편으로 아래와 같이 리스너 제거 후 인덱스 뒤에서부터 아이템 삭제,
         * 다시 리스너를 넣어준다.
         * 리스너를 제거하지 않을 경우 '리'까지 값이 선택된 후 다시 '도'를 선택할 경우
         * 아이템을 하나씩 삭제하면서 이벤트가 계속 발생하는 것 같다.
         */
        if ( comboBox.getItemCount() > 0 ) {
            comboBox.removeAllItems();
            // comboBox.removeItemListener( this );
            //
            // for ( int i = comboBox.getItemCount() - 1; i > 0; i-- ) {
            // comboBox.removeItemAt( i );
            // }
            // comboBox.addItemListener( this );
        }
    }
    
    private ZipCodeTest() {
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
        zdoBox.addItemListener( new ItemListener() {
            @Override
            public void itemStateChanged( ItemEvent e ) {
                test( e );
            }
        } );
        
        siguBox = new JComboBox<>( temp );
        siguBox.addItemListener( new ItemListener() {
            @Override
            public void itemStateChanged( ItemEvent e ) {
                test( e );
            }
        } );
        
        dongBox = new JComboBox<>( temp );
        dongBox.addItemListener( new ItemListener() {
            @Override
            public void itemStateChanged( ItemEvent e ) {
                test( e );
            }
        } );
        
        riBox = new JComboBox<>( temp );
        riBox.addItemListener( new ItemListener() {
            @Override
            public void itemStateChanged( ItemEvent e ) {
                test( e );
            }
        } );
        
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
    
    private List<ZipCodeDTO> getRi( String dong ) {
        SqlSessionFactory sqlSessionFactory = OracleConnection.getSqlSessionFactory();
        SqlSession        session           = sqlSessionFactory.openSession();
        List<ZipCodeDTO>  riList            = session.selectList( "getRi", dong );
        riList.forEach( e -> log.info( e.toString() ) );
        return riList;
    }
    
    public static void main( String[] args ) {
        new ZipCodeTest();
    }
}
