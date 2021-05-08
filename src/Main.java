import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static String readInput() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return bufferedReader.readLine();
    }

    public static void main(String[] args) throws IOException {
        do {
            System.out.println("Введите формулу:");
            String formula = readInput().replaceAll("[^0-9A-Za-z/*+()-.]", "");
            if (formula.length() == 0) {
                throw new IllegalArgumentException("Формула не введена");
            }

            System.out.println("Введите аргументы (пример: a=1 b=5 h=12):");
            String arguments = readInput().replaceAll("[^0-9A-Za-z .=]", "");
            if (arguments.length() == 0) {
                throw new IllegalArgumentException("Аргументы не введены");
            }

            Calculator calc = new Calculator(arguments, formula);
            calc.run();

            System.out.println("Продолжить? (y/n)");
            String answer = readInput();
            if (answer.equals("n")) {
                break;
            }
            System.out.println("------------------------------");
        } while (true);
    }

    /**
     * class for calculation
     */
    private static class Calculator {

        private final String arguments;
        private final String formula;

        Calculator(String arguments, String formula) {
            this.arguments = arguments;
            this.formula = formula;
        }

        public void run() {
            String mathExpression = formula;
            HashMap<String, Double> argsMap = argsToMap(arguments);
            for (Map.Entry<String, Double> entry : argsMap.entrySet()) {
                mathExpression = mathExpression.replaceAll(entry.getKey(), entry.getValue().toString());
            }
            System.out.printf("Результат: %s\n", eval(mathExpression));
        }

        private HashMap<String, Double> argsToMap(String arguments) throws IllegalArgumentException {
            HashMap<String, Double> map = new HashMap<>();
            String[] arr = arguments.split(" ");
            String[] temp;
            for (String item : arr) {
                temp = item.split("=");
                if (temp.length != 2 || temp[0].length() != 1) {
                    throw new IllegalArgumentException("Неверный формат аргумента: '" + item + "' (" + Arrays.toString(temp) + ")");
                }
                map.put(temp[0].replace(" ", ""), Double.parseDouble(temp[1]));
            }
            return map;
        }

        /**
         * 5+3*(2-2)/3
         * @param str
         * @return
         */
        public double eval(final String str) {
            return new Object() {
                int pos = -1, ch;

                void nextChar() {
                    ch = (++pos < str.length()) ? str.charAt(pos) : -1;
                }

                boolean eat(int charToEat) {
                    while (ch == ' ') nextChar();
                    if (ch == charToEat) {
                        nextChar();
                        return true;
                    }
                    return false;
                }

                double parse() {
                    nextChar();
                    double x = parseExpression();
                    if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char) ch);
                    return x;
                }

                double parseExpression() {
                    double x = parseTerm();
                    for (; ; ) {
                        if (eat('+')) x += parseTerm(); // addition
                        else if (eat('-')) x -= parseTerm(); // subtraction
                        else return x;
                    }
                }

                double parseTerm() {
                    double x = parseFactor();
                    for (; ; ) {
                        if (eat('*')) x *= parseFactor(); // multiplication
                        else if (eat('/')) x /= parseFactor(); // division
                        else return x;
                    }
                }

                double parseFactor() {
                    double x;
                    int startPos = this.pos;
                    if (eat('(')) { // parentheses
                        x = parseExpression();
                        eat(')');
                    } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                        while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                        x = Double.parseDouble(str.substring(startPos, this.pos));
                    } else {
                        throw new RuntimeException("Unexpected: " + (char) ch);
                    }

                    return x;
                }
            }.parse();
        }
    }
}
