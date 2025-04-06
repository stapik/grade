package grade.patterns.structural;

import java.util.Arrays;

/**
 * Адаптер — это структурный паттерн, который позволяет подружить несовместимые объекты.
 */
public class Adapter {

    static class OldPhone {

        public void makeCall(String number, String callerName) {
            System.out.println("Calling to " + number);
        }
    }

    interface Phone {
        void call(String number);
    }

    static class OldPhoneAdapter implements Phone {

        private final OldPhone oldPhone;

        OldPhoneAdapter(OldPhone oldPhone) {
            this.oldPhone = oldPhone;
        }

        @Override
        public void call(String number) {
            oldPhone.makeCall(number, "");
        }
    }

    public static void main(String[] args) {
        // объект - адаптер
        Phone oldPhoneAdapter = new OldPhoneAdapter(new OldPhone());
        oldPhoneAdapter.call("79118879898");

        // adapter's для массива
        Arrays.asList(new int[]{1, 2, 3, 4});
        Arrays.stream(new double[]{3.5, 5.2, 6.3});
    }
}
