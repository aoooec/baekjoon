import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int[] cardsG = new int[9], cardsI = new int[9]; // 두명의 카드 
	static boolean[] cards = new boolean[18]; // 규영 카드, 인영 카드 구분 
	static int win, lose;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()); // tc
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			Arrays.fill(cards, false); // 배열 초기화
			for(int i = 0; i < 9; i++) {
				cardsG[i] = Integer.parseInt(st.nextToken());
				cards[cardsG[i]-1] = true;
			} // 규영 카드 -> 내는 순서 정해짐  
			for(int i = 0, idx = 0; i < 18; i++) {
				if(!cards[i]) {
					cardsI[idx++] = i+1;
				}
			} // 인영 카드 -> 내는 순서 안정해짐
			
			win = 0; lose = 0; 
			int visited = 0;
			perm(0, 0, 0, visited);
			sb.append("#").append(tc).append(" ").append(win).append(" ").append(lose).append("\n");
		}

		System.out.print(sb.toString());
	} // end of main
	
	/** 인덱스를 받아 재귀 탐색 */
	static void perm(int i, int scoreG, int scoreI, int visited) {
		if(i >= 9) {
			if(scoreG > scoreI) win++;
			else if(scoreG < scoreI) lose++;
			return;
		}
		// 재귀 
		// 인영 카드가 방문했던 건지 확인하고,
		for(int j = 0; j < 9; j++) {
			// 사용했던거면 안쓰고, 
			if((visited & (1<<j)) != 0) continue;
			int temp = cardsG[i] - cardsI[j]; 
			int sum = cardsG[i] + cardsI[j];
			if(temp > 0) {
				perm(i+1, scoreG + sum, scoreI, visited|(1<<j)); // 규영이 이긴 경우
			} else {
				perm(i+1, scoreG, scoreI +sum, visited|(1<<j)); // 인영이 이긴 경우 
			}
		}
	}
} // end of class
