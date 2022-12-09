package b3_1209;

import java.util.Arrays;
import java.util.Iterator;

// 학생별 총점, 평균,과목의 평균, 석차를 구하는 프로그램을 작성하시오.

// JAVA sum = data[0][1] + data[1][1] + data[2][1]
// ORACLE sum = data[0][2] + data[1][2] + data[2][2]
// Spring sum = data[0][3] + data[1][3] + data[2][3]

// 학생의 총점
// 이순신 총점 = data[0][1] + data[0][2] + data[0][3]
// 강감찬 총점 = data[1][1] + data[1][2] + data[1][3]
// 김춘추 총점 = data[2][1] + data[2][2] + data[2][3]

// 석차
// 비교 연산자...? 이순신 총점 - 강감찬 총점 - 김춘추 총점 비교

public class Student {
    
    String[]   subject = { "JAVA", "ORACLE", "Spring" };
    String[][] data    = { { "이순신", "80", "75", "70" }, { "강감찬", "90", "85", "95" }, { "김춘추", "65", "60", "60" } };
        
    int[] total = new int[3];
    double[] avgs = new double[3];
    
    void studentArray() {
        
        int javaSum   = 0;
        int oracleSum = 0;
        int springSum = 0;
        
        for ( int i = 0; i < data.length; i++ ) {
            javaSum += Integer.parseInt( data[i][1] );
        }
        
        for ( int j = 0; j < data.length; j++ ) {
            oracleSum += Integer.parseInt( data[j][2] );
        }
        
        for ( int k = 0; k < data.length; k++ ) {
            springSum += Integer.parseInt( data[k][3] );
        }
        System.out.println( "JAVA의 합계는" + javaSum + "입니다." );
        System.out.println( "ORACLE의 합계는" + oracleSum + "입니다." );
        System.out.println( "ORACLE의 합계는" + springSum + "입니다." );
        
        System.out.println( "" );
        
    }
    
    void javaTotal() {
        int javaSum = 0;
        
        for ( int i = 0; i < data.length; i++ ) {
            javaSum += Integer.parseInt( data[i][1] );
        }
        System.out.println( "JAVA 과목의 총점은" + javaSum + "입니다." );
        
    }
    
    void nameSum() {
        
        int leeSum  = 0;
        int kangSum = 0;
        int kimSum  = 0;
        
        for ( int i = 1; i <= data.length; i++ ) {
            leeSum += Integer.parseInt( data[0][i] );
        }
        
        for ( int i = 1; i <= data.length; i++ ) {
            kangSum += Integer.parseInt( data[1][i] );
        }
        
        for ( int i = 1; i <= data.length; i++ ) {
            kimSum += Integer.parseInt( data[2][i] );
        }
        
        float avg = 3.0f;
        System.out.println( "이순신 학생의 총점은" + leeSum + "입니다." );
        System.out.println( "강감찬 학생의 총점은 " + kangSum + "입니다." );
        System.out.println( "김춘추 학생의 총점은 " + kimSum + "입니다." );
        
        System.out.println( "이순신 학생의 평균은" + leeSum / avg + "입니다." );
        System.out.println( "강감찬 학생의 평균은 " + kangSum / avg + "입니다." );
        System.out.println( "김춘추 학생의 총점은 " + kimSum / avg + "입니다." );
    }
    
    void allAvg() {
        for (int i=0; i<total.length; i++) {
            
        }
    }
    public static void main( String[] args ) {
        
        Student test = new Student();
        test.nameSum();
        
        // test.studentArray( test.data );
        
    }
}
