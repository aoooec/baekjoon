class Solution {
    public int[] solution(int n, int k) {
        int[] answer = new int[n/k];
        for(int i = 1, idx = 0; i <= n; i++) {
            if(i%k == 0) answer[idx++] = i;
        }
        return answer;
    }
}