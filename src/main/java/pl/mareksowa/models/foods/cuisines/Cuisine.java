package pl.mareksowa.models.foods.cuisines;

import pl.mareksowa.models.foods.Food;

public abstract class Cuisine extends Food {

    public String description;
    public String ingredients;


    public Cuisine(String name, double price, String description, String ingredients) {
        super(name, price);
        this.description = description;
        this.ingredients = ingredients;
    }

    public String getDescription() {
        return description;
    }

    public String getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return super.getName() + ", $" + super.getPrice() + ", description='" + description
                + "', ingredients='" + ingredients + "'.";
    }
}
