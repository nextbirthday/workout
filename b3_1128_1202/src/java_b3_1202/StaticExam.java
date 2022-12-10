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
        Static2 static2 = new Static2(); // 인스턴스화
        System.out.println( static2.i ); //static2인스턴스변수 안에 있는 int i 를 출력
        System.out.println( Static21.i );
        //System.out.println( Static21.y );
    }
    
}
