package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Member {
    private int    user_id;
    private String nickname;
    private String password;
    private String phone_number;
    private String activate;
    private String joined_at;
    private String deactivated_at;
}
