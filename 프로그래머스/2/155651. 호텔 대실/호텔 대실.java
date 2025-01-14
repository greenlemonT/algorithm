import java.util.*;

public class Solution {
    public int solution(String[][] book_time) {
        List<int[]> times = new ArrayList<>();
        for (String[] time : book_time) {
            int start = convert(time[0]);
            int end = convert(time[1]) + 10;
            times.add(new int[]{start, end});
        }

        times.sort(Comparator.comparingInt(a -> a[0]));
        Queue<Integer> room = new PriorityQueue<>();
        for (int[] time : times) {
            int start = time[0];
            int end = time[1];
            if (!room.isEmpty() && room.peek() <= start) {
                    room.poll();
            }
            room.add(end);
        }
        return room.size();
    }
    private int convert(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }

}
