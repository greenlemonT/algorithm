import java.util.*;

class Solution {
        public int solution(int[] scoville, int K) {
            PriorityQueue<Integer> heap = new PriorityQueue<>();

            for (int s : scoville) {
                heap.offer(s);
            }
            int count = 0;

            while (heap.size() > 1 && heap.peek() < K) {
                int first = heap.poll();
                int second = heap.poll();

                int a = first + (second * 2);
                heap.offer(a);
                count++;
            }

            if (heap.peek() < K) {
                return -1;
            }

            return count;
        }
    }