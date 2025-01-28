import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int back = 0;
            StringBuilder result = new StringBuilder();

            for(int j = 0; j < 4; j++) {
                if(Integer.parseInt(st.nextToken()) == 1) {
                    back++;
                }
            }

            switch (back) {
                case 0:
                    result.append("D");
                    break;
                case 1:
                    result.append("C");
                    break;
                case 2:
                    result.append("B");
                    break;
                case 3:
                    result.append("A");
                    break;
                case 4:
                    result.append("E");
                    break;
            }

            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
    }
}