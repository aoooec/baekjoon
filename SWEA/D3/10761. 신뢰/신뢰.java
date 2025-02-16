import java.util.Scanner;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // 버튼 수 
			int B = 1; // 로봇 위치 
			int O = 1;
			int timeB = 0; // 소요 시간(로봇별 총 누적) 
			int timeO = 0; 
			int time = 0; // 총 최대 소요 시간 
			int move = 0; // 1회에 이동한 시간 
			for(int i = 0; i < N; i++) {
				char sub = st.nextToken().charAt(0); // 대상 로봇
				int button = Integer.parseInt(st.nextToken()); // 눌러야 하는 버튼
				switch(sub) {
				case 'B':
					move = Math.abs(B - button); // 절댓값을 통해 이동 거리 확인
					// 이동 + 1(버튼 누르는 시간) 
					// 다른 로봇의 이동 시간이 더 길었을 경우 이미 해당 위치에서 대기하고 있었으므로
					// 버튼 누르는 시간만 더함 
					time = timeB = Math.max(timeB + move, time) + 1; 
					B = button; // 로봇 위치 저장 
					break;
				case 'O':
					move = Math.abs(O - button);
					time = timeO = Math.max(timeO + move, time) + 1; 
					O = button;
					break;
				}
			}
			sb.append("#").append(tc).append(" ").append(time).append("\n");
		} 
		System.out.print(sb.toString());
	}
}