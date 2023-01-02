package lecture_2022_12.week_5_Oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ZipCodeSearch {
    
    Connection        con;
    PreparedStatement pstmt;
    ResultSet         rs;
    DBConnectionMgr   dbMgr = new DBConnectionMgr();
    
    
    public Integer[] getZipCode( String dong ) {
        System.out.println( "getZipCode method call ===> " + dong );
        Integer[] zipcodes = null;
        // List<Integer> temp = new ArrayList<>();
        Vector<Integer> temp = new Vector<>();
        StringBuilder   sql  = new StringBuilder();
        sql.append( " SELECT              " );
        sql.append( " zipcode                    " );
        sql.append( "  FROM zipcode_t            " );
        sql.append( "  WHERE dong LIKE ?||'%' " );
        
        try {
            con = dbMgr.getConnection();
            pstmt = con.prepareStatement( sql.toString() );
            pstmt.setString( 1, dong );
            rs = pstmt.executeQuery();
            
            while ( rs.next() ) {
                // System.out.println( rs.getInt( "zipcode" ) );
                int code = rs.getInt( "zipcode" );
                temp.add( code );
            }
            zipcodes = new Integer[temp.size()];
            temp.copyInto( zipcodes );
            // for ( int i = 0; i < temp.size(); i++ ) {
            // zipcodes[i] = temp.get( i );
            // }
            
            for ( Integer c : zipcodes ) {
                System.out.println( c );
            }
            System.out.println( temp.size() );
        }
        catch ( Exception e ) {
            e.printStackTrace(); // line number, log
        }
        finally { // resource 반납
            dbMgr.freeConnection( con, pstmt, rs );
        }
        return zipcodes;
    }
    
    // public List<Integer> getZipcode2( String dong ) {
    // List<Integer> zipList = new ArrayList<>();
    //
    // return zipList;
    // }
    
    public static void main( String[] args ) {
        ZipCodeSearch zcs = new ZipCodeSearch();
        zcs.getZipCode( "역삼" );
    }
}
