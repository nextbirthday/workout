package calculator;

public class Calculator2 {
    
    int add( int i, int k ) {
        return i + k;
    }
    
    int sub( int i, int k ) {
        return i - k;
    }
    
    int multi( int i, int k ) {
        return i * k;
    }
    
<<<<<<< HEAD
    <<<<<<<HEAD=======
    // i만 double로 캐스팅되기 때문에 0.666...이 출력되는 것
    // ( double ) ( i / k ) 은 정수끼리 연산 후 캐스팅되기 때문에 소수점은 버려짐
    >>>>>>>234d 0 c5835e2fd1ebbc195d0e3562e561f6ca65d
    
    double div( int i, int k ) {
        return ( double ) i / k;
    }
    
    <<<<<<<HEAD
    
    public static void main( String[] args ) {
        
        Calculator2 cal = new Calculator2();
        
        System.out.println( "합=" + cal.add( 0, 0 ) );
        System.out.println( "차=" + cal.sub( 0, 0 ) );
        System.out.println( "곱=" + cal.multi( 0, 0 ) );
        System.out.println( "나누기=" + cal.div( 0, 0 ) );
        
    }
    
    =======
=======
    // i만 double로 캐스팅되기 때문에 0.666...이 출력되는 것
    // ( double ) ( i / k ) 은 정수끼리 연산 후 캐스팅되기 때문에 소수점은 버려짐
    double div( int i, int k ) {
        return ( double ) i / k;
    }
>>>>>>> 3c91384a234956906acd731dd1ad8c6e3c9cb5f6
    // public static void main( String[] args ) {
    //
    // Calculator2 cal = new Calculator2();
    //
    // System.out.println( "합=" + cal.add( 0, 0 ) );
    // System.out.println( "차=" + cal.sub( 0, 0 ) );
    // System.out.println( "곱=" + cal.multi( 0, 0 ) );
    // System.out.println( "나누기=" + cal.div( 0, 0 ) );
    // }
<<<<<<< HEAD
    >>>>>>>234d 0 c5835e2fd1ebbc195d0e3562e561f6ca65d
=======
>>>>>>> 3c91384a234956906acd731dd1ad8c6e3c9cb5f6
}
