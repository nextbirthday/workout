package b3_1212;

import javax.swing.JDialog;


public class AddressDialog {
    JDialog jdg = new JDialog();
    
    AddressBook ab = null;
    
    public AddressDialog( AddressBook ab ) {
        this.ab = ab;
    }
    
    public AddressDialog() {}

    public void setDialog( String title, boolean isView ) {
        // 무엇을 제어하기 위해서 이 메서드를 선언했는지?
        // setTitle 먼저 호출 String 변수 title
        // sub에 있는 setVisible 메서드를 호출 하는데 파라미터는 변수
        // parameter를 통해 결정되도록 한다.
        jdg.setSize( 600, 500 );
        jdg.setTitle( title );
        jdg.setVisible( isView );
        jdg.setDefaultCloseOperation( JDialog.DISPOSE_ON_CLOSE );
    }
    
}
