package yandex.b7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Customs {

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int count = inp.nextInt(), numberOfCargo = 0, maxNumbersOfCargo = 0, timeIn, timeProcessing;
        List<Integer[]> events = new ArrayList<>(count * 2);
        while (count > 0) {
            timeIn = inp.nextInt();
            timeProcessing = inp.nextInt();
            events.add(new Integer[]{1, timeIn});
            events.add(new Integer[]{-1, timeIn + timeProcessing});
            count--;
        }
        events.sort(((Comparator<Integer[]>) (o1, o2) -> o1[1].compareTo(o2[1])).thenComparing((o1, o2) -> o1[0].compareTo(o2[0])));

        if (events.size() < 2) {
            System.out.println(events.size());
            return;
        }

        for (Integer[] event : events) {
            numberOfCargo += event[0];
            maxNumbersOfCargo = Math.max(maxNumbersOfCargo, numberOfCargo);
        }

        System.out.println(maxNumbersOfCargo);
    }
}
