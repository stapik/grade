package yandex.b5;

import java.util.*;
import java.util.stream.IntStream;

public class Computer {

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int pupilGroupsCount = inp.nextInt(), roomCount = inp.nextInt(), lastRoomIdx = 0, groupCount = 0;
        List<Integer[]> pupilGroups = new ArrayList<>(pupilGroupsCount), roomComputers = new ArrayList<>(roomCount);
        int[] groupMap = new int[pupilGroupsCount + 1];

        IntStream.range(1, pupilGroupsCount + 1).forEach(i -> pupilGroups.add(new Integer[]{i, inp.nextInt()}));
        IntStream.range(1, roomCount + 1).forEach(i -> roomComputers.add(new Integer[]{i, inp.nextInt()}));
        pupilGroups.sort(Comparator.comparing(o -> o[1]));
        roomComputers.sort(Comparator.comparing(o -> o[1]));

        for (Integer[] group : pupilGroups) {
            while (lastRoomIdx < roomComputers.size() && group[1] + 1 > roomComputers.get(lastRoomIdx)[1]) {
                lastRoomIdx++;
            }
            if (lastRoomIdx == roomComputers.size()) {
                break;
            }
            groupMap[group[0]] = roomComputers.get(lastRoomIdx)[0];
            lastRoomIdx++;
            groupCount++;
        }

        System.out.println(groupCount);

        List<String> result = new LinkedList<>();
        Arrays.stream(groupMap).skip(1).forEach(i -> result.add(String.valueOf(i)));
        System.out.println(String.join(" ", result));
        inp.close();
    }
}
