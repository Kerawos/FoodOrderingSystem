package pl.mareksowa.controllers;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pl.mareksowa.models.OrderManager;
import pl.mareksowa.models.foodModels.Drink;

import static org.junit.Assert.*;

public class UserControllerTest {

    private static UserController userController;

    @BeforeClass
    public static void start(){
        userController = new UserController();
    }

    @AfterClass
    public static void stop(){
       userController = null;
    }

    @Test
    public void isNumericTest(){
        assertTrue(userController.isNumeric("-5"));
        assertTrue(userController.isNumeric("1"));
        assertFalse(userController.isNumeric("test"));
    }

    @Test
    public void showOrderTest(){
        String expected = "1. test, $9.99\n";
        OrderManager.getInstance().addFoodToOrder(new Drink("test", 9.99));
        assertEquals(expected,userController.showCurrentOrder());
    }
}