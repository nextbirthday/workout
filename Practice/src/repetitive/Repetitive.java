package repetitive;

public class Repetitive {
    
    public void testFor() {
        
        // for( 초기문; 조건식; 증감식;){}
        // i를 증가
        for ( int i = 0; i < 10; i++ ) {
            System.out.println( i + "번째 출력" );
        }
        
        // i를 감소
        for ( int i = 10; i > 0; i-- ) {
            System.out.println( i + "번째 출력" );
        }
        
        // 증감식은 반드시 1씩 증감할 필요는 없음
        for ( int i = 0; i < 10; i += 2 ) {
            System.out.println( i + "번째 출력" );
        }
        
        // int 자료형이 아닌 char 자료형을 입력하면?
        for ( char ch = 'a'; ch < 'f'; ch++ ) {
            System.out.println( ch );
        }
        
    }
    
    public void testWhile() {
        
        int i = 0; // 초기식
        
        while ( i < 10 ) { // 조건식
            System.out.println( i + "번째 출력" );
            i++; // 증감식
        }
        // 감소
        int j = 10;
        
        while ( j > 0 ) {
            System.out.println( j + "번째 j출력" );
            j--;
        }
        
        // 무한 루프 : 조건 값을 항상 true
        int p = 0;
        
        while ( true ) {
            System.out.println( p++ + "번째 p 출력" );
        }
    }
        
        public void testGugudan(){
           
            
            for(int i = 2; i<10; i++) {
                System.out.println( "=====" + i + "단=====" );
                for(int j =1; j<10; j++) {
                    System.out.println( i+ "X" + j + "=" + i*j );
                }
            }
        }
        
       
        
    }

