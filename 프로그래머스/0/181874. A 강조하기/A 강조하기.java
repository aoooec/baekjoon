class Solution {
    public String solution(String myString) {
        StringBuilder answer = new StringBuilder();
        String replace = myString.replaceAll("a", "A");
        for(int i = 0; i < replace.length(); i++) {
            char c = replace.charAt(i);
            if(c > 'A' && c <= 'Z') {
                answer.append((char) (c + 32));
            } else {
                answer.append(c);
            }
        }
        return answer.toString();
    }
}