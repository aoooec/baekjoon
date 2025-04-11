import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	private static Map<String, Integer> map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());
			map = new HashMap<String, Integer>();
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				st.nextToken();
				String key = st.nextToken();
				map.put(key, map.getOrDefault(key, 0) + 1);
			}
			int ans = 1;
			for(String key: map.keySet()) {
				ans *= (map.get(key) + 1);
			}
			sb.append(ans - 1).append("\n");
		}
		System.out.print(sb.toString());
	}
}
