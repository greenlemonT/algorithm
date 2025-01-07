import java.util.*;

class Solution {
        public int solution(String[][] clothes) {
            Map<String, Integer> clothesMap = new HashMap<>();

            for (String[] cloth : clothes) {
                String type = cloth[1];
                clothesMap.put(type, clothesMap.getOrDefault(type, 0) + 1);
            }

            int combinations = 1;
            for (int count : clothesMap.values()) {
                combinations *= (count + 1);
            }

            return combinations - 1;
        }
    }