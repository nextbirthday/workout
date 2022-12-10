package b3_1205;

public class MemberInit {
    // 디폴트 생성자라고 부른다. - 디폴트 생성자는 파라미터를 결정해줄 필요없다.
    // 생략하면 JVM이 대신 생성해주어 전역변수들을 초기화 시킴
    static int i;
    int hap;
    
    public MemberInit() { //똑같이 괄호가 있지만 리턴타입이 없다.
        System.out.println( "디폴트 생성자 호출 성공" + " " + i + "," + hap ); 
    }
    
    public MemberInit( int i, int hap ) {
        this.i = i; // 파라미터 i = 0의 값을 전역변수 i에 대입
        this.hap = hap; 
        System.out.println( "파라미터가 두 개인 생성자 호출 성공" + " " + this.i + "," + this.hap ); // 1, 0
    }
    
    public static void main( String[] args ) {
        MemberInit mi  = new MemberInit(); // 9번 '생성자 호출' - 메서드 오버로딩 매커니즘을 따른다.
        MemberInit mi2 = new MemberInit( 1, 0 ); // 13번 생성자 호출        
    }
    
}
