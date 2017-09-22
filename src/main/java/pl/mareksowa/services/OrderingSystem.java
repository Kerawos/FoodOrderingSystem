package pl.mareksowa.services;

import pl.mareksowa.Utils;
import pl.mareksowa.models.foods.Food;

import java.util.*;

public class OrderingSystem {
    private String command;

    //main program
    public void start() {

        //to get all menus variables you should first manage Utils.menus (SOLID: extendable)
        Utils.generateSmallMenu();
        Utils.generateMainCourseMenu();
        Utils.orderList = new ArrayList<>();

        System.out.println("@ Welcome in our restaurant");
        System.out.println("@ Make sure you enter proper query including Capital Letter (meal names), digits (choices "
                + "from lists). \n@ All choices please confirm by hitting 'enter'");
        do {
            if (Utils.orderList.size() > 0) {
                showCurrentOrder();
                System.out.println("@ to manage your order write: 'add' or 'remove', to complete order write 'complete',"
                        + " to abort and exit you can always write 'exit'\n@ all options confirm by pressing 'enter'"
                        + "\n~~command:");
            } else {
                System.out.println("@ to manage your order write: 'add' to add or 'complete' to complete order"
                        + " to abort and exit you can always write 'exit'\n@ all options confirm by pressing 'enter'"
                        + "\n~~command:");
            }
            command = Utils.sc.nextLine();
            switch (command) {
                case "add": {
                    System.out.println("@ Which type of order you wanna place? " + printSmallMenuOrderOptions()
                            + " 'Lunch' maybe? \n~~command: ");
                    command = Utils.sc.nextLine();
                    if (command.equals("Lunch")){
                        System.out.println("@ Please indicate which cuisine you prefer? "
                                + printMainCourseMenuOrderOptions() + " ?\n~~command: ");
                        addMainCourse(Utils.sc.nextLine());
                    } else {
                        addSmallOrder(command);
                    }
                    break;
                }
                case "remove": {
                    removeOrder();
                    break;
                }
                case "complete": {
                    System.out.println("@ Are you sure you do not want add some more? 'yes' to confirm\n~~command:");
                    if (Utils.sc.nextLine().equals("yes")) {
                        if (Utils.orderList.size()>0){
                            System.out.println("@ Total value of your order is: $" + orderTotalCost());
                            System.out.println("@ Enjoy your meal, waiter with order will be soon.");
                            System.exit(1);
                        } else {
                            System.out.println("@ We hope you order something in the future. Good bye!");
                            System.exit(1);
                        }
                    } else {
                        unknownCommand();
                    }
                    break;
                }
                case "exit": {
                    exitQuery();
                    break;
                }
                default: {
                    unknownCommand();
                    break;
                }
            }
        } while (true) ;
    }

    //other methods
    private void addSmallOrder(String className){
        //check if user entered proper class name
        if (Utils.smallMenu.containsKey(className)){
            System.out.println("@ Please indicate which '" + className + "' you wanna add to your order list:");
            //display to user all options
            for (int i = 0; i < Utils.smallMenu.get(className).showSmallMenu().size(); i++) {
                System.out.println((i + 1) + ". " + Utils.smallMenu.get(className).showSmallMenu().get(i));
            }
            System.out.println("~~command: ");
            command = Utils.sc.nextLine();
            if (!isNumeric(command)) {
                letterInsteadOfDigit();
            } else {
                if ((Integer.parseInt(command)) > Utils.smallMenu.get(className).showSmallMenu().size()
                        || (Integer.parseInt(command) - 1) < 0) {
                    mistypeIndex();
                } else {
                    Utils.orderList.add(Utils.smallMenu.get(className).showSmallMenu().get((Integer.parseInt(command) - 1)));
                    informAboutAddedOrder();
                }
            }
        } else {
            unknownCommand();
        }
    }

    private void addMainCourse(String className) {
        //check if user entered proper class name
        if (Utils.mainCourseMenu.containsKey(className)){
            System.out.println("@ Please indicate which main-course from cuisines '" + className
                    + "' you wanna add to your order list:");
            //display to user all options
            for (int i = 0; i < Utils.mainCourseMenu.get(className).showMainCourseMenu().size(); i++) {
                System.out.println((i + 1) + ". " + Utils.mainCourseMenu.get(className).showMainCourseMenu().get(i));
            }
            System.out.println("@ Which of these specials above above you wanna add?\n~~command: ");
            command = Utils.sc.nextLine();
            if (!isNumeric(command)) {
                letterInsteadOfDigit();
            } else {
                if ((Integer.parseInt(command)) > Utils.mainCourseMenu.get(className).showMainCourseMenu().size()
                        || (Integer.parseInt(command) - 1) < 0) {
                    mistypeIndex();
                } else {
                    Utils.orderList.add(Utils.mainCourseMenu.get(className).showMainCourseMenu().get((
                            Integer.parseInt(command) - 1)));
                    informAboutAddedOrder();
                }
            }
        } else {
            unknownCommand();
        }
    }

    private void removeOrder(){
        if (Utils.orderList.size() < 1) {
            System.out.println("@ There is nothing to remove..");
        } else {
            showCurrentOrder();
            System.out.println("@ Please indicate which number of your order you wanna remove?\n~~command:");
            command = Utils.sc.nextLine();
            if (!isNumeric(command)) {
                letterInsteadOfDigit();
            } else {
                if ((Integer.parseInt(command)) > Utils.orderList.size() || (Integer.parseInt(command) - 1) < 0) {
                    mistypeIndex();
                } else {
                    System.out.println("@ are you sure to remove '" + Utils.orderList.get((Integer.parseInt(command) - 1))
                            + "'? \n'yes' to confirm\n~~command:");
                    if (Utils.sc.nextLine().equals("yes")) {
                        System.out.println("@ Order nr: " + command + ", '"
                                + Utils.orderList.get(Integer.parseInt(command) - 1).toString() + "', has been removed");
                        Utils.orderList.remove(Integer.parseInt(command) - 1);
                    } else {
                        System.out.println("@ you abort removing");
                    }
                }
            }
        }
    }

    private String printSmallMenuOrderOptions(){
        Utils.builder = new StringBuilder();
        int counter = 0;
        for (String s : Utils.smallMenu.keySet()) {
            counter++;
            Utils.builder.append(" '" + s + "',");
            if (counter%10 == 0){
                Utils.builder.append("\n");
            }
        }
        return Utils.builder.toString();
    }

    private String printMainCourseMenuOrderOptions(){
        Utils.builder = new StringBuilder();
        int counter = 0;
        for (String s : Utils.mainCourseMenu.keySet()) {
            counter++;
            Utils.builder.append(" '" + s + "',");
            if (counter%10 == 0){
                Utils.builder.append("\n");
            }
        }
        return Utils.builder.toString();
    }
    private void showCurrentOrder () {
        System.out.println("\n*****Your current order: ");
        for (int i = 0; i < Utils.orderList.size(); i++) {
            System.out.println((i + 1) + ". " + Utils.orderList.get(i).toString());
        }
        System.out.println("*****\n");
    }

    private void exitQuery () {
        System.out.println("@ are you sure to abort your order and exit?\n@ 'yes' to confirm\n~~command:");
        if (Utils.sc.nextLine().equals("yes")) {
            System.out.println("@ Thank you for visiting our restaurant!");
            System.exit(1);
        }
    }

    private void unknownCommand () {
        System.out.println("@ We do not recognize your action, please try again..");
    }

    private boolean isNumeric (String str){
        try {
            int i = Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private void letterInsteadOfDigit(){
        System.out.println("@ Unfortunately you enter a letter instead of digit.. try again later");
    }

    private void mistypeIndex(){
        System.out.println("@ Unfortunately, you mistype number of your order.. try again later");
    }

    private void informAboutAddedOrder(){
        System.out.println("@ Added: " + Utils.orderList.get(Utils.orderList.size()-1));
    }

    private double orderTotalCost(){
        double sum = 0.00;
        for (Food food : Utils.orderList) {
            sum+=food.getPrice();
        }
        return sum;
    }

}

