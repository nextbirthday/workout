package variable;

import java.util.Scanner;

public class VariablePractice {
    
    public void method1() {
        
        int     inum = 100;
        double  dnum = 234.567;
        char    ch   = 'A';
        String  str  = "Hello world";
        boolean bool = true;
        
        System.out.println( "초기화 후 :" + inum + "," + dnum + "," + ch + "," + str + "," + bool );
        
        inum = 10000;
        dnum = 567.123456789;
        ch = 'B';
        str = "Welcome to JAVA";
        bool = false;
        
        System.out.println( "값 변경 후 :" + inum + "," + dnum + "," + ch + "," + str + "," + bool );
    }
    
    public void method2() {
        // Q2. 원의 둘레와 면적 구하기
        Scanner sc = new Scanner( System.in );
        System.out.println( "원의 반지름 입력:" );
        int    rad = sc.nextInt();
        double pi  = 3.14;
        
        // System.out.println( "반지름이" + rad +"인 원의 둘레 :" + 2*rad*pi );
        // System.out.println( "반지름이" +rad+ "인 원의 넓이 :" + rad*rad*pi );
        
        // 소수점 아래 한자리까지
        System.out.printf( "반지름이 %d인 원의 둘레 :%.1f\n", rad, 2 * rad * pi );
        System.out.printf( "반지름이 %d인 원의 둘레 :%.1f\n", rad, rad * rad * pi );
        
    }
    
    public void method3() {
        // Q3. 학생들의 키(실수)의 평균(정수) 구하기
        Scanner sc = new Scanner( System.in );
        System.out.println( "첫 번째 학생의 키 입력 :" );
        double height1 = sc.nextDouble();
        System.out.println( "두 번째 학생의 키 입력 :" );
        double height2 = sc.nextDouble();
        System.out.println( "세 번째 학생의 키 입력 :" );
        double height3 = sc.nextDouble();
        
        int avg = ( int ) ( height1 + height2 + height3 ) / 3;
        System.out.println( "키의 평균 :" + avg );
    }
    
    public void method4() {
        // Q4 문자열을 입력받아 각자의 유니코드를 출력
        Scanner sc = new Scanner( System.in );
        System.out.println( "문자열 입력 :" );
        String str = sc.nextLine();
        
        char ch  = str.charAt( 0 );
        int  num = ch;             // char => int로 자동 형변환
        System.out.println( ch + ":" + num );
        
        // 한 번에 출력
        System.out.println( str.charAt( 0 ) + ":" + ( int ) str.charAt( 0 ) );
        System.out.println( str.charAt( 1 ) + ":" + ( int ) str.charAt( 1 ) );
        System.out.println( str.charAt( 2 ) + ":" + ( int ) str.charAt( 2 ) );
        System.out.println( str.charAt( 3 ) + ":" + ( int ) str.charAt( 3 ) );
        System.out.println( str.charAt( 4 ) + ":" + ( int ) str.charAt( 4 ) );
    }
}
