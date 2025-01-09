import java.util.*;

public class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            Deque<Integer> bridge = new ArrayDeque<>();
            int time = 0;
            int currentWeight = 0;
            int index = 0;

            for (int i = 0; i < bridge_length; i++) {
                bridge.add(0);
            }

            while (!bridge.isEmpty()) {
                time++;
                currentWeight -= bridge.poll();

                if (index < truck_weights.length) {
                    if (currentWeight + truck_weights[index] <= weight) {
                        bridge.add(truck_weights[index]);
                        currentWeight += truck_weights[index];
                        index++;
                    } else {
                        bridge.add(0);
                    }
                }
            }

            return time;
        }
}
