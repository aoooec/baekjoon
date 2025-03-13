import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		// 0945-0955
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[21];
		int M = Integer.parseInt(br.readLine()); // 1 ~ 3000000
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = 0;
			switch(st.nextToken()) {
			case "add":
				x = Integer.parseInt(st.nextToken());
				arr[x]++;
				break;
			case "remove":
				x = Integer.parseInt(st.nextToken());
				if(arr[x] > 0) arr[x]--;
				break;
			case "check":
				x = Integer.parseInt(st.nextToken());
				sb.append(arr[x] > 0 ? 1 : 0).append("\n");
				break;
			case "toggle":
				x = Integer.parseInt(st.nextToken());
				if(arr[x] > 0) arr[x]--;
				else arr[x]++;
				break;
			case "all":
				for(int i = 1; i <= 20; i++) arr[i] = 1;
				break;
			case "empty":
				for(int i = 1; i <= 20; i++) arr[i] = 0;
				break;
			}
		}
		System.out.print(sb.toString());
	}
}
