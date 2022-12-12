package temp;

import javax.swing.JDialog;

public class AddressDialog {
    protected JDialog dialog;
    // private JDialog dialog;
    
    public AddressDialog() {
        initDisplay();
    }
    
    public AddressDialog( String title ) {
        initDisplay( title );
    }
    
    /**
     * 타이틀 없이 다이얼로그를 초기화하는 메서드
     * <p>
     * 타이틀 초기화는 changeTitle() 에서 수행한다.
     */
    private void initDisplay() {
        dialog = new JDialog();
        dialog.setSize( 500, 400 );
        dialog.setDefaultCloseOperation( JDialog.DISPOSE_ON_CLOSE );
        dialog.setVisible( true );
    }
    
    /**
     * 타이틀을 파라미터로 받아 다이얼로그를 초기화하는 메서드
     * 
     * @param title 타이틀로 사용할 String
     */
    private void initDisplay( String title ) {
        dialog = new JDialog();
        dialog.setTitle( title );
        dialog.setSize( 500, 400 );
        dialog.setDefaultCloseOperation( JDialog.DISPOSE_ON_CLOSE );
        dialog.setVisible( true );
    }
    
    /**
     * 문자열을 파라미터로 받아 다이얼로그의 타이틀을 설정하는 메서드
     * 
     * @param title 타이틀로 사용할 String
     */
    public void changeTitle( String title ) {
        dialog.setTitle( title );
    }
}
