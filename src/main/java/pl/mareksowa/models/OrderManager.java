package pl.mareksowa.models;

import pl.mareksowa.models.foodModels.Food;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class OrderManager {

    private static OrderManager ourInstance = new OrderManager();

    public static OrderManager getInstance() {
        return ourInstance;
    }

    private OrderManager() {
    }

    private List<Food> order = new ArrayList<>();

    public List<Food> getOrder() {
        return order;
    }

    public boolean addFoodToOrder(Food foodToAdd){
        if (foodToAdd!=null){
            order.add(foodToAdd);
            return true;
        }
        return false;
    }

    public boolean removeFoodFromOrder(int orderIndex){
        if (orderIndex < order.size() && orderIndex >= 0) {
            order.remove(orderIndex);
            return true;
        }
        return false;
    }

    public String getOrderTotalCost(){
        double sum = 0.00;
        for (Food food : order) {
            sum+=food.getPrice();
        }
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        return decimalFormat.format(sum);
    }

}
