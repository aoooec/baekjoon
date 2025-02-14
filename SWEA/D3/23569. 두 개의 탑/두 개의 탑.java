import java.util.Scanner;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 최대힙
		
		int T = Integer.parseInt(br.readLine()); // 테스트케이스 수 
		
		for(int tc = 1; tc <=T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 전체 박스 수 (M1 + M2 = N), 1<=N<=50
			int small = Integer.parseInt(st.nextToken()); // 만들어야 하는 층 1, 1<=M<=50
			int big = Integer.parseInt(st.nextToken()); // 만들어야 하는 층 2

			// 작은 값을 small, 큰 값을 big에 저장한다. 
			if(big < small) {
				int temp = big;
				big = small;
				small = temp;
			}
			
			int[] smallArr = new int[small];
			int[] bigArr = new int[big]; 
			int[][] arr2 = {smallArr, bigArr};
			
			// N 크기의 우선순위 큐에 데이터를 넣는다. 
			// 무게는 1 ~ 1000 
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				pq.add(Integer.parseInt(st.nextToken()));
			}
			
			int cnt = 0;
			// 큐가 빌때까지 arr에 값을 삽입 
			while(!pq.isEmpty()) {
				// small의 마지막 칸이 채워지지 않았을때까지만
				if(smallArr[small - 1] == 0) { 
					smallArr[cnt] = pq.poll();
				}
				bigArr[cnt] = pq.poll();
				cnt++;
			}
			
			// 2차원 배열의 총 비용을 계산
			int sum = 0;
			for(int i = 0; i < big; i++) {
				if(i < small) sum += smallArr[i] * (i+1);
				sum += bigArr[i] * (i+1);
			}
			
			sb.append("#").append(tc).append(" ").append(sum).append("\n");
		} // 테스트케이스 반복 종료
		
		System.out.println(sb.toString());
	} // 메인 종료 
}