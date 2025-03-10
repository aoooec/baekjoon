class Solution {
    public int solution(int a, int b) {
        int op = Integer.parseInt(String.valueOf(a) + String.valueOf(b));
        return Math.max(op, 2 * a * b);
    }
}