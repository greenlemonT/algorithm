
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
        public String solution(String number, int k) {
            Deque<Character> queue = new ArrayDeque<>();

            for (char digit : number.toCharArray()) {
                while (k > 0 && !queue.isEmpty() && queue.peekLast() < digit) {
                    queue.pollLast();
                    k--;
                }
                queue.addLast(digit); 
            }

            StringBuilder result = new StringBuilder();
            while (!queue.isEmpty()) {
                result.append(queue.pollFirst());
            }

            return result.substring(0, result.length() - k);
        }
    

    }
