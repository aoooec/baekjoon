import java.util.Scanner;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			String input = br.readLine();
			int length = input.length();
			int[] ball = new int[length];
			int cnt = 0;
			for(int i = 0; i < length; i++) {
				if(ball[i] == 1) continue; // 지난번 이미 count된 경우 건너뜀
				char c = input.charAt(i);
				if(c == '(') {
					ball[i+1] = 1; // 다음칸은 자동으로 ')'
					cnt++;
				} else if(c == ')') {
					cnt++; // '('가 가려져있었고 ')'를 만난 경우
				}
			}
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb.toString());
	}
}