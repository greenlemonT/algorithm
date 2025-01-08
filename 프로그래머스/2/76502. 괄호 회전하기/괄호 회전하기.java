import java.util.*;

class Solution {
    public int solution(String s) {
        int count = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            // 왼쪽으로 i칸 회전
            String rotated = s.substring(i) + s.substring(0, i);
            if (ok(rotated)) {
                count++;
            }
        }

        return count;
    }

    private boolean ok(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (!pair(top, ch)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private boolean pair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '[' && close == ']') ||
                (open == '{' && close == '}');
    }
}
