package basic;

public class ParameterAndReturn {
    
    public String getAndReturn( String parameterString ) {
        // String s1 값을 복사한 parameterString을 메서드 내에서 지역변수로 사용한다.
        System.out.println( "getAndReturn : " + parameterString );
        // 메서드가 반환되면서 parameterString도 사라지나, return 으로 넘겨주기 때문에
        // 이 메서드를 호출한 쪽으로 값을 전달할 수 있다.
        return parameterString + "을 리턴";
    }
    
    public static void main( String[] args ) {
        ParameterAndReturn par = new ParameterAndReturn();
        String             s1  = "파라미터로 넘길 스트링";
        String             s2  = null;
        System.out.println( "s1 초기화 : " + s1 );
        System.out.println( "s2 초기화 : " + s2 );
        // getAndReturn 메서드에서 [parameterString + "을 리턴"] 이라는 String을 전달했고, s2에 대입
        s2 = par.getAndReturn( s1 );
        // String s1은 값을 복사해서 넘겨주기 때문에 s1 원본이 변경되지는 않는다.
        System.out.println( "메서드 리턴 후 s1 : " + s1 );
        System.out.println( "메서드 리턴 후 s2 : " + s2 );
    }
}
