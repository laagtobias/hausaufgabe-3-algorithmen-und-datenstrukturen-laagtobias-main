package htw.berlin.wi.prog2.data;

import htw.berlin.wi.prog2.domain.Ingredient;
import htw.berlin.wi.prog2.domain.IngredientBuilder;

import java.util.*;

// Eine statische Datenbank-Klasse
public class Menu {
    private Menu() {}
    private static IngredientBuilder builder = new IngredientBuilder();

    public static Map<Long, Ingredient> bases = Map.of(
            1L, builder.setName("Reis").setPrice("0.60").setCals(120).build(Ingredient.Category.BASE),
            2L, builder.setName("Quinoa").setPrice("0.70").setCals(100).build(Ingredient.Category.BASE));
    public static Map<Long, Ingredient> proteins = Map.of(
            3L, builder.setName("Lachs").setPrice("0.90").setCals(90).build(Ingredient.Category.PROTEIN),
            4L, builder.setName("Tofu").setPrice("0.90").setCals(80).build(Ingredient.Category.PROTEIN));
    public static Map<Long, Ingredient> toppings = Map.of(
            5L, builder.setName("Tomate").setPrice("0.40").setCals(20).build(Ingredient.Category.TOPPING),
            6L, builder.setName("Edamame").setPrice("0.60").setCals(30).build(Ingredient.Category.TOPPING),
            7L, builder.setName("Avocado").setPrice("0.60").setCals(40).build(Ingredient.Category.TOPPING),
            8L, builder.setName("Zwiebeln").setPrice("0.30").setCals(20).build(Ingredient.Category.TOPPING));
    public static Map<Long, Ingredient> sauces = Map.of(
            9L, builder.setName("Mayo").setPrice("0.30").setCals(40).build(Ingredient.Category.SAUCE),
            10L, builder.setName("Sesam").setPrice("0.30").setCals(40).build(Ingredient.Category.SAUCE));

    public static Map<Long, Ingredient> getAllArticles() {
        Map<Long, Ingredient> articles = new HashMap<>();
        articles.putAll(bases);
        articles.putAll(proteins);
        articles.putAll(toppings);
        articles.putAll(sauces);
        return articles;
    }

}