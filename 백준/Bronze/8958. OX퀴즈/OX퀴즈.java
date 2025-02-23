import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()); // tc
		for(int tc = 0; tc < T; tc++) {
			int cnt = 1;
			int sum = 0;
			String ox = br.readLine();
			for(int i = 0; i < ox.length(); i++) {
				if(ox.charAt(i) == 'O') sum += cnt++;
				else cnt = 1;
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb.toString());
	}
}