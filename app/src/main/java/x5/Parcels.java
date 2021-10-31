package x5;

import java.util.*;

public class Parcels {

    public static int getResult(List<Integer> parcels, int m) {
        int count = 0, first, second;
        Set<Integer> packed = new HashSet<>();

        for (int i = 0; i < parcels.size() - 1; i++) {
            first = parcels.get(i);
            for (int j = i + 1; j < parcels.size(); j++) {
                second = parcels.get(j);
                if (packed.contains(j) || packed.contains(i)) {
                    continue;
                }
                if (first + second == m) {
                    packed.add(j);
                    packed.add(i);
                    count++;
                }
            }
        }

        return count;
    }
}
