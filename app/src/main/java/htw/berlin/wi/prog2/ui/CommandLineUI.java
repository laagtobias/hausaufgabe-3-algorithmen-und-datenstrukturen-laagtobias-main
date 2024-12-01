package htw.berlin.wi.prog2.ui;

import htw.berlin.wi.prog2.data.Menu;
import htw.berlin.wi.prog2.data.MenuUtils;
import htw.berlin.wi.prog2.domain.Bowl;
import htw.berlin.wi.prog2.domain.Ingredient;
import htw.berlin.wi.prog2.service.parsing.ExtendableInputParser;
import htw.berlin.wi.prog2.service.BowlBuilder;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class CommandLineUI {
    private final UserInputWrapper input;
    private final BowlBuilder builder;
    private final ExtendableInputParser parser;

    public CommandLineUI(UserInputWrapper uiw, BowlBuilder sb, ExtendableInputParser ip) {
        input = uiw;
        builder = sb;
        parser = ip;
    }

    public String launch() {
        String inputLine = input.ask("Willkommen beim Bowl-Bot! Was möchtest du gerne bestellen?");
        Map<Long, Ingredient> articles = Menu.getAllArticles();
        while (!(inputLine.equals("Bestellung abschliessen") || inputLine.equals("Auf Wiedersehen"))) {
            Map<String, Long> keywordsToIds = MenuUtils.focusOnNameAndInvert(articles);
            Map<Long, Integer> parsedIngredients = parser.idsAndCountFromInput(inputLine, keywordsToIds);
            List<Ingredient> ingredients = MenuUtils.ingredientsFromIdAndCount(parsedIngredients, articles);
            if(ingredients.isEmpty()) {
                inputLine = input.ask("Entschuldigung, ich habe dich nicht verstanden. Wähle aus folgenden Zutaten: "
                        + MenuUtils.focusOnNames(articles));
            } else {
                for (Ingredient ing : ingredients) builder.add(ing);
                Bowl bowl = builder.build();
                BigDecimal price = bowl.calculatePrice();
                String formattedPrice = String.format("%.2f", price).replace(',', '.');;
                List<String> ingrNames = bowl.getIngredientNames().stream().sorted().collect(Collectors.toList());
                inputLine = input.ask("In Ordnung. Deine Bowl mit " + ingrNames +
                        " kostet " + formattedPrice + " Euro. Willst du die Bestellung abschliessen?");
            }
        }
        return inputLine;
    }

}