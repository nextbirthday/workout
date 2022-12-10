package java_b3_1205;

public class SumEx {
    
    public SumEx() {
        // TODO Auto-generated constructor stub
    }
    
    void sumFor() {
        int sum = 0;
        
        for ( int i = 1; i < 11; i++ ) {
            sum += i; // sum = sum +j;
        }
        System.out.println( "1부터 10까지의 합은:" + sum + "입니다." );
    }
    
    void sumWhile() {
        int i   = 1;
        int sum = 0;
        
        while ( i <= 10 ) {
            sum += i;
            i++;
        }
        System.out.println( "1부터 10까지의 합은:" + sum + "입니다." );
    }
    
    void sumEven() {
        int sum = 0;
        
        for ( int i = 1; i < 11; i++ ) {
            
            if ( i % 2 == 0 ) {
                sum += i; // sum = sum + i;
            }
        }
        System.out.println( "1부터 10까지의 짝수의 합은:" + sum + "입니다." );
    }
    
    void sumEven2() {
        int sum = 0;
        
        for ( int i = 2; i <= 10; i = i + 2 ) {
            sum = sum + i;
        }
        System.out.println( "1부터 10까지 정수 중에 짝수의 합은 :" + sum + "입니다." );
    }
    
    void fizzBuzz() {
        
        for ( int i = 1; i < 101; i++ ) {
            
            if ( i % 35 == 0 ) {
                System.out.println( "fizzbuzz" );
            }
            else if ( i % 5 == 0 ) {
                System.out.println( "fizz" );
            }
            else if ( i % 7 == 0 ) {
                System.out.println( "buzz" );
            }
            else {
                System.out.println( i );
            }
        }
    }
    
    void fizzBuzzSwitch() {
        System.out.println( "=====methodFizzBuzzSwitch call=====" );
        
        for ( int i = 1; i < 101; i++ ) {
            
            switch ( i % 35 ) {
                case 0:
                    System.out.println( "fizzbuzz" );
                    break;
                case 5:
                case 10:
                case 15:
                case 20:
                case 25:
                case 30:
                    System.out.println( "fizz" );
                    break;
                case 7:
                case 14:
                case 21:
                case 28:
                    System.out.println( "buzz" );
                    break;
                default:
                    System.out.println( i );
            } // end of switch
        }// end of for
    }// end of methodFizzbuzzSwitch
}
