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
		char[][] arr = new char[100][100];
		
		for(int t = 0; t < 10; t++) {
			int tc = Integer.parseInt(br.readLine());
			for(int i = 0; i < 100; i++) {
				String input = br.readLine();
				for(int j = 0; j < 100; j++) {
					arr[i][j] = input.charAt(j);
				}
			}
			
			int maxLen = 1;
			// 최대 회문 길이로 찾기
a:			for(int leng = 100; leng >= 2; leng--) { // 회문 길이
				for(int i = 0; i < 100; i++) { // 찾는 라인 위치 0 - 99
					for(int j = 0; j <= 100 - leng; j++) {
						boolean isSame = true; // flag
						for(int c = 0; c < leng / 2; c++) { // 행
							if(arr[i][j+c] != arr[i][j+leng-c-1]) {
								isSame = false;
								break;
							}
						}
						if(isSame) {
							maxLen = Math.max(maxLen, leng);
							break a;
						}
						isSame = true;
						for(int r = 0; r < leng / 2; r++) { // 열
							if(arr[j+r][i] != arr[j+leng-r-1][i]) {
								isSame = false;
								break;
							}
						}
						if(isSame) {
							maxLen = Math.max(maxLen, leng);
							break a;
						}
					}
				} 
			}
			sb.append("#").append(tc).append(" ").append(maxLen).append("\n");
		}
		System.out.print(sb.toString());
	}
}