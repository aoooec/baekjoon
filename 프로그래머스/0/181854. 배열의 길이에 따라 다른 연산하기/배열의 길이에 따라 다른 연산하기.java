class Solution {
    public int[] solution(int[] arr, int n) {
        int[] answer = arr.clone();
        for(int i = arr.length % 2 == 0 ? 1 : 0; i < arr.length; i += 2) {
            answer[i] += n;
        }
        return answer;
    }
}