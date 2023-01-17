package dept;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class DeptModel2 {
    
    private DataBaseConnection dataBaseConnection = new DataBaseConnection();
    private Connection         con;
    private Statement          stmt;
    private ResultSet          rs;
    
    protected int insertDept( DeptDTO dto ) {
        log.info( dto );
        int result = 0;
        
        try {
            con = dataBaseConnection.getConnection();
            stmt = con.createStatement();
            result = stmt.executeUpdate( insert( dto ) );
            
            dataBaseConnection.closeStatement( stmt );
            dataBaseConnection.closeConnection( con );
        }
        catch ( ClassNotFoundException e ) {
            log.error( "ClassNotFoundException", e );
        }
        catch ( SQLException e ) {
            log.error( "SQLException", e );
        }
        catch ( IOException e ) {
            log.error( "IOException", e );
        }
        return result;
    }
    
    protected int updateDept( DeptDTO dto ) {
        log.info( dto );
        int result = 0;
        
        try {
            con = dataBaseConnection.getConnection();
            stmt = con.createStatement();
            result = stmt.executeUpdate( update( dto ) );
            
            dataBaseConnection.closeStatement( stmt );
            dataBaseConnection.closeConnection( con );
        }
        catch ( ClassNotFoundException e ) {
            log.error( "ClassNotFoundException", e );
        }
        catch ( SQLException e ) {
            log.error( "SQLException", e );
        }
        catch ( IOException e ) {
            log.error( "IOException", e );
        }
        return result;
    }
    
    protected int deleteDept( DeptDTO dto ) {
        log.info( dto );
        int result = 0;
        
        try {
            con = dataBaseConnection.getConnection();
            stmt = con.createStatement();
            result = stmt.executeUpdate( delete( dto ) );
            
            dataBaseConnection.closeStatement( stmt );
            dataBaseConnection.closeConnection( con );
        }
        catch ( ClassNotFoundException e ) {
            log.error( "ClassNotFoundException", e );
        }
        catch ( SQLException e ) {
            log.error( "SQLException", e );
        }
        catch ( IOException e ) {
            log.error( "IOException", e );
        }
        return result;
    }
    
    protected List<DeptDTO> selectDept() {
        List<DeptDTO> data = new ArrayList<>();
        
        try {
            con = dataBaseConnection.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery( select() );
            
            while ( rs.next() ) {
                data.add( new DeptDTO( rs.getInt( "deptno" ), rs.getString( "dname" ), rs.getString( "loc" ) ) );
            }
            log.info( data );
            
            dataBaseConnection.closeResultSet( rs );
            dataBaseConnection.closeStatement( stmt );
            dataBaseConnection.closeConnection( con );
        }
        catch ( ClassNotFoundException e ) {
            log.error( "ClassNotFoundException", e );
        }
        catch ( SQLException e ) {
            log.error( "SQLException", e );
        }
        catch ( IOException e ) {
            log.error( "IOException", e );
        }
        return data;
    }
    
    private String insert( DeptDTO dto ) {
        StringBuilder builder = new StringBuilder();
        builder.append( "INSERT INTO test.dept " );
        builder.append( "VALUES (" + dto.getDeptno() + ", '" );
        builder.append( dto.getDname() + "', '" );
        builder.append( dto.getLoc() + "')" );
        log.info( builder );
        return builder.toString();
    }
    
    private String select() {
        return "SELECT * FROM test.dept";
    }
    
    private String update( DeptDTO dto ) {
        StringBuilder builder = new StringBuilder();
        builder.append( "UPDATE test.dept " );
        builder.append( "   SET dname = '" + dto.getDname() + "'" );
        builder.append( "     , loc   = '" + dto.getLoc() + "'" );
        builder.append( " WHERE deptno = " + dto.getDeptno() );
        log.info( builder );
        return builder.toString();
    }
    
    private String delete( DeptDTO dto ) {
        StringBuilder builder = new StringBuilder();
        builder.append( "DELETE          " );
        builder.append( "  FROM test.dept" );
        builder.append( " WHERE deptno = " + dto.getDeptno() );
        log.info( builder );
        return builder.toString();
    }
}
