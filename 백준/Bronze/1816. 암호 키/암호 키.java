import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            long s = Long.parseLong(br.readLine());

            for(int j = 2; j < 1000002; j++) {
                if (s % j == 0) {
                    bw.write("NO" + "\n");
                    break;
                }

                if (j == 1000001) {
                    bw.write("YES"+ "\n");
                }
            }
        }

        bw.flush();
        bw.close();
    }
}