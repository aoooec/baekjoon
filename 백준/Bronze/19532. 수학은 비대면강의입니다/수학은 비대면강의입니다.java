import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[6];

        for(int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int x = -999; x < 1000; x++) {
            for(int y = -999; y < 1000; y++) {
                if(arr[0] * x + arr[1] * y == arr[2]) {
                    if(arr[3] * x + arr[4] * y == arr[5]) {
                        bw.write(x + " " + y);

                        bw.flush();
                        bw.close();
                        return;
                    }
                }
            }
        }
    }
}