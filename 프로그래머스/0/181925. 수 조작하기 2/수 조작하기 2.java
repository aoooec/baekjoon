class Solution {
    public String solution(int[] numLog) {
        StringBuilder sb = new StringBuilder();
        int num = numLog[0];
        for(int i = 1; i < numLog.length; i++) {
            int diff = numLog[i] - num;
            switch(diff) {
                case 1: 
                    sb.append('w'); break;
                case -1:
                    sb.append('s'); break;
                case 10:
                    sb.append('d'); break;
                case -10:
                    sb.append('a'); break;
            }
            num = numLog[i];
        }
        return sb.toString();
    }
}