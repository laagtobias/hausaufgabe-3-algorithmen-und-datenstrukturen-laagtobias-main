/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package htw.berlin.wi.prog2;

import htw.berlin.wi.prog2.domain.BowlBuilder;
import htw.berlin.wi.prog2.service.parsing.DummyInputParser;
import htw.berlin.wi.prog2.service.parsing.ExtendableInputParser;
import htw.berlin.wi.prog2.ui.CommandLineUI;
import htw.berlin.wi.prog2.ui.UserInputWrapper;

public class BowlBotApp {
    public static void main(String[] args) {
        ExtendableInputParser parser = new DummyInputParser();
        BowlBuilder builder = new BowlBuilder(BowlBuilder.CreationStyle.PRECOMPUTED);
        CommandLineUI clui = new CommandLineUI(new UserInputWrapper(System.in, System.out), builder, parser);
        clui.launch();
    }
}
