package b3_1209;

public class AccountSample {
    
    ButtonArray ba = null; // 선언만
    
    int i;
    
    public AccountSample( ButtonArray ba ) {
        this.ba = ba;
        i = 10;
    }
    
    public AccountSample() {
        
    }
    // public AccountSample(ButtonArray abc, String str) {
    // this.ba = abc;
    // i =10;
    // 생성자 안에서 전역변수를 초기화할 수 있다.
    // 전역변수는 초기화를 해주지 않아도 된다. 왜냐하면 생성자가 초기화 해줄 수 있으니까
    
    public String account() {
        int i = 10;
        return "낮춰라";
        
    }
    
    public void account2() {
        String message = "낮춰라";
        // jta_display는 ButtonArray에서 생성된 객체인데
        // 굳이 AccountSample에서 사용하고 싶다고 한다. 어떡하지?
        ba.jta_display.append( message + "\n" ); // 객체 주입을 해야하는 순간
        // NullPointerException
    }
    
    public static void main( String[] args ) {
        AccountSample as = new AccountSample();
        as.i = 100;
        System.out.println( as.i );
    }
    
}
