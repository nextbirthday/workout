package java_b3_1202;

class Static2 {
    int i;
}

class Static21 {
    static int i; //정적 변수
    int y;
}

public class StaticExam {
    
    public static void main( String[] args ) {
        Static2 static2 = new Static2();
        System.out.println( static2.i );
        System.out.println( Static21.i );
        //System.out.println( Static21.y );
    }
    
}
