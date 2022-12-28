package lecture_2022_12.week_4_CRUD;

import java.util.List;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class DeptController {
    
    private DeptModel model = new DeptModel();
    
    public int cudTeam( TeamInfo team, String cmd ) {
        int result = 0;
        log.info( cmd );
        log.info( team.toString() );
        
        switch ( cmd ) {
            case "INSERT":
                result = model.insertTeam( team );
                log.info( result );
                break;
            
            case "UPDATE":
                log.info( "Controller UPDATE" );
                log.info( team );
                result = model.updateTeam( team );
                break;
                
            case "DELETE":
                result = model.deleteTeam( team );
                break;
                
            default:
                break;
        }
        return result;
    }
    
    public List<TeamInfo> getTeam() {
        
        return model.selectTeam();
    }
    
}
