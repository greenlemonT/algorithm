import java.util.*;

class Solution {
        public int solution(int k, int[] tangerine) {
            Map<Integer, Integer> counter = new HashMap<>();

            for (int size : tangerine) {
                counter.put(size, counter.getOrDefault(size, 0) + 1);
            }
            List<Integer> counts = new ArrayList<>(counter.values());
            counts.sort(Collections.reverseOrder());

            int sum = 0;
            int type = 0;

            for (int count : counts) {
                sum += count;
                type++;
                if (sum >= k) {
                    break;
                }
            }
            return type;
        }
    }
