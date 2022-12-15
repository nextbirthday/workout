package model;

import dto.Coffee;

public class Barista {
    public Coffee makeAmericano( Coffee coffee ) throws InterruptedException {
        Thread.sleep( 3000 );
        coffee.setCount( 1 );
        return coffee;
    }
    
    public Coffee makeLatte( Coffee coffee ) throws InterruptedException {
        Thread.sleep( 3000 );
        coffee.setCount( 1 );
        return coffee;
    }
}
