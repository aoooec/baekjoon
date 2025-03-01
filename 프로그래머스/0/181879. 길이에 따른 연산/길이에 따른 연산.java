class Solution {
    public int solution(int[] num_list) {
        // 0114
        int answer;
        if(num_list.length > 10) {
            answer = 0;
            for(int n: num_list) answer += n;
        } else {
            answer = 1;
            for(int n: num_list) answer *= n;
        }
        return answer;
    }
}