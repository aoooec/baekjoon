class Solution {
    public int[] solution(int[] num_list) {
        int[] countArr = new int[101];
        for(int i = 0; i < num_list.length; i++) {
            countArr[num_list[i]]++;
        }
        int[] answer = new int[5];
        for(int i = 1, cnt = 0; i < countArr.length && cnt < 5; i++) {
            if(countArr[i] == 0) continue;
            while(countArr[i] != 0 && cnt < 5) {
                answer[cnt++] = i;
                countArr[i]--;
            }            
        }
        return answer;
    }
}