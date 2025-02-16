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
		int[][] arr = new int[100][100];
		
		for(int tc = 1; tc <= 10; tc++) {
			int num = Integer.parseInt(br.readLine()); // tc
			int maxSum = Integer.MIN_VALUE;
			for(int i = 0; i < 100; i++) { // 배열 채우기
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int diag = 0;
			int antiDiag = 0;
			for(int i = 0; i < 100; i++) {
				int rSum = 0;
				int cSum = 0;
				for(int j = 0; j < 100; j++) {
					rSum += arr[i][j];
					cSum += arr[j][i];
				}
				diag += arr[i][i];
				antiDiag += arr[99-i][99-i];
				maxSum = Math.max(maxSum, Math.max(rSum, cSum));
			}
			maxSum = Math.max(maxSum, Math.max(diag, antiDiag));
			
			sb.append("#").append(num).append(" ").append(maxSum).append("\n");
		}
		System.out.println(sb.toString());
	}
}