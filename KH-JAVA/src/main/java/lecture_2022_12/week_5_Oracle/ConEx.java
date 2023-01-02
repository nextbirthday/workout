package lecture_2022_12.week_5_Oracle;

public class ConEx {
    ZipCodeSearch zcs; 
    
    public ConEx() {}
    
    // method를 통해서 객체주입을 받을 수 있다. -singleton pattern
    public ZipCodeSearch getInstance() {
        
        if ( zcs == null ) {// 조건부로
            zcs = new ZipCodeSearch();
        }
        
        return zcs;
    }
    
    public static void main( String[] args ) {
        ConEx ce = new ConEx();
        ce.zcs = ce.getInstance();
        ce.zcs.getZipCode( "아현동" );
    }
    
}
