import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 카드의 수 (3~100)
		int M = Integer.parseInt(st.nextToken()); // 최대 카드의 합 (10~300000)
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N]; // 카드 배열 
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int sum = Integer.MIN_VALUE;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(i == j) break;
				for(int k = 0; k < N; k++) {
					if(i == k || j == k) break;
					int temp = arr[i] + arr[j] + arr[k];
					if(temp <= M && sum < temp) {
						sum = temp;
					}
				}
			}
		}
		System.out.println(sum);
	}
}