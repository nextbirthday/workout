package b3_1205;

public class OperatorEx2 {
    
    public static void main( String[] args ) {
        // int i = 1;
        int i = 10;
        
        switch ( i ) {
            case 0:
                ++i; // 실행문
                break;
            case 1:
                ++i;// 실행문
                break;
            default:
                ++i;
        }// end of switch
         // insert here i는 얼마일까요?
        System.out.println( i );
    }
    
}
