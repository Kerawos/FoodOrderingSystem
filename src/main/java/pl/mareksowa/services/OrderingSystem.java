package pl.mareksowa.services;

import pl.mareksowa.models.foods.Dessert;
import pl.mareksowa.models.foods.Drink;
import pl.mareksowa.models.foods.Food;
import pl.mareksowa.models.foods.cuisines.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderingSystem {

    static Scanner sc = new Scanner(System.in);
    static List<Food> orderList = new ArrayList<>();
    static String command;

    public static void start() {
        //main program
        System.out.println("Welcome in our restaurant");
        do {
            if (orderList.size() > 0) {
                showCurrentOrder();
                System.out.println("@ to manage your order write: 'add' or 'remove', to complete order write 'complete'," +
                        " to abort and exit you can always write 'exit'\n~~command:");
            } else {
                System.out.println("@ to manage your order write: 'add' to add or 'complete' to complete order" +
                        " to abort and exit you can always write 'exit'\n~~command:");
            }
            command = sc.nextLine();
            switch (command) {
                case "add": {
                    System.out.println("@ Which type of order you wanna place? 'lunch', 'drink' or 'dessert'? \n~~command: ");
                    command = sc.nextLine();
                    switch (command) {
                        case "drink": {
                            System.out.println("@ Please indicate which drink you wanna add to your order list:\n~~command: ");
                            for (int i = 0; i < Drink.foodList.size(); i++) {
                                System.out.println((i + 1) + ". " + Drink.foodList.get(i));
                            }
                            command = sc.nextLine();
                            if (!isNumeric(command)) {
                                letterInsteadOfDigit();
                            } else {
                                if ((Integer.parseInt(command)) > Drink.foodList.size() || (Integer.parseInt(command) - 1) < 0) {
                                    mistypeIndex();
                                } else {
                                    orderList.add(Drink.foodList.get((Integer.parseInt(command) - 1)));
                                    informAboutAddedOrder();
                                    break;
                                }
                            }
                            break;
                        }
                        case "lunch": {
                            System.out.println("@ Please indicate which cuisine you prefer? 'Polish', 'Italian' or 'Mexican'?\n~~command: ");
                            command = sc.nextLine();
                            if (command.equals("Polish")){
                                for (int i = 0; i < Polish.foodList.size(); i++) {
                                    System.out.println((i+1) + ". " + Polish.foodList.get(i));
                                }
                                System.out.println("which of these above you wanna add?");
                                command = sc.nextLine();
                                if (!isNumeric(command)) {
                                    letterInsteadOfDigit();
                                } else {
                                    if ((Integer.parseInt(command)) > Polish.foodList.size() || (Integer.parseInt(command) - 1) < 0) {
                                        mistypeIndex();
                                    } else {
                                        orderList.add(Polish.foodList.get((Integer.parseInt(command) - 1)));
                                        informAboutAddedOrder();
                                        break;
                                    }
                                }
                            } else if (command.equals("Italian")){
                                for (int i = 0; i < Italian.foodList.size(); i++) {
                                    System.out.println((i+1) + ". " + Italian.foodList.get(i));
                                }
                                System.out.println("which of these above you wanna add?");
                                command = sc.nextLine();
                                if (!isNumeric(command)) {
                                    letterInsteadOfDigit();
                                } else {
                                    if ((Integer.parseInt(command)) > Italian.foodList.size() || (Integer.parseInt(command) - 1) < 0) {
                                        mistypeIndex();
                                    } else {
                                        orderList.add(Italian.foodList.get((Integer.parseInt(command) - 1)));
                                        informAboutAddedOrder();
                                        break;
                                    }
                                }
                            } else if (command.equals("Mexican")) {
                                for (int i = 0; i < Mexican.foodList.size(); i++) {
                                    System.out.println((i + 1) + ". " + Mexican.foodList.get(i));
                                }
                                System.out.println("which of these above you wanna add?");
                                command = sc.nextLine();
                                if (!isNumeric(command)) {
                                    letterInsteadOfDigit();
                                } else {
                                    if ((Integer.parseInt(command)) > Mexican.foodList.size() || (Integer.parseInt(command) - 1) < 0) {
                                        mistypeIndex();
                                    } else {
                                        orderList.add(Mexican.foodList.get((Integer.parseInt(command) - 1)));
                                        informAboutAddedOrder();
                                        break;
                                    }
                                }
                            } else {
                                unknownCommand();
                            }
                            break;
                        }
                        case "dessert": {
                            System.out.println("@ Please indicate which dessert you wanna add to your order list:\n~~command: ");
                            for (int i = 0; i < Dessert.foodList.size(); i++) {
                                System.out.println((i + 1) + ". " + Dessert.foodList.get(i));
                            }
                            command = sc.nextLine();
                            if (!isNumeric(command)) {
                                letterInsteadOfDigit();
                            } else {
                                if ((Integer.parseInt(command)) > Dessert.foodList.size() || (Integer.parseInt(command) - 1) < 0) {
                                    mistypeIndex();
                                } else {
                                    orderList.add(Dessert.foodList.get((Integer.parseInt(command) - 1)));
                                    informAboutAddedOrder();
                                    break;
                                }
                            }
                            break;
                        }
                        default: {
                            unknownCommand();
                            break;
                        }
                    }
                    break;
                }
                case "remove": {
                    if (orderList.size() < 1) {
                        System.out.println("@ There is nothing to remove..");
                    } else {
                        System.out.println("@ Please indicate which number of your order you wanna remove?\n~~command:");
                        command = sc.nextLine();
                        if (!isNumeric(command)) {
                            letterInsteadOfDigit();
                        } else {
                            if ((Integer.parseInt(command)) > orderList.size() || (Integer.parseInt(command) - 1) < 0) {
                                mistypeIndex();
                            } else {
                                System.out.println("@ are you sure? 'yes' to confirm\n~~command:");
                                if (sc.nextLine().equals("yes")) {
                                    System.out.println("@ Order nr: " + command + ", '"
                                            + orderList.get(Integer.parseInt(command) - 1).toString() + "', has been removed");
                                    orderList.remove(Integer.parseInt(command) - 1);
                                } else {
                                    System.out.println("@ you abort removing");
                                }
                            }
                        }
                    }
                    break;
                }
                case "complete": {
                    System.out.println("@ Are you sure you do not want add some more? 'yes' to confirm\n~~command:");
                    if (sc.nextLine().equals("yes")) {
                        if (orderList.size()>0){
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

    public static void showCurrentOrder () {
        System.out.println("*****\nYour current order: ");
        for (int i = 0; i < orderList.size(); i++) {
            System.out.println((i + 1) + ". " + orderList.get(i).toString());
        }
        System.out.println("\n*****");
    }

    public static void exitQuery () {
        System.out.println("@ are you sure to abort your order and exit?\n@ 'yes' to confirm\n~~command:");
        if (sc.nextLine().equals("yes")) {
            System.out.println("@ Thank you for visiting our restaurant!");
            System.exit(1);
        }
    }

    public static void unknownCommand () {
        System.out.println("@ We do not recognize your action, please try again..");
    }

    public static boolean isNumeric (String str){
        try {
            int i = Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static void letterInsteadOfDigit(){
        System.out.println("@ Unfortunately you enter a letter instead of digit.. try again later");
    }

    public static void mistypeIndex(){
        System.out.println("@ Unfortunately, you mistype number of your order.. try again later");
    }

    public static void informAboutAddedOrder(){
        System.out.println("@ Added: " + orderList.get(orderList.size()-1));
    }

    public static double orderTotalCost(){
        double sum = 0.00;
        for (Food food : orderList) {
            sum+=food.getPrice();
        }
        return sum;
    }
    
}

