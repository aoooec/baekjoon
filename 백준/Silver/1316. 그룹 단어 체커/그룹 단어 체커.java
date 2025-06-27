import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 1~100
		int cnt = 0;
		Set<Character> set = new HashSet<Character>();
		for(int w = 0; w < N; w++) {
			set.clear();
			String word = br.readLine();
			int length = word.length();
			boolean isOk = true;
			char base = word.charAt(0);
			set.add(base);
			for(int i = 1; i < length; i++) {
				char tmp = word.charAt(i);
				if(base != tmp) {
					if(!set.add(tmp)) {
						isOk = false;
						break;
					}
					base = tmp;
				}
			}
			if(isOk) cnt++;
		}
		System.out.print(cnt);
	}
}
