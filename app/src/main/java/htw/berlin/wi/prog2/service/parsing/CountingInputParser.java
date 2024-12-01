package htw.berlin.wi.prog2.service.parsing;
import java.util.HashMap;
import java.util.Map;

public class CountingInputParser implements ExtendableInputParser {

    public Map<Long, Integer> idsAndCountFromInput(String inputLine, Map<String, Long> keywordsToIds) {
        Map<Long, Integer> ingredientCounts = new HashMap<>();
        String[] inputWords = inputLine.split("\\s+");


        for (int i = 0; i < inputWords.length; i++) {
            String word = inputWords[i].replaceAll("[^a-zA-Z-]", "");
            String[] subWords = word.split("-");
            for (String subWord : subWords) {
                if (keywordsToIds.containsKey(subWord)) {
                    Long id = keywordsToIds.get(subWord);
                    ingredientCounts.put(id, ingredientCounts.getOrDefault(id, 0) + 1);
                }
            }
        }

        return ingredientCounts;
    }
}