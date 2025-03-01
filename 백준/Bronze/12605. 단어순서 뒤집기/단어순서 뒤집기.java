import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Stack<String> stack = new Stack<String>();
		for(int tc = 1; tc <= N; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			while(st.hasMoreTokens()) {
				stack.add(st.nextToken());
			}
			sb.append("Case #").append(tc).append(": ");
			while(!stack.isEmpty()) {
				sb.append(stack.pop()).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}
