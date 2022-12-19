package lecture_2022_12.week_4_Dept;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class DeptModel {
    
    List<DeptDTO> database = new ArrayList<>();
    
    private List<DeptDTO> dataInitialize() {
        database.add( new DeptDTO( 10, "인사팀", "을지로 페럼타워 16F" ) );
        database.add( new DeptDTO( 20, "화학영업팀", "을지로 페럼타워 16F" ) );
        database.add( new DeptDTO( 30, "목재영업팀", "을지로 페럼타워 16F" ) );
        database.add( new DeptDTO( 40, "올고다 TF", "판교 OCI파트너 스퀘어" ) );
        database.add( new DeptDTO( 50, "재무회계팀", "을지로 페럼타워 17F" ) );
        return database;
    }
    
    protected int insertDept( DeptDTO dto ) {
        log.info( dto );
        int result = -1;
        
        if ( database.size() > 0 ) {
            
            for ( int i = 0; i < database.size(); i++ ) {
                
                if ( database.get( i ).getDeptno() == dto.getDeptno() ) {
                    log.error( "제약조건을 위반하였습니다." );
                    return result;
                }
            }
            database.add( dto );
            result = 1;
        }
        else {
            database.add( dto );
            result = 1;
        }
        return result;
    }
    
    protected int updateDept( DeptDTO dto ) {
        log.info( dto );
        int result = -1;
        
        for ( int i = 0; i < database.size(); i++ ) {
            
            if ( database.get( i ).getDeptno() == dto.getDeptno() ) {
                database.get( i ).setDName( dto.getDName() );
                database.get( i ).setLoc( dto.getLoc() );
                result = 1;
                return result;
            }
        }
        log.error( dto.getDeptno() + " : 일치하는 부서번호가 없습니다." );
        return result;
    }
    
    protected int deleteDept( DeptDTO dto ) {
        int result = -1;
        
        for ( int i = 0; i < database.size(); i++ ) {
            
            if ( database.get( i ).getDeptno() == dto.getDeptno() ) {
                database.remove( i );
                result = 1;
                break;
            }
        }
        return result;
    }
    
    // 서로 다른 패키지에 있다하더라도 상속관계에 있으면 사용 가능하다.
    protected List<DeptDTO> selectDept() {
        
        if ( database.size() == 0 ) {
            dataInitialize();
        }
        return database;
    }
    
}
