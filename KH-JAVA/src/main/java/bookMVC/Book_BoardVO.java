package bookMVC;

import lombok.Data;

@Data

public class Book_BoardVO {
    private int    b_no;
    private int    mem_no;
    private String b_title;
    private String b_content;
    private int    b_hit;
}
