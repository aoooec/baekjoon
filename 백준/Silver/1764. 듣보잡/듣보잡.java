import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		//1014
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 1~500000
		int M = Integer.parseInt(st.nextToken());
		Set<String> set = new HashSet<String>();
		ArrayList<String> person = new ArrayList<String>();
		for(int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		for(int i = 0; i < M; i++) {
			String name = br.readLine();
			if(set.contains(name)) {
				person.add(name);
			}
		}
		Collections.sort(person);
		sb.append(person.size());
		for(String name: person) {
			sb.append("\n").append(name);
		}
		System.out.print(sb.toString());
	}
}
