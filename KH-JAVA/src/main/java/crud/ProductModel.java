package crud;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ProductModel {
    
    List<Product> productList = new ArrayList<>();
    InsertDialog  dialog;
    
    public List<Product> insertProduct() {
        
        int result = 0;
        
        productList = new InsertDialog().setText();
        
        return productList;
    }
    
    public List<Product> selectProduct() {
        
        return productList;
    }
}
