package crud;

import java.util.ArrayList;
import java.util.List;

public class ProductModel {
    
    List<Product> productList = new ArrayList<>();
    InsertDialog  dialog;
    
    public List<Product> insertProduct() {
        
        int result = 0;
        
        if ( productList.size() == 0 ) {
            // dialog = new InsertDialog().setText();
        }
        
        return productList;
    }
    
    public List<Product> selectProduct() {
        
        if ( productList.size() == 0 ) {}
        
        return productList;
    }
}
