import java.util.*;

//bfs : while(!q.isEmpty()){}, 한글자만 다른지 판별함수
//단어와 count같이 저장 : class Node
class Solution {
    public int solution(String begin, String target, String[] words) {
        Queue<Node> q= new LinkedList<>();
        Set<String> set=new HashSet<>();
        
        q.offer(new Node(begin,0));
        set.add(begin);
        
        while(!q.isEmpty()){
            Node current=q.poll();
            
            if(current.word.equals(target)){
                return current.count;
            }
            for(String word:words){
                if(!set.contains(word)&&check(current.word,word)){
                    q.offer(new Node(word,current.count+1));
                    set.add(word);
                }
            }
            
        }
        return 0;
    }

    private boolean check(String word1, String word2){
        int count=0;
        for(int i=0;i<word1.length();i++){
            if(word1.charAt(i)!=word2.charAt(i)){
                count++;
                if(count>1){
                    return false;
                }
            }        }
        return count==1;
    }
    
    static class Node{
        String word;
        int count;
        
        Node(String word,int count){
            this.word=word;
            this.count=count;
        }
    }
}