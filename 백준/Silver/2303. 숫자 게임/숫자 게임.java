import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()); // 1~1000
        int ans = -1;
        int max = 0;
        int[][] map = new int[N][5];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < N; i++) {
            int tmpM = 0;
            for(int x = 0; x < 5; x++) {
                for(int y = x + 1; y < 5; y++) {
                    for(int z = y + 1; z < 5; z++) {
                        int sum = map[i][x] + map[i][y] + map[i][z];
                        int num = sum % 10;
                        tmpM = Math.max(tmpM, num);
                    }
                }
            }
            if(tmpM > max || (tmpM == max && i > ans)) {
                max = tmpM;
                ans = i;
            }
        }
        System.out.print(ans+1);
    }
}