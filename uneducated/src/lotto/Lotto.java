package lotto;

public class Lotto {
    
    private static final int MAX = 6;
    
    public static void main( String[] args ) {
        final long startTime = System.currentTimeMillis();
        
        NumberCalculation calc          = new NumberCalculation();
        int[]             winningNumber = new int[MAX];
        int[]             userNumber    = new int[MAX];
        int[]             result        = new int[MAX];
        
        boolean flag        = false;
        long    retakeCount = 0L;
        
        while ( !flag ) {
            winningNumber = calc.pick( winningNumber );
            userNumber = calc.pick( userNumber );
            result = calc.compare( winningNumber, userNumber, result );
            
            if ( result[5] != 0 )
                flag = true;
            else
                retakeCount++;
        }
        
        calc.printArray( winningNumber );
        calc.printArray( userNumber );
        calc.printArray( result );
        System.out.println( "1등까지의 재도전 횟수 : " + retakeCount );
        
        final long endTime  = System.currentTimeMillis();
        final long duration = endTime - startTime;
        System.out.println( duration + " ms" );
    }
}