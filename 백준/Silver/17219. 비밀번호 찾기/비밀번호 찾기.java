import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken()); // 1~100000, 사이트 주소 수 
		int M = Integer.parseInt(st.nextToken()); // 1~100000, 찾아야하는 비밀번호 수
		Map<String, String> map = new HashMap<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			map.put(st.nextToken(), st.nextToken());
		}
		for(int i = 0; i < M; i++) {
			sb.append(map.get(br.readLine())).append("\n");
		}
		System.out.print(sb.toString());
	}
}
