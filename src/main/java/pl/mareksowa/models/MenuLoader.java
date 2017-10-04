package pl.mareksowa.models;

import pl.mareksowa.models.foodModels.Food;
import pl.mareksowa.models.menuModels.MenuCreator;

import java.util.HashMap;
import java.util.List;

public class MenuLoader {

    //load menus from menuCreator
    private MenuCreator menuCreator = new MenuCreator();
    private List<Food> dessertList = menuCreator.createDessertList();
    private List<Food> drinkList = menuCreator.createDrinkList();
    private List<Food> italianLunchList = menuCreator.createItalianLunchList();
    private List<Food> mexicanLunchList = menuCreator.createMexicanLunchList();
    private List<Food> polishLunchList = menuCreator.createPolishLunchList();
    private HashMap<String, List<Food>> smallMenu = createSmallMenu();
    private HashMap<String, List<Food>>mainCourseMenu = createMainCourseMenu();

    public HashMap<String, List<Food>> getSmallMenu() {
        return smallMenu;
    }

    public HashMap<String, List<Food>> getMainCourseMenu() {
        return mainCourseMenu;
    }

    //creating Option for user and options menu
    private HashMap<String, List<Food>> createSmallMenu(){
        smallMenu = new HashMap<>();
        smallMenu.put("dessert", dessertList);
        smallMenu.put("drink", drinkList);
        return smallMenu;
    }

    //creating Option for user and options menu
    private HashMap<String, List<Food>> createMainCourseMenu(){
        mainCourseMenu = new HashMap<>();
        mainCourseMenu.put("polish", polishLunchList);
        mainCourseMenu.put("italian", italianLunchList);
        mainCourseMenu.put("mexican", mexicanLunchList);
        return mainCourseMenu;
    }
}
