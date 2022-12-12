package b3_1212;

import javax.swing.JDialog;

public class AddressDialog {
    JDialog jdg = new JDialog();
    
    AddressBook ab = null;
    
    public AddressDialog( AddressBook ab ) {
        this.ab = ab;
        ab.detailButton.getText();
    }
    
    
    void titleChange() {
     
    }
    
    public static void main( String[] args ) {
        new AddressBook();
    }
    
}
