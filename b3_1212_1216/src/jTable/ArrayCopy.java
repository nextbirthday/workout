package jTable;

import java.util.Arrays;

public class ArrayCopy {
    // ArrayCopy (배열 복사)
    // 얕은 복사 - Shallow copy 복사된 배열이나 원본 배열이 변경이 될 때 서로간의 값이 같이 변경
    // 얕은 복사(Shallow Copy)는 '주소 값'을 복사한다는 의미입니다.
    // 얕은 복사의 경우 주소 값을 복사하기 때문에, 참조하고 있는 실제값은 같습니다.
    // 얕은 복사의 경우 객체의 주소 값만을 복사하는 것
    
    // 깊은 복사 - Deep Copy
    // 깊은 복사의 경우 객체의 실제값을 새로운 객체로 복사하는 것
    
    void deepCopy() {
        int[] org      = { 1, 2, 3 };
        int[] org_copy = org.clone();
        org_copy[2] = 5;
        
        for ( int e : org ) {
            System.out.println( e );
        }
        
        for ( int e : org_copy ) {
            System.out.println( e );
        }
    }
    
    void deepCopy2() { // 부분복사
        int[] org      = { 1, 2, 3, 4, 5 };
        int[] org_copy = Arrays.copyOf( org, 5 );
        org_copy[2] = 5;
        
        for ( int e : org ) {
            System.out.println( e );
        }
        
        for ( int e : org_copy ) {
            System.out.println( e );
        }
    }
    
    public static void main( String[] args ) {
        // int[] org = { 1, 2, 3 };
        // int[] org_copy = org;
        // org_copy[2] = 5;
        //
        // for ( int e : org ) {
        // System.out.println( e );
        // }
        //
        // for ( int e : org_copy ) {
        // System.out.println( e );
        // }
        
        ArrayCopy test = new ArrayCopy();
        test.deepCopy2();
    }
    
}
