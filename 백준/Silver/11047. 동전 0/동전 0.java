import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int min;
	private static int[] coin;
	public static void main(String[] args) throws Exception {
		// 1703-1719
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]); // 1~10, 동전 종류
		int K = Integer.parseInt(input[1]); // 1~100000000, 만들 합 
		coin = new int[N]; 
		for(int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		min = K;
		comb(0, N-1, K);
		System.out.print(min);
	}
	
//	static void comb(int cnt, int idx, int rest) {
//		if(cnt >= min) return;
//		if(rest == 0) {
//			min = Math.min(min, cnt);
//			return;
//		}
//		if(idx < 0) return;
//		
//		if(rest - coin[idx] >= 0) comb(cnt+1, idx, rest-coin[idx]);
//		else comb(cnt, idx-1, rest);
//	}
	static void comb(int cnt, int idx, int rest) {
		if(cnt >= min) return;
		if(rest == 0) {
			min = Math.min(min, cnt);
			return;
		}
		if(idx < 0) return;
		
		if(rest - coin[idx] >= 0) comb(cnt+(rest/coin[idx]), idx-1, rest%coin[idx]);
		else comb(cnt, idx-1, rest);
	}
}
