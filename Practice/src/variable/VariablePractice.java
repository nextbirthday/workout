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
        System.out.printf( "반지름이 %d인 원의 둘레 :%.1f|n", rad, 2 * rad * pi );
        System.out.printf( "반지름이 %d인 원의 둘레 :%.1f|n", rad, rad * rad * pi );
        
    }
}
