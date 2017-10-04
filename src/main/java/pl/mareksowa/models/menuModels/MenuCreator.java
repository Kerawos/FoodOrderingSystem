package pl.mareksowa.models.menuModels;

import pl.mareksowa.models.foodModels.Dessert;
import pl.mareksowa.models.foodModels.Drink;
import pl.mareksowa.models.foodModels.Food;
import pl.mareksowa.models.foodModels.cuisines.Italian;
import pl.mareksowa.models.foodModels.cuisines.Mexican;
import pl.mareksowa.models.foodModels.cuisines.Polish;

import java.util.*;

public class MenuCreator {

    //this methods allow to admin manage our 'menu' (add/remove/set-price)
    public List<Food> createDessertList() {
        List<Food> dessertList = new ArrayList<>();
        dessertList.add(new Dessert("Lody", 8.75));
        dessertList.add(new Dessert("Owoce", 4.99));
        dessertList.add(new Dessert("Ciaso", 5.55));
        return dessertList;
    }

    public List<Food> createDrinkList() {
        List<Food> drinkList = new ArrayList<>();
        drinkList.add(new Drink("Kompot", 5.55));
        drinkList.add(new Drink("Sok Pomarańczowy", 6.39));
        drinkList.add(new Drink("Cola", 8.88));
        drinkList.add(new Drink("Wino", 9.75));
        return drinkList;
    }

    public List<Food> createItalianLunchList() {
        List<Food> italianLunchList = new ArrayList<>();
        italianLunchList.add(new Italian("Caponata", 15.19, "soft meal",
                "bread, onion, mushrooms"));
        italianLunchList.add(new Italian("Focaccia", 9.99, "very-soft meal",
                "bread, oli-olivine"));
        return italianLunchList;
    }

    public List<Food> createMexicanLunchList() {
        List<Food> mexicanLunchList = new ArrayList<>();
        mexicanLunchList.add(new Mexican("Burito", 19.55, "spice meal",
                "potato, chicken, spice-sauce"));
        mexicanLunchList.add(new Mexican("Enchilada", 27.99, "old-fashioned meal",
                "secret"));
        return mexicanLunchList;
    }

    public List<Food> createPolishLunchList() {
        List<Food> polishLunchList = new ArrayList<>();
        polishLunchList.add(new Polish("Kotlet Schabowy", 25.99, "very good meal",
                "potato, meat"));
        polishLunchList.add(new Polish("Gulasz", 29.99, "old-fashioned meal",
                "secret"));
        polishLunchList.add(new Polish("Pierogi Ruskie", 19.25, "simple meal",
                "cheese, flour, oil"));
        return polishLunchList;
    }

}
