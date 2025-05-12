import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 1~100000
		int cnt = 0;
		Set<String> set = new HashSet<>();
		for(int t = 0; t < N; t++) {
			String input = br.readLine();
			if(input.equals("ENTER")) set.clear();
			else if(set.add(input)) cnt++;
		}
		System.out.print(cnt);
	}
}
