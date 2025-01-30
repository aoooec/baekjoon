import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for(int A = 2; A <= N; A += 2) {
            for (int B = 1; B <= N; B++) {
                int C = N - (A + B);
                if (C > 0 && C >= B + 2) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}