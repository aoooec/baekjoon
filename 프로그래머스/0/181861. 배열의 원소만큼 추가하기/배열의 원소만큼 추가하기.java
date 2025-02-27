class Solution {
    public int[] solution(int[] arr) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        int[] answer = new int[sum];
        for(int i = 0, idx = 0; i < arr.length; i++) {
            int num = arr[i];
            int cnt = num;
            while(cnt-- > 0) {
                answer[idx++] = num; 
            }
        }
        return answer;
    }
}