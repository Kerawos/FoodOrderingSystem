package pl.mareksowa.models.foods.cuisines;

import pl.mareksowa.models.foods.Food;

import java.util.ArrayList;
import java.util.List;

public class Mexican extends Cuisine {

    //declare list containing special 'class' foods
    private List<Food> mexicanLunchList;

    //singleton model to prevent creating lots of instances of this class in case of multi-user application
    private static Mexican ourInstance = new Mexican();

    public static Mexican getInstance() {
        return ourInstance;
    }

    private Mexican() {
    }

    private Mexican(String name, double price, String description, String ingredients) {
        super(name, price, description, ingredients);
    }

    @Override
    //this method allow to admin manage our 'menu' (add/remove/set-price)
    public List<Food> createMainCourseMenu() {
        mexicanLunchList = new ArrayList<>();
        mexicanLunchList.add(new Mexican("Burito", 19.55, "spice meal",
                "potato, chicken, spice-sauce"));
        mexicanLunchList.add(new Mexican("Enchilada", 27.99, "old-fashioned meal",
                "secret"));
        return mexicanLunchList;
    }

    @Override
    //from this method user can see what actual menu looks like
    public List<Food> showMainCourseMenu() {
        return mexicanLunchList;
    }
}
