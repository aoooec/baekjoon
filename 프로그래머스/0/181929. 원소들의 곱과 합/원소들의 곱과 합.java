class Solution {
    public int solution(int[] num_list) {
        int mul = 1;
        int sum = 0;
        for(int a: num_list) {
            mul *= a;
            sum += a;
        }
        return mul < sum*sum ? 1 : 0;
    }
}