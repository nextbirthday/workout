package b3_1212;

public class Sub {
    
    int j = 2;
    
    public static void main( String[] args ) {
        
        Main test = new Main();
        
        test.getIsOk();// 왜 for문 전에 메서드를 호출하면 NullPointerException이 발생안하는지...?
                
        for ( int i = 0; i < test.isOk.length; i++ ) {
            System.out.println( test.isOk[i] );
        }
        
    }
    
}
