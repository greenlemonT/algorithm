import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        List<Integer> list = new ArrayList<>();
        for (String time : timetable) {
            list.add(toMinute(time));
        }

        Collections.sort(list);

        int busTime = toMinute("09:00");
        int crewIndex = 0;

        int lastCrewTime = 0;
        int lastBusTime = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            count = 0;
            lastCrewTime = -1; 

            while (crewIndex < list.size() && count < m && list.get(crewIndex) <= busTime) {
                lastCrewTime = list.get(crewIndex);
                count++;
                crewIndex++;
            }
            busTime += t;
        }

        int conTime;
        if (count == m) {
            conTime = lastCrewTime - 1;
        } else {
            conTime = busTime - t;
        }

        return toTime(conTime);
    }

    private int toMinute(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    private String toTime(int minutes) {
        int hour = minutes / 60;
        int minute = minutes % 60;
        return String.format("%02d:%02d", hour, minute);
    }
}
