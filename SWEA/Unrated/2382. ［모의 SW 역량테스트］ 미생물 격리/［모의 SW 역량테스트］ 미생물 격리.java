import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	private static int N, M, K;
	private static int[][] micros;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine()); // 전체 TC
		for (int test = 1; test <= TC; test++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			micros = new int[K][4];
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				micros[i][0] = Integer.parseInt(st.nextToken()); // 세로 위치 [0]
				micros[i][1] = Integer.parseInt(st.nextToken()); // 가로 위치 [1]
				micros[i][2] = Integer.parseInt(st.nextToken()); // 미생물 수 [2]
				micros[i][3] = Integer.parseInt(st.nextToken()) - 1; // 이동 방향 [3]
			}
			for(int i = 0; i < M; i++) {
				for(int j = 0; j < K; j++) {
					if(micros[j][2] == 0) continue; // 필요없는 미생물 무리 
					int dir = micros[j][3];
					int nr = micros[j][0] + dr[dir];
					int nc = micros[j][1] + dc[dir];
					
					if(nr == 0 || nr == N-1 || nc == 0 || nc == N-1) { // 약품 구역 밟음 
						micros[j][2] /= 2;
						if(micros[j][2] == 0) continue; // 더 진행할 필요 x
						micros[j][3] = dir % 2 == 0 ? dir + 1 : dir - 1; // 방향 바꿈 
					}
					
					micros[j][0] = nr;
					micros[j][1] = nc; // 해당 요소의 위치를 갱신 
				}
				
				// 이동이 끝난 미생물을 정렬 (위치가 같으면 미생물 수 기준-오름차순-, 같지 않으면 위치 기준)
				Arrays.sort(micros, (o1, o2) -> {
					if(o1[0] == o2[0] && o1[1] == o2[1]) {
						return o2[2] - o1[2];
					}
					return (o1[0] * N + o1[1]) - (o2[0] * N + o2[1]);
				});
				
				for(int j = 0; j < K - 1; j++) {
					if(micros[j][2] == 0) continue;
					
					for(int k = j+1; k < K; k++) {
						if(micros[k][2] == 0) continue;
						
						if(micros[j][0] == micros[k][0] & micros[j][1] == micros[k][1]) {
							// 이미 미생물 수 기준으로 내림차순 정렬 -> 무조건 앞에 있는 애가 더 크다 
							micros[j][2] += micros[k][2];
							micros[k][2] = 0;
						}
					}
				}
			}
			int ans = 0;
			for(int i = 0; i < K; i++) {
				if(micros[i][2] == 0) continue;
				ans += micros[i][2];
			}
			
			sb.append("#").append(test).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}
}
