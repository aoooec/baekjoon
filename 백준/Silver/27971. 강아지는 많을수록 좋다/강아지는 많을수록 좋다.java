import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static boolean isPossible;
	private static int N;
	private static int[] memo;
	private static int[] d;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		if(B > A) { // A가 더 큰 숫자임을 보장 
			int temp = B;
			B = A;
			A = temp;
		}
		d = new int[] {A, B};
		memo = new int[N+1];
		isPossible = true;
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int L = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			if(R - L > A && R - L > B) {
				isPossible = false;
				break;
			}
			for(int j = L; j <= R; j++) {
				memo[j] = -1;
			}
		}
		
		if(isPossible) {
			bfs();
		}
		System.out.println(memo[N] == 0 ? -1 : memo[N]);
	}

	private static void bfs() {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.add(new int[] {0, 0}); // 현재 위치, 레벨 
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int tmpPos = tmp[0];
			int tmpLv = tmp[1];
			for(int i = 0; i < 2; i++) {
				int nPos = tmpPos + d[i];
				if(nPos > N || memo[nPos] == -1) continue;
				if(memo[nPos] != 0 && memo[nPos] <= tmpLv + 1) continue;
				memo[nPos] = tmpLv + 1;
				q.add(new int[] {nPos, tmpLv + 1});
			}
		}
	}

}
