import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toUpperCase().toCharArray();
        int[] count = new int[26];
        int[] max = new int[2];
        int[] prev = new int[2];

        for (int i = 0; i < input.length; i++) {
            char c = input[i];
            int idx = c - 'A';
            if (++count[idx] >= max[1]) {
                prev[0] = max[0];
                prev[1] = max[1];
                max[0] = idx;
                max[1] = count[idx];
            }
        }

        System.out.print(prev[1] == max[1] ? "?" : (char)(max[0] + 'A'));
    }
}
