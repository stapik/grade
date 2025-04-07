package grade;

public class Rounding {

    public static void main(String[] args) {
        show("Math.round(2.6)", String.valueOf(Math.round(2.6)));
        show("Math.round(-2.6)", String.valueOf(Math.round(-2.6)));

        show("Math.round(2.55)", String.valueOf(Math.round(2.55)));
        show("Math.round(-2.55)", String.valueOf(Math.round(-2.55)));

        show("Math.round(2.49)", String.valueOf(Math.round(2.49)));
        show("Math.round(-2.49)", String.valueOf(Math.round(-2.49)));

        show("Math.round(2.5)", String.valueOf(Math.round(2.5)));
        show("Math.round(-2.5)", String.valueOf(Math.round(-2.5)));
    }

    public static void show(String title, String value) {
        System.out.printf("%s => %s\n", title, value);
    }
}
