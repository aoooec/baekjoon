import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int s: scoville) pq.add(s);
        
        while(pq.size() > 1) {
            int first = pq.poll();
            if(first >= K) return answer;
            
            int second = pq.poll();
            int mixed = first + (second * 2);
            
            pq.add(mixed);
            answer++;
        }
        
        return pq.peek() >= K ? answer : -1;
    }
}