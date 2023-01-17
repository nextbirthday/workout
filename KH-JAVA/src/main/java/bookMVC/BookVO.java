package bookMVC;

import lombok.Data;

@Data
public class BookVO {
    
    private int    bk_no;
    private String bk_title;
    private int    bk_price;
    private String bk_date;
    private String bk_publish;
    private String bk_info;
    private String bk_author;
    
}
