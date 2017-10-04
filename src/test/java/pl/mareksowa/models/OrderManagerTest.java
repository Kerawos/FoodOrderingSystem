package pl.mareksowa.models;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pl.mareksowa.models.foodModels.Drink;
import static org.junit.Assert.*;

public class OrderManagerTest {


    @BeforeClass
    public static void start(){

    }

    @AfterClass
    public static void stop(){
    }

    @Test
    public void addingTest(){
        assertTrue(OrderManager.getInstance().addFoodToOrder(new Drink("Test", 5.56)));
    }

    @Test
    public void getOrderTotalCostTest(){
        OrderManager.getInstance().addFoodToOrder(new Drink("Test", 5.56));
        OrderManager.getInstance().addFoodToOrder(new Drink("Test", 9.99));
        assertEquals("15,55", OrderManager.getInstance().getOrderTotalCost());
    }

    @Test
    public void removingTest(){
        OrderManager.getInstance().addFoodToOrder(new Drink("Test", 5.56));
        OrderManager.getInstance().removeFoodFromOrder(OrderManager.getInstance().getOrder().size()-1);
    }





}
