import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		// 0945-0955
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int bit = 0;
		int M = Integer.parseInt(br.readLine()); // 1 ~ 3000000
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = 0;
			switch(st.nextToken()) {
			case "add":
				x = Integer.parseInt(st.nextToken());
				if((bit & (1 << x)) == 0) bit = bit | (1 << x); 
				break;
			case "remove":
				x = Integer.parseInt(st.nextToken());
				if((bit & (1 << x)) != 0) bit = bit & ~(1 << x);
				break;
			case "check":
				x = Integer.parseInt(st.nextToken());
				sb.append((bit & (1 << x)) != 0 ? 1 : 0).append("\n");
				break;
			case "toggle":
				x = Integer.parseInt(st.nextToken());
				bit = bit ^ (1 << x);
				break;
			case "all":
				bit = (1 << 21) - 1;
				break;
			case "empty":
				bit = 0;
				break;
			}
		}
		System.out.print(sb.toString());
	}
}
