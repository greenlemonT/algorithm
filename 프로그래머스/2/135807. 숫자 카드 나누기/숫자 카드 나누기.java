
public class Solution {
        public int solution(int[] arrayA, int[] arrayB) {
            int gcdA = calculate(arrayA);
            int gcdB = calculate(arrayB);

            int maxA = isValid(gcdA, arrayB) ? gcdA : 0;
            int maxB = isValid(gcdB, arrayA) ? gcdB : 0;

            return Math.max(maxA, maxB);
        }

        private int calculate(int[] array) {
            int gcd = array[0];
            for (int num : array) {
                gcd = gcd(gcd, num);
                if (gcd == 1) break;
            }
            return gcd;
        }

        private int gcd(int a, int b) {
            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }

        private boolean isValid(int gcd, int[] array) {
            for (int num : array) {
                if (num % gcd == 0) {
                    return false;
                }
            }
            return true;
        }
    }


