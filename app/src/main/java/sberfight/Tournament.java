package sberfight;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Tournament {

    public static void main(String[] args) {
        System.out.println(getResult(Arrays.asList(2, 1, 0, 2))); // [33, 33, 0, 33]
        System.out.println(getResult(Arrays.asList(1, 0, 3, 4))); // [17, 0, 17, 67]
        System.out.println(getResult(Arrays.asList(2, 2, 2, 2))); // [17, 0, 17, 67]
    }

    public static List<Integer> getResult(List<Integer> fightersStamina) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> possibleVictories = calcVictories(fightersStamina);
        int totalVictories = 0, percent;

        if (fightersStamina.size() != 4) {
            throw new RuntimeException("Invalid number of fighters");
        }

        for (Map.Entry<Integer, Integer> fighterVictories : possibleVictories.entrySet()) {
            totalVictories += fighterVictories.getValue();
        }
        if (totalVictories > 0) {
            for (Map.Entry<Integer, Integer> fighterVictories : possibleVictories.entrySet()) {
                percent = (int) (Math.round((double) fighterVictories.getValue() / totalVictories * 100));
                result.add(fighterVictories.getKey(), percent);
            }
        }

        return result;
    }

    private static Map<Integer, Integer> calcVictories(List<Integer> fightersStamina) {
        Map<Integer, Integer> fightersWins = new HashMap<>();
        Supplier<Set<Integer>> fighters = () -> IntStream.range(0, fightersStamina.size()).boxed().collect(Collectors.toSet());
        Set<Integer> fightersSetTemp;
        List<Integer> fightersListTemp;
        int firstFighter, secondFighter, thirdFighter, fourthFighter;

        for (int i = 0; i < fightersStamina.size(); i++) {
            fightersWins.put(i, 0);
        }

        for (int i = 0; i < fightersStamina.size() - 1; i++) {
            firstFighter = i;

            for (int j = i + 1; j < fightersStamina.size(); j++) {
                secondFighter = j;
                // run with 2 pairs
                fightersSetTemp = fighters.get();
                fightersSetTemp.removeAll(Arrays.asList(i, j));
                fightersListTemp = new ArrayList<>(fightersSetTemp);
                thirdFighter = fightersListTemp.get(0);
                fourthFighter = fightersListTemp.get(1);

                int[] winner = fight(
                        fight(
                                new int[]{firstFighter, fightersStamina.get(firstFighter)},
                                new int[]{secondFighter, fightersStamina.get(secondFighter)}
                        ),
                        fight(
                                new int[]{thirdFighter, fightersStamina.get(thirdFighter)},
                                new int[]{fourthFighter, fightersStamina.get(fourthFighter)}
                        )
                );
                fightersWins.merge(winner[0], 1, Integer::sum);
            }

        }

        return fightersWins;
    }

    private static int[] fight(int[] fighter1, int[] fighter2) {
        int[] winner;
        if (fighter1[1] == fighter2[1]) {
            fighter1[1] = 0;
            winner = fighter1;
        } else if (fighter1[1] > fighter2[1]) {
            fighter1[1] = fighter1[1] - fighter2[1];
            winner = fighter1;
        } else {
            fighter2[1] = fighter2[1] - fighter1[1];
            winner = fighter2;
        }

        return winner;
    }
}
