import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int h, w, ans;
	private static char[][] map;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	private static boolean[] keys;
	private static boolean isOpen, isGet;
	private static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()); // tc 수
		for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			h = Integer.parseInt(st.nextToken()); // 높이 
			w = Integer.parseInt(st.nextToken()); // 너비, 2~100
			map = new char[h][w]; // 평면도
			keys = new boolean[26]; // 키 존재 여부 확인 
			List<int[]> entrance = new ArrayList<int[]>(); // 입구 위치 저장 \
			ans = 0; // 정답 수 초기화 
			// 평면도 채우기 & 가장자리 체크 
			for(int i = 0; i < h; i++) {
				String input = br.readLine();
				for(int j = 0; j < w; j++) {
					map[i][j] = input.charAt(j);
					// 가장자리가 벽이 아닌 경우
					if(map[i][j] != '*' && (i == 0 || j == 0 || i == h-1 || j == w-1)) {
						if(map[i][j] == '$') { // 문서인 경우
							ans++;
							map[i][j] = '.'; // 찾은 문서 수를 더하고 바로 빈칸으로 만든다
						} else if ('a' <= map[i][j] && map[i][j] <='z') {
							// 키일 경우 (a~z) 키 배열에 담음 
							keys[map[i][j] - 'a'] = true;
							map[i][j] = '.';
						}
						entrance.add(new int[] {i, j}); // 들어갈 수 있는 입구 저장 
					}
				}
			}
			String ownKeys = br.readLine();
			// 기존에 가지고 있는 key 목록을 업데이트 
			if(ownKeys.charAt(0) != '0') {
				for(int i = 0; i < ownKeys.length(); i++) {
					keys[ownKeys.charAt(i) - 'a'] = true;
				}
			}
			isOpen = false; // 이번 반복문에서 개방한 문이 있는지를 판단하는 flag
			isGet = false; // 이번 반복문에서 새로운 키를 발견했는지를 판단하는 flag
			while(true) {
				visited = new boolean[h][w]; // 방문 체크 배열 초기화 
				for(int[] pos: entrance) {
					// 입구를 순회
					int r = pos[0];
					int c = pos[1];
					if('A' <= map[r][c] && map[r][c] <= 'Z' && keys[map[r][c] - 'A']) {
						// 잠긴 문이고 열쇠가 있는 경우 연다 
						map[r][c] = '.';
					}
					if(map[r][c] == '.') bfs(r, c); // 열린 가장자리만 탐색 시작 
				}
				if(!isOpen && !isGet) break; // 문을 새로 연 적이 없거나 열쇠를 얻지 못하면 반복 종료
				isOpen = false;
				isGet = false;
			}
			sb.append(ans).append("\n");
		}
		System.out.print(sb.toString());
	}

	private static void bfs(int r, int c) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.add(new int[] {r, c});
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			for(int d = 0; d < 4; d++) {
				int nr = tmp[0] + dr[d];
				int nc = tmp[1] + dc[d];
				// 범위를 벗어났거나 이미 방문한 곳, 벽인 경우는 패스
				if(nr < 0 || nc < 0 || nr >= h || nc >= w || visited[nr][nc] || map[nr][nc] == '*') {
					continue;
				}
				if(map[nr][nc] == '$') {
					// 문서인 경우 정답 수 추가
					ans++;
					map[nr][nc] = '.';
				} else if('a' <= map[nr][nc] && map[nr][nc] <= 'z') {
					// 키를 찾은 경우 키 배열에 추가
					keys[map[nr][nc] - 'a'] = true;
					map[nr][nc] = '.';
					isGet = true; // 플래그 변경 
				} else if('A' <= map[nr][nc] && map[nr][nc] <= 'Z') {
					// 잠긴 문인 경우 
					if(!keys[map[nr][nc] - 'A']) continue; // 열쇠가 없으면 패스
					map[nr][nc] = '.'; // 있는 경우 문을 열고 
					isOpen = true; // 플래그 변경 
				} 
				visited[nr][nc] = true;
				q.add(new int[] {nr, nc}); // 방문 체크 후 큐에 추가 
			}
		}
	}
}
