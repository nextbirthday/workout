package model;

import dto.Coffee;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Barista {
    
    public Barista() {
        log.info( "Barista 생성자 호출" );
    }
    
    public Coffee makeAmericano( Coffee coffee ) throws InterruptedException {
        log.info( "바리스타가 " + coffee.getName() + "가 들어있는 Coffee DTO 받아서 count를 1로 설정하고 리턴" );
        Thread.sleep( 1000 );
        coffee.setCount( 1 );
        return coffee;
    }
    
    public Coffee makeLatte( Coffee coffee ) throws InterruptedException {
        log.info( "바리스타가 " + coffee.getName() + "가 들어있는 Coffee DTO 받아서 count를 1로 설정하고 리턴" );
        Thread.sleep( 1000 );
        coffee.setCount( 1 );
        return coffee;
    }
}
