import java.util.*;

public class Solution {
        public int solution(int[][] routes) {
            //나가는 시간 기준으로 정렬
            Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));
            //Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

            int cameras = 0;
            int position = Integer.MIN_VALUE;

            for (int[] route : routes) {
                if (position < route[0]) {
                    cameras++;
                    position = route[1];
                }
            }
            return cameras;
        }
}