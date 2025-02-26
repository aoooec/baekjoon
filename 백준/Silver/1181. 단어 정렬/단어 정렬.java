import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Set<String> set = new HashSet<String>(); // 중복 제거
		List<String> words = new ArrayList<String>(); // 단어 저장
		
		for(int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		
		words.addAll(set);
		words.sort((a, b) -> a.length() == b.length() ? a.compareTo(b) : a.length() - b.length());
		for(String word: words) {
			sb.append(word).append("\n");
		}
		System.out.print(sb.toString());
	}
}