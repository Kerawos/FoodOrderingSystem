package pl.mareksowa;

import pl.mareksowa.models.foods.*;
import pl.mareksowa.models.foods.cuisines.Italian;
import pl.mareksowa.models.foods.cuisines.Mexican;
import pl.mareksowa.models.foods.cuisines.Polish;

import java.util.*;

public class Utils {

    //statics visible to other classes
    public static Scanner sc = new Scanner(System.in);
    public static List<Food> orderList;
    public static Map<String, ISmallMenuCreator> smallMenu;
    public static Map<String, IMainCourseMenuCreator> mainCourseMenu;
    public static StringBuilder builder;

    //getting our singleton instances and creating menus by putting 'className' into map and calling method 'createMenu'
    //modify here your class containing foods without interrupt start-class (SOLID: extendable)
    public static void generateSmallMenu(){
        smallMenu = new HashMap<>();
        smallMenu.put("Dessert", Dessert.getInstance());
        smallMenu.get("Dessert").createSmallMenu();
        smallMenu.put("Drink", Drink.getInstance());
        smallMenu.get("Drink").createSmallMenu();
    }

    //getting our singleton instances and creating menus by putting 'className' into map and calling method 'createMenu'
    //modify here your class containing foods without interrupt start-class (SOLID: extendable)
    public static void generateMainCourseMenu(){
        mainCourseMenu = new HashMap<>();
        mainCourseMenu.put("Polish", Polish.getInstance());
        mainCourseMenu.get("Polish").createMainCourseMenu();
        mainCourseMenu.put("Italian", Italian.getInstance());
        mainCourseMenu.get("Italian").createMainCourseMenu();
        mainCourseMenu.put("Mexican", Mexican.getInstance());
        mainCourseMenu.get("Mexican").createMainCourseMenu();
    }

}
