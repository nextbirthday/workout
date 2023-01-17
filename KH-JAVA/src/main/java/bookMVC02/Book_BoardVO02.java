package bookMVC02;

import lombok.Data;

@Data

public class Book_BoardVO02 {
    private int    b_no;
    private int    mem_no;
    private String b_title;
    private String b_content;
    private int    b_hit;
}
