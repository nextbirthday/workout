package crud;

import java.util.ArrayList;
import java.util.List;

public class ProductController {
    ProductModel model = new ProductModel();
    
    public List<Product> cudProduct( String cmd ) {
        
        List<Product> productList = new ArrayList<>();
        
        switch ( cmd ) {
            
            case "I":
                productList = model.insertProduct();
                break;
            
            case "U":
                break;
            
            case "D":
                break;
            
        }
        
        return productList;
    }
    
    public List<Product> selectProduct() {
        
        return model.selectProduct();
    }
}
