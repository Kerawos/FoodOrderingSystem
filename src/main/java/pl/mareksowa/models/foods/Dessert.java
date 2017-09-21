package pl.mareksowa.models.foods;

import java.util.ArrayList;
import java.util.List;

public class Dessert extends Food {

    public static List<Food> foodList = createDessertMenu();

    public Dessert(String name, double price) {
        super(name, price);
    }

    public static List<Food> createDessertMenu(){

        //here we can manage our 'menu'
        foodList = new ArrayList<>();
        foodList.add(new Dessert("Lody", 8.75));
        foodList.add(new Dessert("Owoce", 4.99));
        foodList.add(new Dessert("Ciaso", 5.55));
        return foodList;
    }

}
