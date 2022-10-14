package cooperation;

public class TakeTransportation {
    
    public static void main( String[] args ) {

        Student chris = new Student("chris", 5000);
        Student tom = new Student("tom", 10000);
        
        Bus bus3214 = new Bus(3214);
        chris.takeBus(bus3214);
        chris.showInfo();
        bus3214.showInfo();
        
        Subway subwayGreen = new Subway(2);
        tom.takeSubway(subwayGreen);
        tom.showInfo();
        subwayGreen.showInfo();
    }
    
}
