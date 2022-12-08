package test_1208;

public class Test03 {
    
    void testArray() {
       
        int[] arr = new int[4];
        
        for ( int i = 0; i < arr.length; i++ ) {
            arr[i] += ( 10 + i ); // arr[i] = arr[i] + (10+i);
            System.out.println( arr[i] );
        }
    }
}
