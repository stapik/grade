package yandex.b7;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Customs {

    public static void main(String[] args) throws IOException {
        Scanner inp = new Scanner(System.in);
        int count = inp.nextInt(), numberOfCargo = 0, maxNumbersOfCargo = 0, timeIn, timeProcessing;
        List<Event> events = new ArrayList<>(count * 2);
        while (count > 0) {
            timeIn = inp.nextInt();
            timeProcessing = inp.nextInt();
            events.add(new Event(Type.START, timeIn));
            events.add(new Event(Type.END, timeIn + timeProcessing));
            count--;
        }
        events.sort(Comparator.comparing(Event::getValue).thenComparing(Event::getType));

        if(events.size() < 2){
            System.out.println(events.size());
            return;
        }

        for (Event event : events) {
            if (event.type.equals(Type.END)) {
                numberOfCargo -= 1;
            }
            if (event.type.equals(Type.START)) {
                numberOfCargo += 1;
            }
            maxNumbersOfCargo = Math.max(maxNumbersOfCargo, numberOfCargo);
        }

        System.out.println( maxNumbersOfCargo);
    }

    private enum Type {
        END, START
    }

    private static class Event {
        private final Type type;
        private final int value;

        public Event(Type type, int value) {
            this.type = type;
            this.value = value;
        }

        public Type getType() {
            return type;
        }

        public int getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Event{type=" + type + ", value=" + value + '}';
        }
    }
}
