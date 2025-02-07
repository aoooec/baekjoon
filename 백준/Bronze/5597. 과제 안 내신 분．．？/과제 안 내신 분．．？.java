import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] students = new int[30];
        int[] answer = new int[2];

        for(int i = 0; i < 28; i++) {
            students[Integer.parseInt(br.readLine()) - 1] = 1;
        }
        for(int i = 0, cnt = 0; i < 30; i++) {
            if(cnt >= 2) {
                break;
            }
            if(students[i] == 0) {
                answer[cnt] = i + 1;
                cnt++;
            }
        }
        Arrays.sort(answer);

        for(int s: answer) {
            bw.write(s + "\n");
        }

        bw.flush();
        bw.close();
    }
}