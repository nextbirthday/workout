package b3_1215;

class A {
    AMain aMain = null;
    
    public A( AMain aMain ) {
        System.out.println( "A(AMain aMain)call" );
        this.aMain = aMain;
    }
    
    void methodB() {
        aMain.methodA();
    }
}

public class AMain {
    
    A a = new A( this );
    
    void methodA() {
        System.out.println( "AMain methodA() call" );
    }
    
    public static void main( String[] args ) {
        AMain aMain = new AMain();
        aMain.a.methodB();
    }
}
