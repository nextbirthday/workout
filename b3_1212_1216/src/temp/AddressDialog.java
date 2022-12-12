package temp;

import javax.swing.JDialog;

public class AddressDialog {
    JDialog jdg = new JDialog();
    
    AddressBook ab = null;
    
    public AddressDialog( AddressBook ab ) {
        this.ab = ab;
        init();
    }
    
    private void init() {
        jdg.setSize( 500, 400 );
        jdg.setDefaultCloseOperation( JDialog.DISPOSE_ON_CLOSE );
    }
    
    public void titleChange( String title ) {
        jdg.setTitle( title );
    }
    //
    // public static void main( String[] args ) {
    // new AddressBook();
    // }
    
}
