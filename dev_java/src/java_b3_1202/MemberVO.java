package java_b3_1202;

public class MemberVO {
    
    // data set이므로 main method가 없어도 된다.
    // 자료구조의 일부로 사용한다.
    // MemberVo class는 회원정보를 관리하기 위한 목적으로 설계되었다.
    // 고로 MemberVO class에서는 main 메서드는 필요없다.    
    private String mem_id   = null;
    private String mem_pw   = null;
    private String mem_name = null;
    
    // setter는 write, save
    // setter 메서드를 통해서 전역변수를 초기화 할 수 있다!!!
    // setter 메서드는 저장만 하는 역할
    // this를 붙일 수 있는 것은 전역변수이다.
    // setter 메서드를 활용하여 전역변수 mem_id를 초기화한다.
    public void setMem_id( String mem_id ) { this.mem_id = mem_id; }
    
    // getter는 read, listening
    public String getMem_id() { return mem_id; }     
   

    public String getMem_pw() { return mem_pw; }

    public void setMem_pw( String mem_pw ) { this.mem_pw = mem_pw; }

    public String getMem_name() { return mem_name; }

    public void setMem_name( String mem_name ) { this.mem_name = mem_name; }

    public static void main( String[] args ) {
        
        MemberVO memberVO = new MemberVO();
        memberVO.setMem_id("123");
        System.out.println( memberVO.mem_name ); //null  
        
    }   
    
}
