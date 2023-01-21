package product.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductVO {
    
    private int    productcode;
    private String product;
    private String productname;
    private int    price;
    private int    availability;
    
}
