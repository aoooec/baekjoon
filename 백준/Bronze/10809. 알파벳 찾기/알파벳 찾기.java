import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = br.readLine();
		Set<Character> alp = new HashSet<Character>();
		int[] arr = new int[26];
		Arrays.fill(arr, -1); // 모든 값을 -1로 초기화 
		for(int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if(alp.contains(c)) continue;
			alp.add(c);
			arr[c - 'a'] = i;
			
		}
		for(int cnt: arr) {
			sb.append(cnt).append(" ");
		}
		System.out.println(sb.toString());
	}
}