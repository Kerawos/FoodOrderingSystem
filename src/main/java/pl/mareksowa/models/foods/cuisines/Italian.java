package pl.mareksowa.models.foods.cuisines;

import pl.mareksowa.models.foods.Food;

import java.util.ArrayList;
import java.util.List;

public class Italian extends Cuisine {

    //declare list containing special 'class' foods
    private List<Food> italianLunchList;

    //singleton model to prevent creating lots of instances of this class in case of multi-user application
    private static Italian ourInstance = new Italian();

    public static Italian getInstance() {
        return ourInstance;
    }

    private Italian() {
    }

    private Italian(String name, double price, String description, String ingredients) {
        super(name, price, description, ingredients);
    }

    @Override
    //this method allow to admin manage our 'menu' (add/remove/set-price)
    public List<Food> createMainCourseMenu() {
        italianLunchList = new ArrayList<>();
        italianLunchList.add(new Italian("Caponata", 15.19, "soft meal",
                "bread, onion, mushrooms"));
        italianLunchList.add(new Italian("Focaccia", 9.99, "very-soft meal",
                "bread, oli-olivine"));
        return italianLunchList;
    }

    @Override
    //from this method user can see what actual menu looks like
    public List<Food> showMainCourseMenu() {
        return italianLunchList;
    }
}
