import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0, j = 1, k = n - 1; i < 2 * n - 1; i++) {
            for(int blank = k; blank > 0; blank--) {
                bw.write(" ");
            }
            for(int star = j; star > 0; star--) {
                bw.write("*");
            }
            if(i > n - 2) {
                j -= 2;
                k++;
            } else {
                j += 2;
                k--;
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}