import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		// 1703-1719
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]); // 1~10, 동전 종류
		int K = Integer.parseInt(input[1]); // 1~100000000, 만들 합 
		int[] coin = new int[N]; 
		for(int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		int cnt = 0;
		for(int i = N-1; i >= 0; i--) {
			if(K - coin[i] >= 0) {
				cnt += K/coin[i];
				K = K%coin[i];
			}
		}
  		System.out.print(cnt);
	}
}
