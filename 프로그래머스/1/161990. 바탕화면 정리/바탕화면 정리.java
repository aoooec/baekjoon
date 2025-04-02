class Solution {
    public int[] solution(String[] wallpaper) { 
        int rlength = wallpaper[0].length();
        int clength = wallpaper.length;
        int lux = clength;
        int rdx = 0;
        int luy = rlength;
        int rdy = 0;
        for(int i = 0; i < clength; i++) {
            for(int j = 0; j < rlength; j++) {
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