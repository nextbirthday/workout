package dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ZipCodeDTO {
    private int    uid_no;
    private int    zipcode;
    private String zdo;
    private String sigu;
    private String dong;
    private String ri;
    private String bungi;
    private String aptname;
    private String upd_date;
    private String address;
}
