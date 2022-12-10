package b3_1207;

public class FinalVariable {
    
    static void methodA() {
        final double PI = 3.14;
        // final 예약어가 붙으면 값이 재 할당이 안됨.
        final int I = 5; // constant 변경이 불가하다.
       
        System.out.println( PI );
        System.out.println( I );
    }
    
    public static void main( String[] args ) {
       FinalVariable.methodA();
    }
    
}
