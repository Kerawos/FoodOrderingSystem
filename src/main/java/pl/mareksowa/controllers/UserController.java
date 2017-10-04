package pl.mareksowa.controllers;

import pl.mareksowa.models.MenuLoader;
import pl.mareksowa.models.OrderManager;

import java.util.*;

public class UserController {

    private Scanner scanner = new Scanner(System.in);
    private StringBuilder stringBuilder;
    private MenuLoader menuLoader;

    //get command to console from user
    public String userCommand(){
        return scanner.nextLine();
    }

    //check if string is numeric
    public boolean isNumeric(String str){
        try {
            int i = Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    //back all foods in order
    public String showCurrentOrder(){
        stringBuilder = new StringBuilder();
        for (int i = 0; i < OrderManager.getInstance().getOrder().size(); i++) {
            stringBuilder.append((i + 1) + ". " + OrderManager.getInstance().getOrder().get(i).toString() + "\n");
        }
        return stringBuilder.toString();
    }

    //back to user all small menu options
    public String showSmallMenuOptions(){
        stringBuilder = new StringBuilder();
        menuLoader = new MenuLoader();
        int counter = 0;
        for (String key: menuLoader.getSmallMenu().keySet()) {
            counter++;
            stringBuilder.append(" '" + key + "',");
            if (counter%10 == 0){
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

    //display to user all small menu options
    public String showSmallMenu(String foodOptionName){
        stringBuilder = new StringBuilder();
        for (int i = 0; i < menuLoader.getSmallMenu().get(foodOptionName).size(); i++) {
            stringBuilder.append((i + 1) + ". " + menuLoader.getSmallMenu().get(foodOptionName).get(i) + "\n");
        }
        return stringBuilder.toString();
    }

    //back to user all main course menu options
    public String showMainCourseMenuOptions(){
        stringBuilder = new StringBuilder();
        int counter = 0;
        for (String key : menuLoader.getMainCourseMenu().keySet()) {
            counter++;
            stringBuilder.append(" '" + key + "',");
            if (counter%10 == 0){
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

    //display to user all options from main course
    public String showMainCourseMenu(String foodOptionName){
        stringBuilder = new StringBuilder();
        for (int i = 0; i < menuLoader.getMainCourseMenu().get(foodOptionName).size(); i++) {
            stringBuilder.append((i + 1) + ". " + menuLoader.getMainCourseMenu().get(foodOptionName).get(i) + "\n");
        }
        return stringBuilder.toString();
    }


    public boolean checkIfUserEnteredProperSmallMenuFoodOptionName(String foodOptionName){
        if (menuLoader.getSmallMenu().containsKey(foodOptionName)){
            return true;
        } else {
            return false;
        }
    }

    public boolean checkIfUserEnteredProperMainCourseFoodOptionName(String foodOptionName){
        if (menuLoader.getMainCourseMenu().containsKey(foodOptionName)){
            return true;
        } else {
            return false;
        }
    }
}
