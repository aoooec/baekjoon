class Solution {
    public String[] solution(String[] names) {
        int num = names.length % 5 == 0 ? names.length / 5 : names.length / 5 + 1;
        String[] first = new String[num];
        for(int i = 0, idx = 0; i < names.length; i += 5) {
            first[idx++] = names[i];
        }
        return first;
    }
}