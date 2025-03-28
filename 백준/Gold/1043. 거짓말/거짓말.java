import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static int[] p;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 1~50, 노드
		int M = Integer.parseInt(st.nextToken()); // 1~50, 파티 수
		p = new int[N+1]; // 0 안씀, 대표 
		for(int i = 1; i <= N; i++) p[i] = i; // 대표를 자기 자신으로 초기화 
		st = new StringTokenizer(br.readLine(), " "); 
		int num = Integer.parseInt(st.nextToken()); // 0~50, 진실을 아는 사람 수 
		for(int i = 0; i < num; i++) {
			p[Integer.parseInt(st.nextToken())] = 0; // 진실을 아는 사람을 0번 집합으로 
		}
		List<Integer>[] parties = new ArrayList[M]; // 각 파티를 담을 큐
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int pp = Integer.parseInt(st.nextToken()); // 파티에 참여하는 사람 수, 1~50
			List<Integer> list = new ArrayList<Integer>(); 
			for(int j = 0; j < pp; j++) {
				list.add(Integer.parseInt(st.nextToken())); // 파티에 참석하는 사람들 삽입 
			}
			parties[i] = list;
		}
		for(List<Integer> party: parties) {
			int first = findSet(party.get(0));
			for(int i = 1; i < party.size(); i++) {
				union(first, findSet(party.get(i)));
			}
		}
		int cnt = 0;
		int kSet = findSet(0); 
		for(List<Integer> party: parties) {
			boolean isOk = true;
			for(int i = 0; i < party.size(); i++) {
				if(kSet == findSet(party.get(i))) {
					isOk = false;
					break;
				}
			}
			if(isOk) cnt++;
		}
		System.out.println(cnt);
	}

	private static void union(int x, int y) {
		p[y] = x;
	}

	private static int findSet(Integer x) {
		if(p[x] != x) p[x] = findSet(p[x]);
		return p[x];
	}
}
