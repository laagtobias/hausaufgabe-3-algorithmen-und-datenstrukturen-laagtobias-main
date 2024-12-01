package htw.berlin.wi.prog2.data;

import htw.berlin.wi.prog2.domain.Ingredient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuUtils {

    public static List<String> focusOnNames(Map<Long, Ingredient> articles) {
        List<String> names = new ArrayList<>();
        for (Ingredient art : articles.values()) {
            names.add(art.getName());
        }
        return names;
    }

    public static Map<String, Long> focusOnNameAndInvert(Map<Long, Ingredient> articles) {
        Map<String, Long> invertedMap = new HashMap<>();
        for (Map.Entry<Long, Ingredient> entry : articles.entrySet()) {
            invertedMap.put(entry.getValue().getName(), entry.getKey());
        }
        return invertedMap;
    }

    public static List<Ingredient> ingredientsFromIdAndCount(Map<Long, Integer> idsAndCount, Map<Long, Ingredient> articles) {
        List<Ingredient> ingredients = new ArrayList<>();
        for (Map.Entry<Long, Integer> entry : idsAndCount.entrySet()) {
            Long id = entry.getKey();
            Integer count = entry.getValue();
            Ingredient ingredient = articles.get(id);

            for (int i = 0; i < count; i++) {
                ingredients.add(ingredient);
            }
        }
        return ingredients;
    }
}
