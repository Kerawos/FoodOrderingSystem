package pl.mareksowa.models.foods.cuisines;

import pl.mareksowa.models.foods.Food;

import java.util.ArrayList;
import java.util.List;

public class Polish extends Cuisine{

    //declare list containing special 'class' foods
    private List<Food> polishLunchList;

    //singleton model to prevent creating lots of instances of this class in case of multi-user application
    private static Polish ourInstance = new Polish();

    public static Polish getInstance() {
        return ourInstance;
    }

    private Polish() {
    }

    private Polish(String name, double price, String description, String ingredients) {
        super(name, price, description, ingredients);
    }

    @Override
    //this method allow to admin manage our 'menu' (add/remove/set-price)
    public List<Food> createMainCourseMenu() {
        polishLunchList = new ArrayList<>();
        polishLunchList.add(new Polish("Kotlet Schabowy", 25.99, "very good meal",
                "potato, meat"));
        polishLunchList.add(new Polish("Gulasz", 29.99, "old-fashioned meal",
                "secret"));
        polishLunchList.add(new Polish("Pierogi Ruskie", 19.25, "simple meal",
                "cheese, flour, oil"));
        return polishLunchList;
    }

    @Override
    //from this method user can see what actual menu looks like
    public List<Food> showMainCourseMenu() {
        return polishLunchList;
    }

}
