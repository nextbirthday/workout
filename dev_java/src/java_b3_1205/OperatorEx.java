package java_b3_1205;

public class OperatorEx {
    
    void methodA(int i, int j) {//call by value
        j = ++i;        
        System.out.println(  "i:" + i +", j:" +j );
    }
    
    public static void main( String[] args ) {
        OperatorEx operatorEx = new OperatorEx();
        operatorEx.methodA( 1, 2 );
        
    }
}
