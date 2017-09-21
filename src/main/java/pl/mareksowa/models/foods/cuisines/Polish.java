package pl.mareksowa.models.foods.cuisines;

import pl.mareksowa.models.foods.Food;

import java.util.ArrayList;
import java.util.List;

public class Polish extends Cuisine{

    public static List<Food> foodList = createPolishCourseMenu();

    private Polish(String name, double price, String description, String ingredients) {
        super(name, price, description, ingredients);
    }

    public static List<Food> createPolishCourseMenu(){

        //here we can manage our 'menu'
        foodList = new ArrayList<>();
        foodList.add(new Polish("Kotlet Schabowy", 25.99, "very good meal",
                "potato, meat"));
        foodList.add(new Polish("Gulasz", 29.99, "old-fashioned meal",
                "secret"));
        foodList.add(new Polish("Pierogi Ruskie", 19.25, "simple meal",
                "cheese, flour, oil"));
        return foodList;
    }

}
