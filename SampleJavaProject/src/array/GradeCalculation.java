package array;

public class GradeCalculation {
    
    public void calc( String[][] data ) {
        
<<<<<<< HEAD
        double javaSum  = 0; // local variable
        double dbSum    = 0;
        double linuxSum = 0;
        int    rowCount = 0; //why??
=======
        double    javaSum      = 0;
        double    dbSum        = 0;
        double    linuxSum     = 0;
        final int subjectCount = 3;
>>>>>>> 3d18819baf8d81e8fb30f7f8ceae55cde9d5256f
        
        for ( int row = 0; row < data.length; row++ ) {
            System.out.println( data[row][0] + "의 성적" );
            double sum = Integer.parseInt( data[row][1] ) + Integer.parseInt( data[row][2] ) + Integer.parseInt( data[row][3] );
            System.out.println( "총점 : " + sum );
            System.out.println( "평균 : " + ( sum / subjectCount ) + "\n" );
            
            javaSum += Integer.parseInt( data[row][1] );
            dbSum += Integer.parseInt( data[row][2] );
            linuxSum += Integer.parseInt( data[row][3] );
        }
        System.out.println( "과목별 총점 및 평균\nJAVA 총점 : " + javaSum + ", 평균 : " + ( javaSum / data.length ) + "\nDB 총점 : " + dbSum + ", 평균 : " + ( dbSum / data.length )
                        + "\nLinux 총점 : " + linuxSum + ", 평균 : " + ( linuxSum / data.length ) );
    }
    
    public static void main( String[] args ) {
        GradeCalculation gc   = new GradeCalculation();
        String[][]       data = { { "이순신", "80", "75", "70" }, { "강감찬", "90", "85", "95" }, { "김춘추", "65", "60", "60" } };
        gc.calc( data );
    }
}
