package controller;

import dto.Coffee;
import model.Barista;

public class Shop {
    
    private Shop() {}
    
    public static Shop getInstance() { return LazyHolder.INSTANCE; }
    
    private static class LazyHolder {
        private static final Shop INSTANCE = new Shop();
    }
    
    public Coffee getCoffee( Coffee coffee ) throws InterruptedException {
        
        Barista barista = new Barista();
        Coffee  orderedCoffee;
        
        if ( "아메리카노".equals( coffee.getName() ) ) {
            orderedCoffee = barista.makeAmericano( coffee );
        }
        else {
            orderedCoffee = barista.makeLatte( coffee );
        }
        return orderedCoffee;
    }
}
