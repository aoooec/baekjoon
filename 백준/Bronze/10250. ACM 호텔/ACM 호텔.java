import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine()); // TestCase
        for(int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken()); // 호텔의 층수 1 ~ 99
            int W = Integer.parseInt(st.nextToken()); // 한 층의 방 개수 1 ~ 99
            int N = Integer.parseInt(st.nextToken()); // 손님 번호(N번째 손님) 1 ~ H*W
            int floor = N % H == 0 ? H : N % H;
            int room = (N - 1) / H + 1;
            sb.append(floor).append(String.format("%02d", room)).append("\n");
        } // end of test case
        System.out.print(sb.toString());
    } // end of main
} // end of class