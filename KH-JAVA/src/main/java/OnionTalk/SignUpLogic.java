package OnionTalk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignUpLogic {
    
    private JoinView          view;
    private Connection        con;
    private PreparedStatement pstmt;
    private ResultSet         rs;
    
    public SignUpLogic() {}
    
    public SignUpLogic( JoinView view ) {
        this.view = view;
    }
    
    public int idCheck() {
        
        StringBuilder sql    = new StringBuilder();
        int           result = 0;
        sql.append( "SELECT user_id      " );
        sql.append( "  FROM onion.account" );
        sql.append( " WHERE user_id = ?  " );
        
        try {
            con = Oracle.getConnection();
            pstmt = con.prepareStatement( sql.toString() );
            pstmt.setString( 1, view.jtf_id.getText() );
            rs = pstmt.executeQuery();
            
            if ( rs.next() )
                result++;
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
        finally {
            
            try {
                if ( rs != null )
                    rs.close();
                if ( pstmt != null )
                    pstmt.close();
                if ( con != null )
                    con.close();
            }
            catch ( SQLException e ) {
                e.printStackTrace();
            }
        }
        return result;
    }
    
    public int register() {
        StringBuilder sql    = new StringBuilder();
        int           result = 0;
        sql.append( "INSERT INTO onion.account  " );
        sql.append( "VALUES ( ?, ?, ?, ?, ?, ? )" );
        
        try {
            con = Oracle.getConnection();
            pstmt = con.prepareStatement( sql.toString() );
            pstmt.setString( 1, view.jtf_id.getText() );
            pstmt.setString( 2, String.valueOf( view.jtf_pw.getPassword() ) );
            pstmt.setString( 3, view.jtf_name.getText() );
            pstmt.setString( 4, view.jtf_nickName.getText() );
            pstmt.setString( 5, view.jtf_birth.getText() );
            pstmt.setString( 6, view.jtf_phone.getText() );
            result = pstmt.executeUpdate();
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
        finally {
            
            try {
                if ( pstmt != null )
                    pstmt.close();
                if ( con != null )
                    con.close();
            }
            catch ( SQLException e ) {
                e.printStackTrace();
            }
        }
        return result;
    }
    
    public String signIn( String id, String password ) {
        String        nickName = null;
        StringBuilder sql      = new StringBuilder();
        sql.append( "SELECT user_nick    " );
        sql.append( "  FROM onion.account" );
        sql.append( " WHERE user_id = ?  " );
        sql.append( "   AND user_pw = ?  " );
        
        try {
            con = Oracle.getConnection();
            pstmt = con.prepareStatement( sql.toString() );
            pstmt.setString( 1, id );
            pstmt.setString( 2, password );
            rs = pstmt.executeQuery();
            
            if ( rs.next() )
                nickName = rs.getString( "USER_NICK" );
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
        finally {
            
            try {
                if ( rs != null )
                    rs.close();
                if ( pstmt != null )
                    pstmt.close();
                if ( con != null )
                    con.close();
            }
            catch ( SQLException e ) {
                e.printStackTrace();
            }
        }
        return nickName;
    }
}
