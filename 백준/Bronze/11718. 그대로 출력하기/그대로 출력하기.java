import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = br.readLine();
		while(input != null) {
			sb.append(input).append("\n");
			input = br.readLine();
		}
		System.out.print(sb.toString());
	}
}