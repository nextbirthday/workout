package java_b3_1202;

public class MemberAction {
    // 회원가입이 성공하면 1을 반환, 실패하면 0을 반환
    // 회원가입을 처리하는 메서드 선언하기
    
    public int memberinsert( String mem_id, String mem_pw, String mem_name ) {
        System.out.println( "memberinsert 호출 : 파라미터 3개" );
        System.out.println( mem_id + "," + mem_pw + "," + mem_name );
        
        int result = -1; // end of file
        result = 0;
        
        if ( 1 == 1 ) {
            result = 1;
        }
        else {
            result = 0;
        }
        return result;
    }
    
    public int memberinsert( MemberVO memberVO ) {
        System.out.println( "meeberinsert 호출 : 파라미터 1개" );
        System.out.println( memberVO.getMem_id() + "," + memberVO.getMem_pw() + "," + memberVO.getMem_name() );
        
        int result = -1;
        result = 0;
        return result;
    }
    
    public static void main( String[] args ) {
        
        // insert here - memberinsert 메서드를 호출하시오.
        MemberAction memberAction = new MemberAction();
        
        int result = memberAction.memberinsert( "apple", "921226", "steve" );
        
        if ( result == 1 ) {
            System.out.println( "회원가입 성공!" );
        }
        else {
            System.out.println( "회원가입 실패!" );
        }
        
        MemberVO memberVO = new MemberVO();
        
        memberVO.setMem_id( "tomato" );
        memberVO.setMem_pw( "951225" );
        memberVO.setMem_name( "joe" );
        int result2 = memberAction.memberinsert( memberVO );
        
        if ( result2 == 1 ) {
            System.out.println( "회원가입 성공!" );
        }
        else {
            System.out.println( "회원가입 실패!" );
        }
    }
}
