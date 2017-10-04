package pl.mareksowa.views;

import pl.mareksowa.controllers.UserController;
import pl.mareksowa.models.MenuLoader;
import pl.mareksowa.models.OrderManager;

public class OrderingSystem {

    private UserController userController;
    private MenuLoader menuLoader;
    private String command;

    //console interface
    public void start() {
        userController = new UserController();
        menuLoader = new MenuLoader();
        printWelcomeScreen();
        do {
            if (OrderManager.getInstance().getOrder().size() > 0) {
                printCurrentOrder();
                printOrderManageOptions(" or 'remove'");
            } else {
                printOrderManageOptions("");
            }
            command = userController.userCommand();
            switch (command) {
                case "add": {
                    System.out.println("@ Which type of order you wanna place? " + printSmallMenuOrderOptions()
                            + " 'lunch' maybe? \n~~command: ");
                    command = userController.userCommand();
                    if (command.equals("lunch")){
                        System.out.println("@ Please indicate which cuisine you prefer? "
                                + printMainCourseMenuOrderOptions() + " ?\n~~command: ");
                        addMainCourse(userController.userCommand());
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
                    command = userController.userCommand();
                    if (command.equals("yes")) {
                        if (OrderManager.getInstance().getOrder().size()>0){
                            System.out.println("@ Total value of your order is: $"
                                    + OrderManager.getInstance().getOrderTotalCost());
                            System.out.println("@ Enjoy your meal, waiter with order will be soon.");
                            System.exit(1);
                        } else {
                            System.out.println("@ We hope you order something in the future. Good bye!");
                            System.exit(1);
                        }
                    } else {
                        printUnknownCommand(command);
                    }
                    break;
                }
                case "exit": {
                    exitQuery();
                    break;
                }
                default: {
                    printUnknownCommand(command);
                    break;
                }
            }
        } while (true) ;
    }

    //other methods
    private void printWelcomeScreen(){
        System.out.println("@ Welcome in our restaurant");
        System.out.println("@ Make sure you enter proper query including Capital Letter (meal names), digits (choices "
                + "from lists). \n@ All choices please confirm by hitting 'enter'");
    }

    private void printOrderManageOptions(String optional){
        System.out.println("@ to manage your order write: 'add'" + optional + ", to complete order write 'complete',"
                + " to abort and exit you can always write 'exit'\n@ all options confirm by pressing 'enter'"
                + "\n~~command:");
    }

    private void printCurrentOrder () {
        System.out.println("\n*****Your current order: ");
        System.out.println(userController.showCurrentOrder());
        System.out.println("*****\n");
    }

    public void addSmallOrder(String foodOptionName){
        //check if user entered proper option name
        if (userController.checkIfUserEnteredProperSmallMenuFoodOptionName(foodOptionName)){
            System.out.println("@ Please indicate which '" + foodOptionName + "' you wanna add to your order list:");
            //display to user all small menu options
            System.out.println(userController.showSmallMenu(foodOptionName));
            System.out.println("~~command: ");
            command = userController.userCommand();
            if (!userController.isNumeric(command)) {
                printStatementLetterInsteadOfDigit();
            } else {
                if ((Integer.parseInt(command)) > menuLoader.getSmallMenu().get(foodOptionName).size()
                        || (Integer.parseInt(command) - 1) < 0) {
                    printStatementMistypeIndex();
                } else {
                    if (OrderManager.getInstance().addFoodToOrder(menuLoader.getSmallMenu().get(foodOptionName)
                            .get(Integer.parseInt(command) - 1))){
                        printInformAboutAddedOrder();
                    } else {
                        System.out.println("@ nothing has been added");
                    }
                }
            }
        } else {
            printUnknownCommand(foodOptionName);
        }
    }

    public void addMainCourse(String foodOptionName) {
        //check if user entered proper option of main course name
        if (userController.checkIfUserEnteredProperMainCourseFoodOptionName(foodOptionName)){
            System.out.println("@ Please indicate which main-course from cuisines '" + foodOptionName
                    + "' you wanna add to your order list:");
            //display to user all options from main course
            System.out.println(userController.showMainCourseMenu(foodOptionName));
            System.out.println("@ Which of these specials above above you wanna add?\n~~command: ");
            command = userController.userCommand();
            if (!userController.isNumeric(command)) {
                printStatementLetterInsteadOfDigit();
            } else {
                if ((Integer.parseInt(command)) > menuLoader.getMainCourseMenu().get(foodOptionName).size()
                        || (Integer.parseInt(command) - 1) < 0) {
                    printStatementMistypeIndex();
                } else {
                    if (OrderManager.getInstance().addFoodToOrder(menuLoader.getMainCourseMenu().get(foodOptionName)
                            .get(Integer.parseInt(command)-1))){
                        printInformAboutAddedOrder();
                    } else {
                        System.out.println("@ nothing has been added");
                    }
                }
            }
        } else {
            printUnknownCommand(foodOptionName);
        }
    }

    public void removeOrder(){
        if (OrderManager.getInstance().getOrder().size() < 1) {
            System.out.println("@ There is nothing to remove..");
        } else {
            printCurrentOrder();
            System.out.println("@ Please indicate which number of your order you wanna remove?\n~~command:");
            command = userController.userCommand();
            if (!userController.isNumeric(command)) {
                printStatementLetterInsteadOfDigit();
            } else {
                if ((Integer.parseInt(command)) > OrderManager.getInstance().getOrder().size()
                        || (Integer.parseInt(command) - 1) < 0) {
                    printStatementMistypeIndex();
                } else {
                    System.out.println("@ are you sure to remove '" + OrderManager.getInstance().getOrder()
                            .get((Integer.parseInt(command) - 1))
                            + "'? \n'yes' to confirm\n~~command:");
                    if (userController.userCommand().equals("yes")) {
                        String removedItemName = OrderManager.getInstance().getOrder()
                                .get(Integer.parseInt(command) - 1).toString();
                        if (OrderManager.getInstance().removeFoodFromOrder(Integer.parseInt(command)-1)){
                            System.out.println("@ Order nr: " + command + ", '"
                                    + removedItemName + "', has been removed");
                        } else {
                            System.out.println("@ nothing has been remove");
                        }
                    } else {
                        System.out.println("@ you abort removing");
                    }
                }
            }
        }
    }

    private void printStatementLetterInsteadOfDigit(){
        System.out.println("@ Unfortunately you enter a letter instead of digit.. try again later");
    }

    private void printStatementMistypeIndex(){
        System.out.println("@ Unfortunately, you mistype number of your order.. try again later");
    }

    private String printSmallMenuOrderOptions(){
        return userController.showSmallMenuOptions();
    }

    private String printMainCourseMenuOrderOptions(){
        return userController.showMainCourseMenuOptions().toString();
    }

    private void printInformAboutAddedOrder(){
        System.out.println("@ Added: " + OrderManager.getInstance().getOrder()
                .get(OrderManager.getInstance().getOrder().size()-1));
        System.out.println("?");
    }

    private void printUnknownCommand(String userCommand) {
        System.out.println("@ We do not recognize action: '" + userCommand + "', please try again..");
    }

    private void exitQuery () {
        System.out.println("@ are you sure to abort your order and exit?\n@ 'yes' to confirm\n~~command:");
        if (userController.userCommand().equals("yes")) {
            System.out.println("@ Thank you for visiting our restaurant!");
            System.exit(1);
        }
    }
}

