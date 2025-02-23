import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cur = Integer.parseInt(st.nextToken());
		int num = -1;
		if(cur == 8) {
			num = 8;
			while(cur == num) {
				num--;
				cur = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : -1;
			}
			if(num == 0) System.out.println("descending");
			else System.out.println("mixed");
		} else if(cur == 1) {
			num = 1;
			while(cur == num) {
				num++;
				cur = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : -1;
			}
			if(num == 9) System.out.println("ascending");
			else System.out.println("mixed");
		} else {
			System.out.println("mixed");
		}
	}
}