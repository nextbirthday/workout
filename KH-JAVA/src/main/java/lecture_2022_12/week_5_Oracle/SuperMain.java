package lecture_2022_12.week_5_Oracle;

class Sup {
    
    void go() {
        System.out.println( "Sup go call" );
    }
    
    void stop() {
        System.out.println( "Sup stop call" );
    }
}

class Sub extends Sup {
    Sub() {
        super.stop();
        this.stop();
    }
    
    @Override
    void go() {
        super.go();
    }
    
    @Override
    void stop() {
        System.out.println( "Sub stop call" );
    }
}

public class SuperMain {
    Sup sup2 = new Sup();
    
    private void getStop() {
        sup2.stop();
    }
    
    public static void main( String[] args ) {
        Sup sup = new Sup();
        
        Sub sub = new Sub();
        // sub.go();
        sup = sub; // sup = new Sub();
        // 부모가 가진 stop 메서드는 은닉메서드라고 한다. shadow method라고 한다.
        sup.stop();
        // this나 super예약어는 static이 있는 메서드 영역에서 사용불가하다.
    }
}
