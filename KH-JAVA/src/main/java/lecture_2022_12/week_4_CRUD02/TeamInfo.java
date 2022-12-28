package lecture_2022_12.week_4_CRUD02;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TeamInfo {
    int    teamNumber;
    String teamName;
    String teamLoc;
    int    memberNumber;
}
