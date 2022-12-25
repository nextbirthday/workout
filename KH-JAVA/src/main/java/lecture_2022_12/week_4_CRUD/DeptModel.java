package lecture_2022_12.week_4_CRUD;

import java.util.List;
import java.util.Vector;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class DeptModel {
    
    List<TeamInfo> teamList = new Vector<>(); // 임시 DataBase의 역할
    
    private List<TeamInfo> dataInitialize() {
        
        teamList.add( TeamInfo.builder().teamNumber( 10 ).teamName( "인사팀" ).teamLoc( "서울특별시 송파구 올림픽로 300" ).memberNumber( 7 ).build() );
        teamList.add( TeamInfo.builder().teamNumber( 20 ).teamName( "마케팅1팀" ).teamLoc( "서울특별시 송파구 올림픽로 300" ).memberNumber( 15 ).build() );
        teamList.add( TeamInfo.builder().teamNumber( 30 ).teamName( "영업팀" ).teamLoc( "서울특별시 송파구 올림픽로 300" ).memberNumber( 20 ).build() );
        
        return teamList;
    }
    
    protected int insertTeam( TeamInfo team ) {
        int result = 0;
        log.info( teamList );
        
        if ( teamList.size() == 0 ) {
            
            teamList.add( team );
            log.info( teamList );
            result = 1;
        }
        else {
            
            for ( int i = 0; i < teamList.size(); i++ ) {
                
                if ( team.teamNumber == teamList.get( i ).teamNumber ) {
                    
                    return result;
                }
            }
            teamList.add( team );
            log.info( teamList );
            result = 1;
        }
        
        return result;
    }
    
    protected int updateTeam( TeamInfo team ) {
        int result = 0;
        
        for ( int i = 0; i < teamList.size(); i++ ) {
            
            if ( team.getTeamNumber() == teamList.get( i ).teamNumber ) {
                teamList.get( i ).setTeamName( team.getTeamName() );
                teamList.get( i ).setTeamLoc( team.getTeamLoc() );
                teamList.get( i ).setMemberNumber( team.getMemberNumber() );
                result = 1;
                break;
            }
        }
        
        log.info( team );
        return result;
    }
    
    protected int deleteTeam( TeamInfo team ) {
        int result = 0;
        
        for ( TeamInfo teamInfo : teamList ) {
            
            if ( team.getTeamNumber() == teamInfo.teamNumber ) {
                teamList.remove( teamInfo );
                result = 1;
                break;
            }
        }
        return result;
    }
    
    protected List<TeamInfo> selectTeam() {
        
        if ( teamList.size() == 0 ) {
            dataInitialize();
        }
        
        return teamList;
    }
}
