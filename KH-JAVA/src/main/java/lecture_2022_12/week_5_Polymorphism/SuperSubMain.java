package lecture_2022_12.week_5_Polymorphism;

class Sup {
    
    public Sup() {
        m();
    }
    
    public void m() {
        System.out.println( "Sup m() call" );
    }
}

class Sub extends Sup {
    
    public Sub() {}
    
    @Override // 재정의
    public void m() {
        System.out.println( "Sub m() call" );
    }
}

public class SuperSubMain {
    
    public static void main( String[] args ) {
        // insert here
        // Sup sup = new Sup();
        // sup.m();
        
        Sub sub = new Sub(); // constructor도 method 처럼 호출된다.
        // sub.m();
        
        // 선언부(Sup) = 생성부(Sub)
        // 부모의 method는 shadow method(은닉 method)
        Sup sup2 = new Sub();
        
        // sub = ( Sub ) sup;
        sub = ( Sub ) sup2;
        sub.m();
    }
    
}
