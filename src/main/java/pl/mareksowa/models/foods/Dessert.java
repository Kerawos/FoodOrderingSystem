package pl.mareksowa.models.foods;

import java.util.ArrayList;
import java.util.List;

public class Dessert extends Food implements ISmallMenuCreator {

    //declare list containing special 'class' foods
    private List<Food> dessertList;

    //singleton model to prevent creating lots of instances of this class in case of multi-user application
    private static Dessert ourInstance = new Dessert();

    public static Dessert getInstance() {
        return ourInstance;
    }

    private Dessert() {
    }

    private Dessert(String name, double price) {
        super(name, price);
    }


    @Override
    //this method allow to admin manage our 'menu' (add/remove/set-price)
    public List<Food> createSmallMenu() {
        dessertList = new ArrayList<>();
        dessertList.add(new Dessert("Lody", 8.75));
        dessertList.add(new Dessert("Owoce", 4.99));
        dessertList.add(new Dessert("Ciaso", 5.55));
        return dessertList;
    }

    @Override
    //from this method user can see what actual menu looks like
    public List<Food> showSmallMenu() {
        return dessertList;
    }
}
