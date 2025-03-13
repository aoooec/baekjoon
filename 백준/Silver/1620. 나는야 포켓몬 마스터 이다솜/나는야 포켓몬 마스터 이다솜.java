import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		Map<Integer, String> mapName = new HashMap<Integer, String>(); 
		Map<String, Integer> mapNum = new HashMap<String, Integer>(); 
		for(int n = 1; n <= N; n++) {
			String name = br.readLine();
			mapName.put(n, name);
			mapNum.put(name, n);
		}
		for(int m = 0; m < M; m++) {
			String q = br.readLine();
			if(q.charAt(0) >= 48 && q.charAt(0) <= 57) {
				int num = Integer.parseInt(q);
				sb.append(mapName.get(num));
			} else {
				sb.append(mapNum.get(q));
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}
