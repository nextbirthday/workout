package lecture_2022_12.week_5_Polymorphism;

import lombok.extern.log4j.Log4j2;

@Log4j2
class Car {
    public Car() {
        System.out.println( "Car()호출" );
        this.n(); // shadow
        log.info( this );
    }
    
    void n() {
        System.out.println( "Car n" + this );
    }
}

class Sonata extends Car {
    public Sonata() {
        System.out.println( "Sonata()호출" );
    }
    
    @Override
    void n() {
        System.out.println( "Sonata n" );
    }
}

@Log4j2
public class CarMain {
    public static void main( String args[] ) {
        
        Sonata myCar = new Sonata();
        // 객체지향 언어
        log.info( myCar );
    }
}
