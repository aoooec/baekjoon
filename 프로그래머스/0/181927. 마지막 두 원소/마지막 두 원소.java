class Solution {
    public int[] solution(int[] num_list) {
        int length = num_list.length;
        int[] arr = new int[length + 1];
        for(int i = 0; i < length; i++) {
            arr[i] = num_list[i];
        }
        int a = num_list[length - 1];
        int b = num_list[length - 2];
        if(a > b) arr[length] = a - b;
        else arr[length] = a *= 2;
        return arr;
    }
}