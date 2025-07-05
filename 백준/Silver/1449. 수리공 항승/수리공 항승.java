import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] leaks = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            leaks[i] =Integer.parseInt(st.nextToken());
        }

        Arrays.sort(leaks);

        int count = 0; 
        double end = 0;

        for (int i = 0; i < N; i++) {
            double start = leaks[i] - 0.5;
            if (start >= end) {
                end = start + L;
                count++;
            }
        }

        System.out.print(count);
    }
}