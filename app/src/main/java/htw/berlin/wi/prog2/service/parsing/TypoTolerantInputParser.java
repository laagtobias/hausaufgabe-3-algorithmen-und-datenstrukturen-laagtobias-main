package htw.berlin.wi.prog2.service.parsing;

import java.util.HashMap;
import java.util.Map;

public class TypoTolerantInputParser implements ExtendableInputParser {

    @Override
    public Map<Long, Integer> idsAndCountFromInput(String inputLine, Map<String, Long> keywordsToIds) {
        Map<Long, Integer> idCountMap = new HashMap<>();

        // Durch die Schlüsselwörter iterieren
        for (Map.Entry<String, Long> entry : keywordsToIds.entrySet()) {
            String keyword = entry.getKey();
            Long id = entry.getValue();

            // Zähle, wie oft das Schlüsselwort im Input vorkommt
            int count = countOccurrences(inputLine, keyword);

            // Falls das Schlüsselwort gefunden wurde, füge es zur Map hinzu
            if (count > 0) {
                idCountMap.put(id, idCountMap.getOrDefault(id, 0) + count);
            }
        }
        return idCountMap;
    }

    // Hilfsmethode zum Zählen der Vorkommen eines Schlüsselworts im Eingabestring
    private int countOccurrences(String input, String keyword) {
        int count = 0;
        int index = 0;

        while ((index = input.indexOf(keyword, index)) != -1) {
            count++;
            index += keyword.length();
        }
        return count;
    }
}
