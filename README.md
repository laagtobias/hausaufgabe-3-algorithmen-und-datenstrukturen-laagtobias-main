[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/u9B1Mzle)
# Hausaufgabe Nr. 3

In dieser Hausaufgabe geht es darum das Bowl-Chatbot Programm 'intelligenter' zu machen.
So soll es beispielsweise Mehrfachnennungen von Zutaten verstehen und Schreibfehler tolerieren.

## Abgabe

Nehmen Sie das Assignment auf Github Classroom an und wählen Sie Ihren Namen aus der Liste aus.
Dadurch wird ein (dieses) Repository für Sie erstellt. 
Klonen Sie das Repo und pushen Sie Ihre Lösungen in mehreren sinnvoll zusammengefassten Commits (z.B. einer pro Teilaufgabe, es können aber auch gerne mehr sein).
Sie müssen Ihre Lösung bis zum 1. Dezember um 23:59 Uhr gepusht haben, alle Tests müssen grün sein, und Sie müssen spätestens in der darauf folgenden von Ihnen belegten Übungsgruppe Ihre Lösung kurz demonstrieren.

## Aufgabenstellung

0. Betrachten Sie die Klassen `Menu` und `MenuUtils` im Paket `data` und die verschiedenen Klassen im Paket `service/parsing`, sowie die dazugehörigen Tests wie etwa `MenuUtilsTest` und `CountingInputParserTest`, die das Soll-Verhalten dieser Klassen spezifizieren.
1. Implementieren Sie in der Klasse `MenuUtils` die Methode `focusOnNameAndInvert`, sodass der dazu passende Test grün wird. Erstellen Sie außerdem einen weiteren Testfall, der einen Methodenaufruf mit leeren Eingaben prüft.
2. Implementieren Sie in der Klasse `MenuUtils` die Methode `ingredientsFromIdAndCount`, sodass der dazu passende Test grün wird. Erstellen Sie außerdem einen weiteren Testfall, der einen Methodenaufruf mit leeren Eingaben prüft.
3. Implementieren Sie in der Klasse `CountingInputParser` die Methode `idsAndCountFromInput`, sodass der passende Test `CountingInputParserTest` sowie der `UIParserBuilderIntegrationTest` grün werden. 
4. Implementieren Sie in der Klasse `TypoTolerantInputParser` die Methode `idsAndCountFromInput`, sodass der passende Test grün wird.
5. (Optional) Implementieren Sie in der Klasse `SmartInputParser` die Methode `idsAndCountFromInput`, sodass der passende Test grün wird. Verwenden Sie in der Klasse `BowlBotApp` anstelle des `DummyInputParsers` Ihren `SmartInputParser`.

## Hinweise 
- Für den `CountingInputParser` schauen Sie sich die Methode `split` der Klasse `String` an und recherchieren Sie nach Beispielen, die reguläre Ausdrücke (regular expressions) verwenden.
- Implementieren Sie gerne weitere Testfälle zu den verschiedenen Parsern. Häufig hilft es bei der Lösungsfindung weitere Beispiele von Soll-Verhalten in Form von Tests zu formulieren.
