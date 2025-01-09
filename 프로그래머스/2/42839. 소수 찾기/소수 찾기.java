import java.util.*;

    class Solution {
        public int solution(String numbers) {
            Set<Integer> primes = new HashSet<>();
            char[] digits = numbers.toCharArray();
            boolean[] visited = new boolean[digits.length];

            // 모든 가능한 숫자 조합 생성
            generateNumbers(digits, visited, "", primes);

            // 소수의 개수 반환
            return primes.size();
        }

        private void generateNumbers(char[] digits, boolean[] visited, String current, Set<Integer> primes) {
            // 현재 조합이 숫자인 경우, 소수 여부 확인
            if (!current.isEmpty()) {
                int num = Integer.parseInt(current);
                if (isPrime(num)) {
                    primes.add(num);
                }
            }

            // 모든 숫자에 대해 조합 생성
            for (int i = 0; i < digits.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    generateNumbers(digits, visited, current + digits[i], primes);
                    visited[i] = false;
                }
            }
        }

        private boolean isPrime(int num) {
            if (num < 2) return false;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) return false;
            }
            return true;
        }
    }



