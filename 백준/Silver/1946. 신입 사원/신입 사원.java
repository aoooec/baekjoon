import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[a - 1] = b;
			}
			int cnt = 1;
			int rating = arr[0];
			for(int i = 1; i < N; i++) {
				if(rating > arr[i]) {
					cnt++;
					rating = arr[i];
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.print(sb.toString());
				
	}
}
