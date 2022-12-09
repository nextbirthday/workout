package b3_1209;

public class AccountSample {
    
    ButtonArray ba = null;
    
    public AccountSample(ButtonArray ba) {
        this.ba = ba;
    }
    public String account() {
        return "낮춰라";
    }
    
    public void account2() {
        String message = "낮춰라";
        //jta_display는 ButtonArray에서 생성된 객체인데
        //굳이 AccountSample에서 사용하고 싶다고 한다. 어떡하지?
        ba.jta_display.append( message + "\n" ); // 객체 주입을 해야하는 순간
        //NullPointerException
    }
}
