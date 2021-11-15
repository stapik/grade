package yandex.b5;

import java.util.*;
import java.util.stream.IntStream;

public class Sum {

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int sum = inp.nextInt(), iIdx = 0, jIdx = 0, kIdx = 0, tempSum, kTempIdx;
        boolean resultFlag = false;
        List<Integer[]> iList = readData(inp, Comparator.comparing(o -> o[1])),
                jList = readData(inp, Comparator.comparing(o -> o[1])),
                kList = readData(inp, ((Comparator<Integer[]>) (o1, o2) -> o2[1].compareTo(o1[1])).thenComparing(o -> o[0]));

        for (Integer[] iItem : iList) {
            kTempIdx = 0;
            for (Integer[] jItem : jList) {
                while (kTempIdx < kList.size()) {
                    Integer[] kItem = kList.get(kTempIdx);
                    tempSum = sum - iItem[1] - jItem[1] - kItem[1];
                    if (tempSum < 0) {
                        kTempIdx++;
                    } else if (tempSum == 0 &&
                            (!resultFlag || compareLexicographically(
                                    new Integer[]{iItem[0], jItem[0], kItem[0]}, new Integer[]{iIdx, jIdx, kIdx}
                            ) < 0)) {
                        iIdx = iItem[0];
                        jIdx = jItem[0];
                        kIdx = kItem[0];
                        resultFlag = true;
                        break;
                    } else {
                        break;
                    }
                }
            }
        }

        System.out.println(resultFlag ? iIdx + " " + jIdx + " " + kIdx : -1);
        inp.close();
    }

    private static List<Integer[]> readData(Scanner inp, Comparator<Integer[]> comparator) {
        List<Integer[]> data = new ArrayList<>();
        IntStream.range(0, inp.nextInt()).forEach(i -> data.add(new Integer[]{i, inp.nextInt()}));
        data.sort(comparator);
        return data;
    }

    private static int compareLexicographically(Integer[] arr1, Integer[] arr2) {
        int result = 0, comparing;

        for (int i = 0; i < arr1.length; i++) {
            comparing = arr1[i].compareTo(arr2[i]);
            if (comparing != 0) {
                result = comparing;
                break;
            }
        }
        return result;
    }
}
