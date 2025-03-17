import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		// 0856-0925
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()); // tc
		for(int tc = 0; tc < T; tc++) {
			Queue<Doc> q = new LinkedList<Doc>();
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // 1~100, 문서의 개수
			int M = Integer.parseInt(st.nextToken()); // 0~N, 출력 순서를 맞춰야 하는 문서
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++) {
				int temp = Integer.parseInt(st.nextToken());
				q.add(new Doc(temp, i));
				pq.add(temp);
			}
			int cnt = 0;
			while(true) {
				Doc temp = q.poll();
				int max = pq.peek();
				if(max == temp.importance && temp.idx == M) {
					break;
				} else if (max == temp.importance) {
					pq.poll();
					cnt++;
				} else if (max > temp.importance) {
					q.add(temp);
				}
			}
			sb.append(cnt+1).append("\n");
		}
		System.out.print(sb.toString());
	}
}

class Doc {
	int importance;
	int idx;
	public Doc() {
	}
	public Doc(int importance, int idx) {
		super();
		this.importance = importance;
		this.idx = idx;
	}
}