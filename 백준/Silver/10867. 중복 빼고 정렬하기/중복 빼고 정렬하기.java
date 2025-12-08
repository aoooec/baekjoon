import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] arr = new boolean[2001];
        for(int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken()) + 1000;
            if(!arr[n]) arr[n] = true;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 2001; i++) {
            if(arr[i]) sb.append(i - 1000).append(" ");
        }
        System.out.print(sb.toString());
    }
}