import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] heights = new int[9];
        int sum = 0;
        for(int i = 0; i < 9; i++) {
            heights[i] = Integer.parseInt(br.readLine());
            sum += heights[i];
        }
        int diff = sum - 100;

        int ex1 = -1, ex2 = -1;
        a:
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (heights[i] + heights[j] == diff) {
                    ex1 = i;
                    ex2 = j;
                    break a;
                }
            }
        }

        int[] result = new int[7];
        int idx = 0;
        for (int i = 0; i < 9; i++) {
            if (i == ex1 || i == ex2) continue;
            result[idx++] = heights[i];
        }

        Arrays.sort(result);
        for (int h : result) {
            sb.append(h).append("\n");
        }
        System.out.println(sb.toString());
    }
}