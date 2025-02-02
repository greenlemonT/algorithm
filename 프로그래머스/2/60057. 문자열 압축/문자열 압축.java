import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            String compressed = compress(s, i);
            answer = Math.min(answer, compressed.length());
        }

        return answer;
    }

    private String compress(String s, int unit) {
        StringBuilder compressed = new StringBuilder();
        String prev = s.substring(0, unit);
        int count = 1;

        for (int i = unit; i <= s.length(); i += unit) {
            String curr;
            if (i + unit <= s.length()) {
                curr = s.substring(i, i + unit);
            } else {
                curr = s.substring(i); // 마지막 남은 부분 처리
            }

            if (prev.equals(curr)) {
                count++;
            } else {
                if (count > 1) {
                    compressed.append(count);
                }
                compressed.append(prev);
                prev = curr;
                count = 1;
            }
        }

        // 마지막 남은 문자열 추가
        if (count > 1) {
            compressed.append(count);
        }
        compressed.append(prev);

        return compressed.toString();
    }
}
