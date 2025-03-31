import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		for(int i = a; i <= b; i++) {
			if(i == 1) continue;
			int sq = (int) Math.sqrt(i);
			boolean isOk = true;
			for(int j = 2; j <= sq && j < i; j++) {
				if(i % j == 0) {
					isOk = false;
					break;
				}
			}
			if(isOk) sb.append(i).append("\n");
		}
		System.out.print(sb.toString());
	}
}
