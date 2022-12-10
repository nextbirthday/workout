package b3_1205;

public class Quiz01 {
    
    public static void main( String[] args ) {
        
        // 합을 담을 변수 선언
        int sum = 0; // 지역변수니까 초기화 해야한다.
        // 0으로 초기화하는 이유는 답에 영향을 주면 안되니까
        
        // 1씩 세는 변수 선언
        int cnt =1;        
        
        // for(초기화;조건식;증감식) {}
        
        for ( ; cnt <= 10; cnt++ ) {
            
            if ( cnt % 2 == 0 ) {
                sum += cnt;
            }
            // System.out.println( "sum" + sum + "," + "cnt" + cnt );
        }
        System.out.printf( "sum:%d, cnt:%d %n", sum, cnt );
        //System.out.println( "sum" + sum + "," + "cnt" + cnt );
        // 콘솔창에 무언가를 출력하는 행위는 서버에 대한 부담
    }
    
}
