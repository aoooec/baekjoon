import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		// 1241 - 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		boolean isVPS;
		for(int tc = 0; tc < T; tc++) {
			isVPS = true;
			String input = br.readLine();
			for(int i = 0; i < input.length(); i++) {
				if(input.charAt(i) == '(') stack.add(1);
				else {
					if(stack.isEmpty()) {
						isVPS = false;
						break;
					}
					stack.pop();
				}
			}
			if(!stack.isEmpty()) {
				isVPS = false;
				while(!stack.isEmpty()) stack.pop();
			}
			sb.append(isVPS ? "YES" : "NO").append("\n");
		}
		System.out.print(sb.toString());
	}
}
