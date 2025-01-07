import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];

        // 스택 대신 배열로 인덱스를 저장
        int[] stack = new int[n];
        int top = -1; // 스택의 최상단 인덱스

        for (int i = 0; i < n; i++) {
            // 스택에 저장된 인덱스의 가격이 현재 가격보다 높다면 떨어진 시점
            while (top >= 0 && prices[stack[top]] > prices[i]) {
                int idx = stack[top--]; // 스택에서 꺼냄
                answer[idx] = i - idx;
            }
            stack[++top] = i; // 현재 인덱스를 스택에 추가
        }

        // 스택에 남아 있는 인덱스 처리 (끝까지 가격이 떨어지지 않은 경우)
        while (top >= 0) {
            int idx = stack[top--];
            answer[idx] = n - idx - 1;
        }

        return answer;
    }
}
