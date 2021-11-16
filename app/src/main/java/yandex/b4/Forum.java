package yandex.b4;

import java.util.*;

public class Forum {

    public static void main(String[] args) throws Exception {
        Scanner inp = new Scanner(System.in);
        int numMessages = Integer.parseInt(inp.nextLine()), num;
        Integer[] replies = new Integer[numMessages];
        String[] topics = new String[numMessages];

        for (int i = 0; i < numMessages; i++) {
            num = Integer.parseInt(inp.nextLine());
            if (num == 0) {
                replies[i] = i;
                topics[i] = inp.nextLine();
            } else {
                replies[i] = replies[num - 1];
            }
            inp.nextLine();
        }

        NavigableMap<Integer, Integer> cntReplies = new TreeMap<>();
        for (Integer reply : replies) {
            cntReplies.merge(reply, 1, Integer::sum);
        }
        int topicIndex = cntReplies.entrySet().stream()
                .min((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .orElseThrow(() -> new Exception("Empty map"))
                .getKey();
        
        System.out.println(topics[topicIndex]);
        inp.close();
    }
}
