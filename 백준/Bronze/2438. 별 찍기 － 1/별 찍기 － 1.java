import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            StringBuilder line = new StringBuilder();
            for(int j = 0; j < i + 1; j++) {
                line.append('*');
            }
            bw.write(line.toString() + "\n");
        }

        bw.flush();
        bw.close();
    }
}