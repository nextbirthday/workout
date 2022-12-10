package b3_1205;

public class Printf {
    
    public static void main( String args[] ) {
        int a = 10;
        int b = 4;
        // printf()는 지시자를 통해 변수의 값을 여러 가지 형식으로 변환하여 출력할 수 있다.
        // System.out.printf( null, args );
        // System.out.printf("출력 서식",출력할 내용);
        // 출력 후 줄바꿈을 하지 않는다. 줄바꿈을 하려면 지시자 '%n'을 넣어줘야 한다.
        // 출력하려는 값의 수만큼 지시자도 사용해야 한다.
        // 출력될 값과 지시자의 순서는 일치해야 한다.
        // 지시자를 제외한 문자는 입력한 그대로 출력된다.
        // %b boolean 형식으로 출력
        // %d 정수 형식으로 출력
        // %f 소수점 형식으로 출력
        // %c 문자형식으로 출력
        // %s 문자열 형식으로 출력
        // %n 줄바꿈 기능
        System.out.printf( "%d + %d + %d = %d%n", a, a, a, a+a+a  );
        System.out.printf( "%d + %d = %d%n", a, b, a + b );
        System.out.printf( "%d - %d = %d%n", a, b, a - b );
        System.out.printf( "%d * %d = %d%n", a, b, a * b );
        System.out.printf( "%d / %d = %d%n", a, b, a / b );
        System.out.printf( "%d / %f = %f%n", a, ( float ) b, a / ( float ) b );
    }
    
}
