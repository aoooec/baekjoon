import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static int ans;

	public static void main(String[] args) throws Exception {
		// 1000 -1006
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()); 
		for(int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());
			ans = 0;
			perm(n);
			sb.append(ans).append("\n");
		}
		System.out.print(sb.toString());
	}

	private static void perm(int n) {
		if(n == 0) {
			ans++;
			return;
		} else if (n < 0) return;
		
		for(int i = 1; i <= 3; i++) {
			if(n - i >= 0) perm(n - i);
		}
	}
}
