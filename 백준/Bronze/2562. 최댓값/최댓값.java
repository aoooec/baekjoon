import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int max = Integer.MIN_VALUE;
        int idx = 0;

        for (int i = 0; i < 9; i++) {
            int num = Integer.parseInt(br.readLine());

            if (max < num) {
                max = num;
                idx = i + 1;
            }
        }

        bw.write(max + "\n" + idx);
        bw.flush();
        bw.close();
    }
}