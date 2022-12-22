package dept;

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
            con = dataBaseConnection.getConnection( "root", "q1w2e3r4" );
            stmt = dataBaseConnection.getStatement( con );
            result = stmt.executeUpdate( insert( dto ) );
            
            dataBaseConnection.closeStatement( stmt );
            dataBaseConnection.closeConnection( con );
        }
        catch ( ClassNotFoundException e ) {
            e.printStackTrace();
        }
        catch ( SQLException e ) {
            e.printStackTrace();
        }
        return result;
    }
    
    protected int updateDept( DeptDTO dto ) {
        log.info( dto );
        int result = 0;
        
        try {
            con = dataBaseConnection.getConnection( "root", "q1w2e3r4" );
            stmt = dataBaseConnection.getStatement( con );
            result = stmt.executeUpdate( update( dto ) );
            
            dataBaseConnection.closeStatement( stmt );
            dataBaseConnection.closeConnection( con );
        }
        catch ( ClassNotFoundException e ) {
            e.printStackTrace();
        }
        catch ( SQLException e ) {
            e.printStackTrace();
        }
        return result;
    }
    
    protected int deleteDept( DeptDTO dto ) {
        log.info( dto );
        int result = 0;
        
        try {
            con = dataBaseConnection.getConnection( "root", "q1w2e3r4" );
            stmt = dataBaseConnection.getStatement( con );
            result = stmt.executeUpdate( delete( dto ) );
            
            dataBaseConnection.closeStatement( stmt );
            dataBaseConnection.closeConnection( con );
        }
        catch ( ClassNotFoundException e ) {
            e.printStackTrace();
        }
        catch ( SQLException e ) {
            e.printStackTrace();
        }
        return result;
    }
    
    protected List<DeptDTO> selectDept() {
        List<DeptDTO> data = new ArrayList<>();
        
        try {
            con = dataBaseConnection.getConnection( "root", "q1w2e3r4" );
            stmt = dataBaseConnection.getStatement( con );
            rs = dataBaseConnection.getResultSet( stmt, select() );
            
            while ( rs.next() ) {
                data.add( new DeptDTO( rs.getInt( "deptno" ), rs.getString( "dname" ), rs.getString( "loc" ) ) );
            }
            
            dataBaseConnection.closeResultSet( rs );
            dataBaseConnection.closeStatement( stmt );
            dataBaseConnection.closeConnection( con );
        }
        catch ( ClassNotFoundException e ) {
            e.printStackTrace();
        }
        catch ( SQLException e ) {
            e.printStackTrace();
        }
        return data;
    }
    
    private String insert( DeptDTO dto ) {
        String sql = "INSERT INTO test.dept VALUES (" + dto.getDeptno() + ", '" + dto.getDname() + "', '" + dto.getLoc() + "')";
        System.out.println( sql );
        return sql;
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
        
        return builder.toString();
    }
    
    private String delete( DeptDTO dto ) {
        StringBuilder builder = new StringBuilder();
        builder.append( "DELETE          " );
        builder.append( "  FROM test.dept" );
        builder.append( " WHERE deptno = " + dto.getDeptno() );
        return builder.toString();
    }
}
