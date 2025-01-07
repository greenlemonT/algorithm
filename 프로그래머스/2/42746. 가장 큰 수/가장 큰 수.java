import java.util.*; 

class Solution {
        public String solution(int[] numbers) {

            String[] numStrings = Arrays.stream(numbers)
                    .mapToObj(String::valueOf)
                    .toArray(String[]::new);

            //내림차순
            Arrays.sort(numStrings, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

            String result = String.join("", numStrings);

            if (result.startsWith("0")) {
                return "0";
            }
            return result;
        }
    }
