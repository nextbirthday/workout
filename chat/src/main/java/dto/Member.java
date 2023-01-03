package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Member {
    private int    user_id;
    @NonNull
    private String nickname;
    @NonNull
    private String password;
    @NonNull
    private String phone_number;
    private String activate;
    private String joined_at;
    private String deactivated_at;
}
