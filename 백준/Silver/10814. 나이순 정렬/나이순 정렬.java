import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine()); // 회원 수 (1~100000)
		int[] userAge = new int[N]; // (1~200)
		String[] userName = new String[N];
		int[] count = new int[201];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			userAge[i] = Integer.parseInt(st.nextToken());
			userName[i] = st.nextToken();
		} // 값 넣기 끝 
		for(int i = 0; i < N; i++) {
			count[userAge[i]]++;
		} // 카운팅 배열 채우기 끝 
		int[] acc = new int[201];
		for(int i = 1; i < 201; i++) {
			acc[i] = acc[i-1] + count[i];
		} // 누적합 배열 
		int[] sortedAge = new int[N];
		String[] sortedName = new String[N];
		for(int i = N-1; i >= 0; i--) {
			sortedAge[--acc[userAge[i]]] = userAge[i];
			sortedName[acc[userAge[i]]] = userName[i];
		}
		for(int i = 0; i < N; i++) {
			sb.append(sortedAge[i]).append(" ").append(sortedName[i]).append("\n");
		}
		System.out.print(sb.toString());
	}
}
