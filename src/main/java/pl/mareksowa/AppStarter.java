package pl.mareksowa;

import pl.mareksowa.services.OrderingSystem;

public class AppStarter {

    public static void main(String[] args) {
        //only for start program
        OrderingSystem orderingSystem = new OrderingSystem();
        orderingSystem.start();
    }
}
