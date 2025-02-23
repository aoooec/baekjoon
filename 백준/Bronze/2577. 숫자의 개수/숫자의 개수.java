import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		String num = String.valueOf(A*B*C);
		int[] arr = new int[10];
		for(int i = 0; i < num.length(); i++) {
			arr[num.charAt(i) - '0']++;
		}
		for(int i = 0; i < 10; i++) {
			sb.append(arr[i]).append("\n");
		}
		System.out.println(sb.toString());
	}
}