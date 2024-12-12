package htw.berlin.wi.prog2.domain;

import java.math.BigDecimal;

public abstract class AbstractIngredient implements Ingredient {
    private final String name;
    private final BigDecimal price;
    private final int calories;

    public AbstractIngredient(String name, BigDecimal price, int calories) {
        this.name = name;
        this.price = price;
        this.calories = calories;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public int getCalories() {
        return calories;
    }

    @Override
    public String toString() {
        return name;
    }
}
