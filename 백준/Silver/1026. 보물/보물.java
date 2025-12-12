import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st2.nextToken());
        }
        Arrays.sort(A);
        Integer[] bBox = new Integer[N];
        for(int i = 0; i < N; i++) bBox[i] = B[i];
        Arrays.sort(bBox, Collections.reverseOrder());

        int sum = 0;
        for(int i = 0; i < N; i++) {
            sum += A[i] * bBox[i];
        }
        System.out.print(sum);
    }
}
