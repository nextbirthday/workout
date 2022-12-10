package b3_1207;

public class IntArray04 {
    
    String names[] = new String[] { "이순신", "강감찬", "김춘추" };
    
    void methodA() {
        
        for ( int i = 0; i < 3; i++ ) {
            System.out.println( names[i] );
        }
    }
    
    int[] methodB() { // 반환형으로 배열을 사용하였다.
        // 지역 변수를 메서드 밖에서 사용 가능하다.
        int deptnos[] = { 10, 20, 30 };
        deptnos[0] = deptnos[0] - 1;
        deptnos[1] = deptnos[1] - 2;
        deptnos[2] = deptnos[2] - 3;
        return deptnos; 
        //반환타입(반환형)이 있으면 리턴 예약어를 반드시  써야한다.
        // 리턴 할 때는 배열기호를 안써도 된다.
    }
    
    public static void main( String[] args ) {
        IntArray04 ia = new IntArray04();
        System.out.println( "=======[[ methodA 출력 - 출력문 포함 ]]=======" );
        ia.methodA();
        System.out.println( "=======[[ methodB 출력 - main()에서 출력 ]]=======" );
        int 부서번호들[] = ia.methodB();
        
        for ( int i = 0; i < 3; i++ ) {
            System.out.println( 부서번호들[i] );
        }
    }
    
}
