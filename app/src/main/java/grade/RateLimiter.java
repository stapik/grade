package grade;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

public class RateLimiter {

    public static void main(String[] args) {
        RateLimitService limitService = new RateLimitService(3, 10_000);

        System.out.println(limitService.isValid("user1", 0)); // true
        System.out.println(limitService.isValid("user1", 3_000)); // true
        System.out.println(limitService.isValid("user1", 7_000)); // true
        System.out.println(limitService.isValid("user1", 8_000)); // false
        System.out.println(limitService.isValid("user1", 20_000)); // true
        System.out.println(limitService.isValid("user1", 22_000)); // true
    }

    private static class RateLimitService {

        private final int requests;
        private final long timeWindow;

        public RateLimitService(int requests, long timeWindow) {
            this.requests = requests;
            this.timeWindow = timeWindow;
        }

        private Map<String, Queue<Long>> userRequests = new ConcurrentHashMap<>();


        public boolean isValid(String userId, long timestamp) {
            userRequests.putIfAbsent(userId, new LinkedList<>());

            Queue<Long> queue = userRequests.get(userId);

            while (!queue.isEmpty() && queue.peek() < timestamp - timeWindow) {
                queue.poll();
            }
            if (queue.size() < requests) {
                queue.offer(timestamp);
                return true;
            }

            return false;
        }
    }
}
