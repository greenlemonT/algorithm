import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (String operation : operations) {
            String[] parts = operation.split(" ");
            String command = parts[0];
            int number = Integer.parseInt(parts[1]);

            if (command.equals("I")) {
                minHeap.offer(number);
                maxHeap.offer(number);
            } else if (command.equals("D")) {
                if (number == 1 && !maxHeap.isEmpty()) {
                    int max = maxHeap.poll();
                    minHeap.remove(max);
                } else if (number == -1 && !minHeap.isEmpty()) {
                    int min = minHeap.poll();
                    maxHeap.remove(min);
                }
            }
        }

        if (minHeap.isEmpty() || maxHeap.isEmpty()) {
            return new int[]{0, 0};
        }

        return new int[]{maxHeap.peek(), minHeap.peek()};
    }
}
