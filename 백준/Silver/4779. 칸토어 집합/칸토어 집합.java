import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	private static Map<Integer, String> memo = new HashMap<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input;
		while((input = br.readLine()) != null) {
			int N = (int) Math.pow(3, Integer.parseInt(input)); // -의 개수, 3^N, 0~12
			sb.append(rec(N)).append("\n");
		}
		System.out.print(sb.toString());
	}

	static String rec(int n) {
		if(n == 1) return "-";
		
		int num = n/3;
		if (!memo.containsKey(num)) memo.put(num, rec(num));
		String space = new String(new char[num]).replace('\0', ' ');
		
		return memo.get(num) + space + memo.get(num);
	}
}