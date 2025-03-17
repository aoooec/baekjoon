import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		// 0928-0937
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken()); // 1 ~ 1000, K <= N
		int K = Integer.parseInt(st.nextToken()); // 1 ~ 1000
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 1; i <= N; i++) {
			q.add(i);
		}
		sb.append("<");
		int cnt = 0;
		while(true) {
			int temp = q.poll();
			cnt++;
			if(q.isEmpty()) {
				sb.append(temp);
				break;
			}
			else if (cnt == K) {
				sb.append(temp).append(", ");
				cnt = 0;
			} else q.add(temp);
		}
		sb.append(">");
		System.out.print(sb.toString());
	}
}