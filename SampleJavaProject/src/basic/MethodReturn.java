package basic;

public class MethodReturn {
    
    MethodReturn() {
        System.out.println( "MethodReturn 생성자 호출" );
    }
    
    public void returnNothing() {
        System.out.println( "메서드 이름 앞에 void 붙으면 아무 것도 리턴하지 않는 메서드" );
    }
    
    public String returnString() {
        String returnStr = "얘는 리턴할 변수예요 ㅎㅎ";
        System.out.println( "메서드 이름 앞에 타입이 붙으면 그 타입 변수를 리턴하는 메서드" );
        return returnStr;
    }
    
    public static void main( String[] args ) {
        MethodReturn refVariable = new MethodReturn(); //인스턴스화
       //new MethodReturn();
        refVariable.returnNothing();
        
        String returnedString = null; 
        System.out.println( returnedString );
        
        returnedString = refVariable.returnString();
        System.out.println( returnedString );     
        
    }
}
