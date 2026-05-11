import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    enum State { START, S1, S2, S3, ERROR }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filename = "text.txt";

        System.out.println("\tПошук за регулярним виразом");
        String regex = "(\\d+E)+\\d+";
        Pattern pattern = Pattern.compile(regex);

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    System.out.println("Знайдено збіг (Рівень 1): " + matcher.group());
                }
            }
        } catch (IOException e) {
            System.out.println("Помилка читання файлу (створи text.txt): " + e.getMessage());
        }

        System.out.println("\n\tСинтаксична перевірка автоматом");
        System.out.print("Введіть рядок для перевірки автоматом: ");
        String inputWord = scanner.nextLine();

        if (checkWithSwitchFSM(inputWord)) {
            System.out.println("Слово ПРАВИЛЬНЕ!");
        } else {
            System.out.println("Слово НЕПРАВИЛЬНЕ!");
        }

        System.out.println("\n\tЧитання з файлу та розбиття роздільниками");
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("[%+ ]+");
                for (String word : words) {
                    if (word.isEmpty()) continue;
                    boolean isValid = checkWithTableFSM(word);
                    System.out.println("Слово '" + word + "' -> " + (isValid ? "ПРАВИЛЬНЕ" : "НЕПРАВИЛЬНЕ"));
                }
            }
        } catch (IOException e) {
            System.out.println("Помилка читання файлу: " + e.getMessage());
        }
    }

    private static boolean checkWithSwitchFSM(String word) {
        State currentState = State.START;

        for (char c : word.toCharArray()) {
            switch (currentState) {
                case START:
                    if (Character.isDigit(c)) currentState = State.S1;
                    else currentState = State.ERROR;
                    break;
                case S1:
                    if (Character.isDigit(c)) currentState = State.S1;
                    else if (c == 'E') currentState = State.S2;
                    else currentState = State.ERROR;
                    break;
                case S2:
                    if (Character.isDigit(c)) currentState = State.S3;
                    else currentState = State.ERROR;
                    break;
                case S3:
                    if (Character.isDigit(c)) currentState = State.S3;
                    else if (c == 'E') currentState = State.S2;
                    else currentState = State.ERROR;
                    break;
                case ERROR:
                    break;
            }
        }
        return currentState == State.S3;
    }

    private static boolean checkWithTableFSM(String word) {
        State[][] transitionTable = {
                { State.S1, State.ERROR, State.ERROR },
                { State.S1, State.S2,    State.ERROR },
                { State.S3, State.ERROR, State.ERROR },
                { State.S3, State.S2,    State.ERROR },
                { State.ERROR, State.ERROR, State.ERROR }
        };

        State currentState = State.START;

        for (char c : word.toCharArray()) {
            int colIndex = getCharColumn(c);
            currentState = transitionTable[currentState.ordinal()][colIndex];
        }
        return currentState == State.S3;
    }

    private static int getCharColumn(char c) {
        if (Character.isDigit(c)) return 0;
        if (c == 'E') return 1;
        return 2;
    }
}