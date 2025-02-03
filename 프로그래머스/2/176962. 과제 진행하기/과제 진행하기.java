import java.util.*;


class Solution {
    public String[] solution(String[][] plans) {
        // 1. 시작 시간 기준 정렬
        Arrays.sort(plans, (a, b) -> Integer.compare(change(a[1]), change(b[1])));

        // 2. 가장 최근에 멈춘 과제부터 처리
        Stack<String[]> stop = new Stack<>();
        List<String> complete = new ArrayList<>();

        int currentTime = 0;
        for (int i = 0; i < plans.length; i++) {
            String name = plans[i][0];
            int start = change(plans[i][1]);
            int playTime = Integer.parseInt(plans[i][2]);

            // 멈춰있던 과제 시작
            while (!stop.isEmpty() && currentTime < start) {
                String[] prevTask = stop.pop();
                int remainingTime = Integer.parseInt(prevTask[2]);

                // 이전 과제를 끝낼 시간이 충분한지 확인
                if (currentTime + remainingTime <= start) {
                    currentTime += remainingTime;
                    complete.add(prevTask[0]);
                } else {
                    prevTask[2] = String.valueOf(remainingTime - (start - currentTime));
                    stop.push(prevTask);
                    currentTime = start;
                }
            }

            // 새로운 과제 시작
            currentTime = start;
            if (i < plans.length - 1) {
                int nextStart = change(plans[i + 1][1]);

                if (currentTime + playTime <= nextStart) {
                    complete.add(name);
                    currentTime += playTime;
                } else {
                    plans[i][2] = String.valueOf(playTime - (nextStart - currentTime));
                    stop.push(plans[i]);
                    currentTime = nextStart;
                }
            } else {
                complete.add(name);
                currentTime += playTime;
            }
        }

        // 4. 남아있는 멈춘 과제 처리
        while (!stop.isEmpty()) {
            complete.add(stop.pop()[0]);
        }

        return complete.toArray(new String[0]);
    }

    // 5. 시간 변환 함수 (hh:mm -> 분 단위)
    private int change(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }
}
