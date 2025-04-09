import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), "*");
		String prefix = st.nextToken();
		String suffix = st.nextToken();
		int length = prefix.length() + suffix.length();
		for(int i = 0; i < N; i++) {
			String input = br.readLine();
			if(input.startsWith(prefix) && input.endsWith(suffix) && input.length() >= length) {
				sb.append("DA").append("\n");
			} else sb.append("NE").append("\n");
		}
		System.out.print(sb.toString());
	}
}
