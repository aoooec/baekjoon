class Solution {
    public int[] solution(int[] num_list, int n) {
        int cnt = 0;
        int[] arr = new int[num_list.length];
        for(int i = n; i < num_list.length; i++) {
            arr[cnt++] = num_list[i];
        }
        for(int i = 0, idx = cnt; i < num_list.length - cnt; i++) {
            arr[idx++] = num_list[i];
        }
        return arr;
    }
}