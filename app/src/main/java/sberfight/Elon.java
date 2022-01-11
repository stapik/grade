package sberfight;

import java.util.*;

public class Elon {

    public static void main(String[] args) {
        System.out.println(getResult(Arrays.asList(3, 11), Arrays.asList(5, 1))); // 1
        System.out.println(getResult(Arrays.asList(2, 3), Arrays.asList(1, 2))); // 2
        System.out.println(getResult(Arrays.asList(2, 2), Arrays.asList(1, 2))); // 1
        System.out.println(getResult(Arrays.asList(4, 10), Arrays.asList(4, 3))); // 1
    }

    public static int getResult(List<Integer> rocketPos, List<Integer> rocketSpeed) {
        Map<Integer, Integer> posSpeed = new HashMap<>();
        for (int i = 0; i < rocketPos.size(); i++) {
            posSpeed.merge(rocketPos.get(i), rocketSpeed.get(i), Integer::sum);
        }

        int stepsToMove = findMinSteps(posSpeed);
        while (stepsToMove > 0) {
            posSpeed = move(posSpeed, stepsToMove);
            stepsToMove = findMinSteps(posSpeed);
        }

        return posSpeed.size();
    }

    private static int findMinSteps(Map<Integer, Integer> posSpeed) {
        TreeMap<Integer, Set<Integer>> stepPositions = new TreeMap<>();
        int steps = 0;

        for (Map.Entry<Integer, Integer> entry1 : posSpeed.entrySet()) {
            for (Map.Entry<Integer, Integer> entry2 : posSpeed.entrySet()) {
                if (entry1.getKey().equals(entry2.getKey())) {
                    continue;
                }
                steps = countSteps(entry1.getKey(), entry2.getKey(), entry1.getValue(), entry2.getValue());
                if (steps > -1) {
                    Set<Integer> set = stepPositions.get(steps);
                    if (set == null) {
                        set = new HashSet<>();
                    }
                    set.add(entry1.getKey());
                    set.add(entry2.getKey());
                    stepPositions.put(steps, set);
                }
            }
        }

        for (Map.Entry<Integer, Set<Integer>> entry : stepPositions.entrySet()) {
            if (entry.getValue().size() < 2) {
                stepPositions.remove(entry.getKey());
            }
        }

        return stepPositions.size() > 0 ? stepPositions.firstKey() : 0;
    }

    private static Map<Integer, Integer> move(Map<Integer, Integer> posSpeed, int steps) {
        Map<Integer, Integer> newPosSpeed = new HashMap<>();

        for (Map.Entry<Integer, Integer> entry : posSpeed.entrySet()) {
            newPosSpeed.merge(entry.getKey() + entry.getValue() * steps, entry.getValue(), Integer::sum);
        }
        return newPosSpeed;
    }

    // -1 is not found
    private static int countSteps(int p1, int p2, int v1, int v2) {
        if (p2 < p1 && v2 > v1 || p1 < p2 && v1 > v2) {
            int p = Math.abs(p1 - p2);
            int v = Math.abs(v1 - v2);
            return p % v == 0 ? p / v : -1;
        }

        return -1;
    }
}