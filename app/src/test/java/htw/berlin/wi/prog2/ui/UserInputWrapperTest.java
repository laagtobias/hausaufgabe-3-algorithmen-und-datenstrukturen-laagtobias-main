import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import htw.berlin.wi.prog2.ui.UserInputWrapper;

public class UserInputWrapperTest {

    @Test
    public void testAsk() {
        // Simuliere eine Benutzereingabe
        String input = "testinput";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());  // Eingabestream
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();          // Ausgabe-Stream
        PrintStream out = new PrintStream(outStream);                           // PrintStream für die Ausgabe

        // Erstelle die UserInputWrapper-Instanz
        UserInputWrapper userInputWrapper = new UserInputWrapper(in, out);

        // Rufe die ask-Methode auf und prüfe das Ergebnis
        String result = userInputWrapper.ask("Please enter something:");

        // Teste, ob die zurückgegebene Eingabe mit der simulierten Eingabe übereinstimmt
        assertEquals(input, result);

        // Optional: Überprüfen, ob die Ausgabe den erwarteten Text enthält
        String output = outStream.toString();
        assertTrue(output.contains("Please enter something:"));
    }
}
