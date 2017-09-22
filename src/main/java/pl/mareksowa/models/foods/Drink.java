package pl.mareksowa.models.foods;

import java.util.ArrayList;
import java.util.List;

public class Drink extends Food implements ISmallMenuCreator{

    //declare list containing special 'class' foods
    private List<Food> drinkList;

    //singleton model to prevent creating lots of instances of this class in case of multi-user application
    private static Drink ourInstance = new Drink();

    public static Drink getInstance() {
        return ourInstance;
    }

    private Drink() {
    }

    private Drink(String name, double price) {
        super(name, price);
    }

    @Override
    //this method allow to admin manage our 'menu' (add/remove/set-price)
    public List<Food> createSmallMenu() {
        drinkList = new ArrayList<>();
        drinkList.add(new Drink("Kompot", 5.55));
        drinkList.add(new Drink("Sok Pomarańczowy", 6.39));
        drinkList.add(new Drink("Cola", 8.88));
        drinkList.add(new Drink("Wino", 9.75));
        return drinkList;
    }

    @Override
    //from this method user can see what actual menu looks like
    public List<Food> showSmallMenu() {
        return drinkList;
    }
}
