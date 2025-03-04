class Solution {
    public int[] solution(int[] num_list, int n) {
        int cnt = num_list.length - n;
        int[] answer = new int[cnt+1];
        for(int i = 0; i <= cnt; i++) {
            answer[i] = num_list[n+i-1];
        }
        return answer;
    }
}