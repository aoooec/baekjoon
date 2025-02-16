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
		int T = Integer.parseInt(br.readLine()); // tc
		int[] arr = new int[101];
		
		for(int tc = 1; tc <= T; tc++) {
			br.readLine();
			st = new StringTokenizer(br.readLine(), " ");
			// 초기화
			for(int i = 0; i < 101; i++) {
				arr[i] = 0;
			}
			// 학생 점수 입력
			for(int i = 0; i < 1000; i++) {
				arr[Integer.parseInt(st.nextToken())]++;
			}
			int maxIdx = 0;
			int max = 0;
			for(int i = 100; i >= 0; i--) {
				if(max < arr[i]) {
					max = arr[maxIdx = i];
				}
			}
			sb.append("#").append(tc).append(" ").append(maxIdx).append("\n");
		}
		System.out.print(sb.toString());
	}
}