package java_b3_1202;

public class MemberVOMain {
    
    public static void main( String[] args ) {
        
        MemberVO memberVO = new MemberVO(); //인스턴스화        
        
        // MemberVO class에서 mem_id의 접근제한자가 private이므로 외부에서 접근이 불가능하다.
        // 그래서 setter메서드를 제공하고 있다.
        // private으로 선언된 변수는 클래스 외부에서 사용이 불가능하다. -캡슐화        
        // return 타입이 있는 getter에서 쓸 수 있다.
        
        memberVO.setMem_id( "apple" ); // setter 메서드를 호출하는 것만으로 초기화된다.
        System.out.println( memberVO.getMem_id() ); // apple 출력        
        
        memberVO.setMem_pw( "921226" ); // setter 메서드를 호출하면 전역변수인 mem_pw가 초기화된다.
        System.out.println( memberVO.getMem_pw() ); // getter 메서드를 호출하면 전역변수인 mem_pw에 저장된 값이 출력된다.
        // 만일 20번 setter메서드를 호출하지 않으면 null이 출력될것 (주의)        
        
        // mem_name의 경우 접근제한자를 public으로 했으므로 직접 초기화가 가능하다.        
        memberVO.mem_name = "토마토";
        //String name = memberVO.mem_name; // null
        System.out.println( memberVO.mem_name );
        
    }
    
}
