package htw.berlin.wi.prog2.domain;

import java.math.BigDecimal;

public interface Ingredient {
    String getName();
    BigDecimal getPrice();
    int getCalories();
}
