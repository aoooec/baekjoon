import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());

            if (min > number) {
                min = number;
            }

            if (max < number) {
                max = number;
            }
        }

        bw.write(min + " " + max);
        bw.close();
    }
}