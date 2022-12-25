package controller;

import dto.Coffee;
import lombok.extern.log4j.Log4j2;
import model.Barista;

@Log4j2
public class Shop {
    
    private Shop() {}
    
    public static Shop getInstance() {
        log.info( "Shop 싱글턴 생성자 호출" );
        return LazyHolder.INSTANCE;
    }
    
    private static class LazyHolder {
        private static final Shop INSTANCE = new Shop();
    }
    
    public Coffee getCoffee( Coffee coffee ) throws InterruptedException {
        
        log.info( "고객이 파라미터로 넘긴 Coffee DTO : " + coffee.toString() );
        
        Barista barista = new Barista();
        Coffee  orderedCoffee;
        
        if ( "아메리카노".equals( coffee.getName() ) ) {
            orderedCoffee = barista.makeAmericano( coffee );
        }
        else {
            orderedCoffee = barista.makeLatte( coffee );
        }
        log.info( "바리스타가 리턴하는 Coffee DTO : " + coffee.toString() );
        
        return orderedCoffee;
    }
}
