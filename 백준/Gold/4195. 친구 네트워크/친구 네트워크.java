import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	private static int count;
	private static Map<String, Integer> usermap;
	private static int[] p, rank;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()); // tc 수
		while(T-- > 0) {
			int F = Integer.parseInt(br.readLine());
			count = 1;
			usermap = new HashMap<String, Integer>();
			p = new int[200001]; // 관계의 수는 최대 100000 -> 모두 서로소 집합일 경우 사람은 200000
			rank = new int[200001]; // 사람마다의 네트워크 수를 저장  
			for(int i = 1; i <= 200000; i++) { // 초기화 
				p[i] = i;
				rank[i] = 1; 
			}
			for(int i = 0; i < F; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				String a = st.nextToken();
				String b = st.nextToken();
				// 아직 등록되지 않은 유저면 usermap에 등록 
				if(!usermap.containsKey(a)) {
					usermap.put(a, count++);
				}
				if(!usermap.containsKey(b)) {
					usermap.put(b, count++);
				}
				// 유저 index 가져오기 
				int s = usermap.get(a);
				int e = usermap.get(b); 
				// 둘 사이의 네트워크 구하기
				sb.append(union(s, e)).append("\n");
			}
		}
		System.out.print(sb.toString());
	}

	
	private static int findSet(int x) {
		if(p[x] != x) p[x] = findSet(p[x]);
		return p[x];
	}
	
	private static int union(int x, int y) {
		x = findSet(x);
		y = findSet(y); // 둘의 부모를 찾음 
		if(x == y) return rank[x];
		if(x != y) { // 서로소 집합일 경우
			if(x > y) {
				p[x] = y;
				rank[y] += rank[x]; // 네트워크 수 증가 
				return rank[y];
			} else {
				p[y] = x;
				rank[x] += rank[y]; // 네트워크 수 증가 
				return rank[x];
			}
		}
		return 0;
	}
}
