package b3_1212;

public class GradeCalc {
    
    public void calc( String[][] data ) {
        double javaSum      = 0;
        double orecleSum    = 0;
        double springSum    = 0;
        int    subjectCount = 3;
        
        for ( int row = 0; row < data.length; row++ ) {
            System.out.println( data[row][0] + "의 성적" );
            
            double sum = Integer.parseInt( data[row][1] ) + Integer.parseInt( data[row][2] ) + Integer.parseInt( data[row][3] );
            System.out.println( "총점 : " + sum );
            System.out.println( "평균 : " + sum / subjectCount + "\n" );
            javaSum += Integer.parseInt( data[row][1] );
            orecleSum += Integer.parseInt( data[row][2] );
            springSum += Integer.parseInt( data[row][3] );
        }
        System.out.println( "JAVA과목의 총점은" + javaSum + "입니다.\n" + "ORACLE과목의 총점은" + orecleSum + "입니다.\n" + "Spring과목의 총점은" + springSum + "입니다." );
        
    }
    
    public static void main( String[] args ) {
        GradeCalc  gc   = new GradeCalc();
        String[][] data = { { "이순신", "80", "75", "70" }, { "강감찬", "90", "85", "95" }, { "김춘추", "65", "60", "60" } };
        gc.calc( data );
    }
    
}
