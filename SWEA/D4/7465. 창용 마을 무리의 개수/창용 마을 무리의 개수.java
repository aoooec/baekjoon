import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	private static int[] p;
	private static Set<Integer> set;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()); // tc 수
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // 1~100, 사람 수
			int M = Integer.parseInt(st.nextToken()); // 0~N(N-1)/2, 관계 수 
			p = new int[N+1]; // 대표 배열
			for(int i = 1; i <= N; i++) { // 기본값 삽입
				p[i] = i;
			}
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				// 요소 집합끼리 union
				union(findSet(Integer.parseInt(st.nextToken())),findSet(Integer.parseInt(st.nextToken())));
			}
			set = new HashSet<>();
			for(int i = 1; i <= N; i++) set.add(findSet(i)); // 중복 제거
			sb.append("#").append(tc).append(" ").append(set.size()).append("\n");
		} // end of test case
		System.out.print(sb.toString());
	} // end of main

	private static void union(int x, int y) {
		p[y] = x;
	}

	private static int findSet(int x) {
		if(p[x] != x) p[x] = findSet(p[x]);
		return p[x];
	}
} // end of class
 