package dept;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class DeptModel {
    // 리스트를 DB라고 가정한다.
    List<DeptDTO> dataBase = new ArrayList<>();
    
    private List<DeptDTO> dataInitialize() {
        dataBase.add( new DeptDTO( 10, "인사부", "서울" ) );
        dataBase.add( new DeptDTO( 20, "영업부", "안양" ) );
        dataBase.add( new DeptDTO( 30, "개발부", "대전" ) );
        dataBase.add( new DeptDTO( 40, "사업부", "대구" ) );
        dataBase.add( new DeptDTO( 50, "총무부", "제주" ) );
        return dataBase;
    }
    
    protected int insertDept( DeptDTO dto ) {
        log.info( dto );
        int result = -1;
        
        if ( dataBase.size() > 0 ) {
            
            for ( int i = 0; i < dataBase.size(); i++ ) {
                
                if ( dataBase.get( i ).getDeptno() == dto.getDeptno() ) {
                    log.error( "제약조건을 위반하였습니다." );
                    return result;
                }
            }
            dataBase.add( dto );
            result = 1;
        }
        else {
            dataBase.add( dto );
            result = 1;
        }
        return result;
    }
    
    protected int updateDept( DeptDTO dto ) {
        log.info( dto );
        int result = -1;
        
        for ( int i = 0; i < dataBase.size(); i++ ) {
            
            if ( dataBase.get( i ).getDeptno() == dto.getDeptno() ) {
                dataBase.get( i ).setDname( dto.getDname() );
                dataBase.get( i ).setLoc( dto.getLoc() );
                result = 1;
                return result;
            }
        }
        log.error( dto.getDeptno() + " : 일치하는 부서번호가 없습니다." );
        
        return result;
    }
    
    protected int deleteDept( DeptDTO dto ) {
        log.info( dto );
        int result = -1;
        
        for ( int i = 0; i < dataBase.size(); i++ ) {
            
            if ( dataBase.get( i ).getDeptno() == dto.getDeptno() ) {
                dataBase.remove( i );
                result = 1;
                break;
            }
        }
        return result;
    }
    
    protected List<DeptDTO> selectDept() {
        
        if ( dataBase.size() == 0 ) {
            dataInitialize();
        }
        return dataBase;
    }
    
    public static void main( String[] args ) {}
}
