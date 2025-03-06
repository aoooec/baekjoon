
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<Integer>();
		int n = Integer.parseInt(br.readLine());
		int cnt = 1;
		boolean isOk = true;
		
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			
			while(cnt <= num) {
				stack.push(cnt++);
				sb.append("+\n");
			}
			
			if(!stack.isEmpty() && stack.peek() == num) {
				stack.pop();
				sb.append("-\n");
			} else {
				isOk = false;
				break;
			}
		}
		if(isOk) System.out.print(sb.toString());
		else System.out.print("NO");
	}
}
