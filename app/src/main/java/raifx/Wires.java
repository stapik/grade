package raifx;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Wires {

    public static void main(String[] args) {
        System.out.println(getResult(Arrays.asList(3, 4, 1, -1, 3))); // 2
        System.out.println(getResult(Arrays.asList(1, 0, -1, 2))); // 3
        System.out.println(getResult(Arrays.asList(2, 1, -1))); // 0
        System.out.println(getResult(Arrays.asList(3, 2, 1, -1))); // 0
    }
    /**
     * Implement method getResult
     */
    public static int getResult(List<Integer> connections) {
        int tempIdx, fromIdx, resultIdx = 0, tempLength = 0, maxLength = 0;

        parent:
        for (int i = 0; i < connections.size(); i++) {
            tempIdx = connections.get(i);
            fromIdx = i;
            tempLength = 1;
            Set<Integer> nums = new HashSet<>();
            while (tempIdx != -1) {
                if (nums.contains(tempIdx)) {
                    continue parent;
                }
                nums.add(tempIdx);
                tempIdx = connections.get(tempIdx);
                tempLength++;
            }
            if (tempLength > maxLength) {
                maxLength = tempLength;
                resultIdx = fromIdx;
            }
        }

        return resultIdx;
    }

    public static void runCode() {
        // Entrypoint to debug your function
    }
}
