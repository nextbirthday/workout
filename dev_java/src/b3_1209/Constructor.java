package b3_1209;

public class Constructor {
    
    public Constructor() {
        System.out.println( "dafault constructor call" );
    }
    
    public Constructor( String name, int age ) {
        System.out.println( "patrmeter 개수가 2개인 constructor call" );
        System.out.println( name + "," + age );
    }
    
    public static void main( String[] args ) {
        new Constructor();
        new Constructor( "paul", 25 );
    }
}
