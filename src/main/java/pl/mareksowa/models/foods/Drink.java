package pl.mareksowa.models.foods;

import java.util.ArrayList;
import java.util.List;

public class Drink extends Food {

    public static List<Food> foodList = createDrinksMenu();

    public Drink(String name, double price) {
        super(name, price);
    }

    public static List<Food> createDrinksMenu(){

        //here we can manage our 'menu'
        foodList = new ArrayList<>();
        foodList.add(new Drink("Kompot", 5.55));
        foodList.add(new Drink("Sok Pomarańczowy", 6.39));
        foodList.add(new Drink("Cola", 8.88));
        foodList.add(new Drink("Wino", 9.75));
        return foodList;
    }
}
