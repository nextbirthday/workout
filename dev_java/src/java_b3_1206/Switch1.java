package java_b3_1206;

public class Switch1 {
    public static void main( String[] args ) {
        
        String bread = "donut"; 
        
        switch ( bread ) {//변수 사용
            case "소보로": {
                int protocol = 100;
                System.out.println( "소보로 빵 입니다." + protocol );
                break;
            }
            case "donut": { // case문 안에서도 scope를 가져갈 수 있고 그 안에서 지역변수처럼 사용할 수 있다.
                int protocol = 200;
                System.out.printf( "%s입니다. %d%n", bread, protocol );
                break;
            }
            default:
                System.out.println( "원하는 빵이 없습니다." );
                break;
        }// end of switch
    }
}
