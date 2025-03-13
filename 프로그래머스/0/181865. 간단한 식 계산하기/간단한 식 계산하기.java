class Solution {
    public int solution(String binomial) {
        String[] input = binomial.split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[2]);
        char op = input[1].charAt(0);
        switch(op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
        }
        return 0;
    }
}