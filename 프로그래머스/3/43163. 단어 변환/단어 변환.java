import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        Queue<String> queue = new LinkedList<>(); 
        Set<String> set = new HashSet<>(Arrays.asList(words)); 

        if(!set.contains(target)){
            return 0;
        }

        queue.offer(begin);
        set.remove(begin);

        while (!queue.isEmpty()){
            for (int i=0; i<queue.size(); i++){
                String current = queue.poll();

                if (current.equals(target)){
                    return answer;
                }
                
                for (String word : set.toArray(new String[set.size()])){
                    if(canConvert(current,word)){
                        queue.offer(word);
                        set.remove(word);
                    }
                }
            }

            answer++;
        }

        return 0;
    }

    private boolean canConvert(String word1, String word2){
        int diffCnt = 0;
        for (int i = 0; i<word1.length(); i++){
            if (word1.charAt(i) != word2.charAt(i)){
                diffCnt++;
            }
        }
        return diffCnt ==1;
    }
}