package b3_1212;

public class JTextAreaUILogic2 {
    
    JTextAreaUI2 bear = null;
    // 여기서 인스턴스화 하면 복제본이 만들어짐
    // why? 복제본에 출력되니까
   
    public JTextAreaUILogic2( JTextAreaUI2 jTextAreaUI2 ) {
        // 생성자 안에서 JTextAreaUI의 JTextArea 원본과 전역변수를 초기화해주어야한다.
        this.bear = jTextAreaUI2;        
    }
    
    public void account( String input ) {
        bear.jta.append( "UILogic2 : " + input + "\n" );
    }
}
