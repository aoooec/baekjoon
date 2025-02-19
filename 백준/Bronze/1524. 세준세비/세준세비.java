import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()); // <= 100
		PriorityQueue<Integer> SJ = new PriorityQueue<>();
		PriorityQueue<Integer> SB = new PriorityQueue<>();
		
		for(int tc = 0; tc < T; tc++) {
			br.readLine(); // 줄바꿈 넘김
			SJ.clear(); // 초기화 
			SB.clear();
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 세준의 병사 <= 1,000,000
			int M = Integer.parseInt(st.nextToken()); // 세비의 병사 
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) SJ.offer(Integer.parseInt(st.nextToken()));
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) SB.offer(Integer.parseInt(st.nextToken()));
			while(!SB.isEmpty() && !SJ.isEmpty()) {
				int s = SJ.peek();
				int b = SB.peek();
				if(s < b) SJ.poll();
				else if (s >= b) SB.poll();
			}
			sb.append(SB.isEmpty() ? "S" : "B").append("\n");
		}
		System.out.println(sb.toString());
	}
}