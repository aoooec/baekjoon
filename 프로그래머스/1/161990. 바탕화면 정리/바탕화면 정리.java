class Solution {
    public int[] solution(String[] wallpaper) { 
        int clength = wallpaper[0].length();
        int rlength = wallpaper.length;
        int lux = rlength;
        int rdx = 0;
        int luy = clength;
        int rdy = 0;
        for(int i = 0; i < rlength; i++) {
            for(int j = 0; j < clength; j++) {
                char c = wallpaper[i].charAt(j);
                if(c == '#') {
                    lux = Math.min(lux, i);
                    rdx = Math.max(rdx, i);
                    luy = Math.min(luy, j);
                    rdy = Math.max(rdy, j);
                }
            }
        }
        int[] answer = {lux, luy, rdx+1, rdy+1};
        
        return answer;
    }
}