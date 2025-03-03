class Solution {
    public int[] solution(int[] num_list, int n) {
        int cnt = (num_list.length - 1) / n + 1;
        int[] arr = new int[cnt];
        for(int i = 0, idx = 0; i < num_list.length; i += n) {
            arr[idx++] = num_list[i];
        }
        return arr;
    }
}