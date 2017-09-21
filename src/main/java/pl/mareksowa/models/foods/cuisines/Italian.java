package pl.mareksowa.models.foods.cuisines;

import pl.mareksowa.models.foods.Food;

import java.util.ArrayList;
import java.util.List;

public class Italian extends Cuisine {

    public static List<Food> foodList = createItalianCourseMenu();

    public Italian(String name, double price, String description, String ingredients) {
        super(name, price, description, ingredients);
    }

    public static List<Food> createItalianCourseMenu(){

        //here we can manage our 'menu'
        foodList = new ArrayList<>();
        foodList.add(new Italian("Caponata", 15.19, "soft meal",
                "bread, onion, mushrooms"));
        foodList.add(new Italian("Focaccia", 9.99, "very-soft meal",
                "bread, oli-olivine"));
        return foodList;
    }


}
