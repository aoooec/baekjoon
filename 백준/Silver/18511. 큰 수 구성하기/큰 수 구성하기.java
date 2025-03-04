import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int max;
	static int K;
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 10~100000000
		K = Integer.parseInt(st.nextToken()); // 원소의 개수, 1~3
		arr = new int[K];
		Arrays.sort(arr);
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		getMaxNum(0);
		System.out.print(max);
	}
	
	static void getMaxNum(int num) {
		if(num > N) return;
		if(max < num) max = num;
		for(int i = K-1; i >= 0; i--) {
			getMaxNum(num*10 + arr[i]);
		}
	}
}