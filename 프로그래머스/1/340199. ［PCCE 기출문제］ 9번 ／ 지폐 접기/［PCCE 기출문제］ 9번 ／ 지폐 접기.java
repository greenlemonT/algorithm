//그리디
import java.util.*;

class Solution {
     public int solution(int[] wallet, int[] bill) {
        
        Arrays.sort(wallet);
        Arrays.sort(bill);

        int a = wallet[0], b = wallet[1];
        int c = bill[0], d = bill[1];
        int count = 0;

        
        while (!check(a, b, c, d)) {
            if (d >= c) { 
                d /= 2;
            } else {
                c /= 2;
            }
            count++;

            if (check(a, b, c, d)) break;
        }

        return count;
    }

    private boolean check(int a, int b, int c, int d) {
        return (c <= a && d <= b) || (d <= a && c <= b);
    }
}