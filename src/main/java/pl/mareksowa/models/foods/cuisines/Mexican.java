package pl.mareksowa.models.foods.cuisines;

import pl.mareksowa.models.foods.Food;

import java.util.ArrayList;
import java.util.List;

public class Mexican extends Cuisine {

    public static List<Food> foodList = createMexicanCourseMenu();

    public Mexican(String name, double price, String description, String ingredients) {
        super(name, price, description, ingredients);
    }

    public static List<Food> createMexicanCourseMenu(){

        //here we can manage our 'menu'
        foodList = new ArrayList<>();
        foodList.add(new Mexican("Burito", 19.55, "spice meal",
                "potato, chicken, spice-sauce"));
        foodList.add(new Mexican("Enchilada", 27.99, "old-fashioned meal",
                "secret"));
        return foodList;
    }
}
