import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception {
		//1038 - 1046
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken()); // 1 ~ 5000 (K <= N) 
		int K = Integer.parseInt(st.nextToken()); // 1 ~ 5000 
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 1; i <= N; i++) {
			q.add(i);
		}
		sb.append("<");
		while(!q.isEmpty()) {
			if(q.size() == 1) {
				sb.append(q.poll());
				break;
			}
			for(int i = 0; i < K - 1; i++) {
				q.add(q.poll());				
			}
			sb.append(q.poll()).append(", ");
		}
		sb.append(">");
		System.out.print(sb.toString());
	}
}