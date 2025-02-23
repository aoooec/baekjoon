import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while(true) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			if(A == 0 && B == 0 && C == 0) break;
			sb.append(isRight(A,B,C) ? "right" : "wrong").append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static boolean isRight(int a, int b, int c) {
		return a*a + b*b == c*c || b*b + c*c == a*a || a*a + c*c == b*b;
	}
}