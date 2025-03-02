import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()); // test case
		int[] arr = new int[5001]; // 정류장의 수 1 ~ 5000
		for(int tc = 1; tc <= T; tc++) {
			Arrays.fill(arr, 0); // arr reset 
			int N = Integer.parseInt(br.readLine()); // 버스 노선의 수, 1 ~ 500
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken()); // i번째 버스 노선의 start
				int B = Integer.parseInt(st.nextToken()); // i번째 버스 노선의 end
				for(int j = A; j <= B; j++) {
					arr[j]++;
				}   
			} // 모든 정류장을 지나가는 버스의 수 체크
			int P = Integer.parseInt(br.readLine()); // 1 ~ 500
			sb.append("#").append(tc).append(" ");
			for(int i = 0; i < P; i++) {
				sb.append(arr[Integer.parseInt(br.readLine())]).append(" ");
			} // 버스 정류장을 지나가는 버스 노선의 개수 출력 
			sb.append("\n");
		} // end of test case
		System.out.print(sb.toString());
	} // end of main
} // end of class
