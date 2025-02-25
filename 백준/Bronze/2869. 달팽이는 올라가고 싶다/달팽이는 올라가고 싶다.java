import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken()); // 올라갈 수 있는 높이 
		int B = Integer.parseInt(st.nextToken()); // 밤에 내려오는 높이 
		int V = Integer.parseInt(st.nextToken()); // 나무막대의 길이
		int cnt = (V - B) % (A - B) != 0 ? (V - B) / (A - B) + 1 : (V - B) / (A - B);
		
		System.out.print(cnt);
	}
}
