package b3_1213;

public class GradeProcess {
    
    String[]   header = { "이름", "국어", "영어", "수학", "총점", "평균", "석차" };
    String[][] data   = { { "홍길동", "80", "75", "85" }, { "이성계", "90", "85", "80" }, { "강감찬", "70", "75", "70" } };
    
    int    sum          = 0;
    double subjectCount = 3.0d;
    int[]  rank         = new int[3];
    int[]  totalSum     = new int[3];
    
    void gradeCalculation() {
        
        for ( int row = 0; row < data.length; row++ ) {
            System.out.print( data[row][0] + "의 성적\n" );
            double sum = Integer.parseInt( data[row][1] ) + Integer.parseInt( data[row][2] ) + Integer.parseInt( data[row][3] );
            System.out.println( "총점 : " + sum );
            System.out.println( "평균 : " + sum / subjectCount + "\n" );
        }
    }
    
    void gradeRank() {
        
        for ( int i = 0; i < rank.length; i++ ) {
            totalSum[i] = Integer.parseInt( data[i][1] ) + Integer.parseInt( data[i][2] ) + Integer.parseInt( data[i][3] );
        }
        
        for ( int i = 0; i < rank.length; i++ ) {
            
            int count = 1;
            
            for ( int j = 0; j < rank.length; j++ ) {
                
                if ( totalSum[i] < totalSum[j] ) {
                    count++;
                }
            }
            rank[i] = count;
            
            System.out.println( "등수는" + rank[i] );
            System.out.println( "총합은" + totalSum[i] );
        }
    }
}
