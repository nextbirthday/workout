package b3_1215;

public class GetRandomNumber {
    void getRandomNumber( int userInputLength ) {
        int[] users       = new int[userInputLength];
        int   positiveSum = 0;
        int   negativeSum = 0;
        int   zeroCount   = 0;
        
        for ( int i = 0; i < userInputLength; i++ ) {
            users[i] = ( int ) ( Math.random() * 21 ) - 10;
            System.out.println( users[i] );
            if ( users[i] > 0 )
                positiveSum += users[i];
            
            if ( users[i] < 0 )
                negativeSum += users[i];
            
            if ( users[i] == 0 )
                zeroCount++;
        }
        System.out.println( "0이 출력된 횟수는 " + zeroCount + "번 입니다." );
        System.out.println( "양수의 합은 " + positiveSum + "입니다." );
        System.out.println( "음수의 합은 " + negativeSum + "입니다." );
    }
    
    public static void main( String[] args ) {
        GetRandomNumber test = new GetRandomNumber();
        test.getRandomNumber( 20 );
    }
}
