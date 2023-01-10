package b3_1215;

public class RandomNumberCount {
    static final int MAX   = 100;
    int[]            count = new int[10]; // [0,0,0,0,0,0,0,0,0,0]
    
    int[] initArray( int[] datas, int size ) {
        
        for ( int i = 0; i < datas.length; i++ ) {
            datas[i] = ( int ) ( Math.random() * 10 );
        }
        
        dataPrint( datas );
        return datas;
    }
    
    void dataPrint( int[] datas ) {
        
        for ( int i = 0; i < datas.length; i++ ) {
            System.out.print( datas[i] );
            
            if ( i % 10 == 9 ) {
                System.out.println();
            }
        }
    }
    
    void numberCount( int[] datas ) {
        int index = 0;
        
        for ( int i = 0; i < 100; i++ ) {
            index = datas[i];
            count[index]++;
        }
    }
    
    public static void main( String[] args ) {
        RandomNumberCount test  = new RandomNumberCount();
        int[]             datas = new int[MAX];
        test.initArray( datas, MAX );
        test.dataPrint( datas );
        test.numberCount( datas );
        
        for ( int i = 0; i < test.count.length; i++ ) {
            System.out.print( test.count[i] + " " );
        }
    }
}
