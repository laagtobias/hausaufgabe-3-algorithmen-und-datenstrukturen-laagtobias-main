package htw.berlin.wi.prog2.data;

import htw.berlin.wi.prog2.domain.Ingredient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MenuUtilsTest {

    private final Ingredient avocado = new Ingredient("Avocado", new BigDecimal("0.01"), 1000);
    private final Ingredient reis = new Ingredient("Reis", new BigDecimal("0.02"), 2000);
    private final Ingredient lachs = new Ingredient("Lachs", new BigDecimal("0.03"), 3000);

    private final Map<Long, Ingredient> testMenu = Map.of(
            42L, avocado,
            66L, reis,
            17L, lachs);

    @Test
    @DisplayName("should extract only the ingredient names from the Menu")
    void focusOnNames() {
        List<String> expected = List.of("Avocado", "Reis", "Lachs");
        List<String> actual = MenuUtils.focusOnNames(testMenu);

        List<String> expectedSorted = expected.stream().sorted().toList();
        List<String> actualSorted = actual.stream().sorted().toList();

        assertEquals(expectedSorted, actualSorted);
    }

    @Test
    @DisplayName("should handle empty map input for focusOnNames")
    void focusOnNamesEmpty() {
        List<String> actual = MenuUtils.focusOnNames(Map.of());
        assertTrue(actual.isEmpty());
    }

    @Test
    @DisplayName("should select the ingredient name and invert the passed map, i.e. keys become values and values become keys")
    void focusOnNameAndInvert() {
        Map<String, Long> actual = MenuUtils.focusOnNameAndInvert(testMenu);
        Map<String, Long> expected = Map.of(
                "Avocado", 42L,
                "Reis", 66L,
                "Lachs", 17L);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should handle empty map input for focusOnNameAndInvert")
    void focusOnNameAndInvertEmpty() {
        Map<String, Long> actual = MenuUtils.focusOnNameAndInvert(Map.of());
        assertTrue(actual.isEmpty());
    }

    @Test
    @DisplayName("should get the ingredients from the passed menu in the stated quantities of the input map")
    void ingredientsFromIdAndCount() {
        Map<Long, Integer> counts = Map.of(
                66L, 1,
                17L, 2);

        List<Ingredient> expected = List.of(reis, lachs, lachs);
        List<Ingredient> actual = MenuUtils.ingredientsFromIdAndCount(counts, testMenu);

        Comparator<Ingredient> byName = Comparator.comparing(Ingredient::getName);
        List<Ingredient> expectedSorted = expected.stream().sorted(byName).toList();
        List<Ingredient> actualSorted = actual.stream().sorted(byName).toList();

        assertEquals(expectedSorted, actualSorted);
    }

    @Test
    @DisplayName("should handle empty input for ingredientsFromIdAndCount")
    void ingredientsFromIdAndCountEmpty() {
        List<Ingredient> actual = MenuUtils.ingredientsFromIdAndCount(Map.of(), testMenu);
        assertTrue(actual.isEmpty());
    }

    @Test
    @DisplayName("should return an empty list when both inputs are empty")
    void ingredientsFromIdAndCountWithEmptyInput() {
        Map<Long, Integer> emptyCounts = Map.of();
        Map<Long, Ingredient> emptyMenu = Map.of();
        List<Ingredient> actual = MenuUtils.ingredientsFromIdAndCount(emptyCounts, emptyMenu);
        List<Ingredient> expected = List.of();
        assertEquals(expected, actual);
    }
}
