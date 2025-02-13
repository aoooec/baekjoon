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
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			// 배열 크기를 받아 생성 후 값 삽입 
			st = new StringTokenizer(br.readLine()); 
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int[] A = new int[a];
			int[] B = new int[b];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < a; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < b; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}
			
			// 배열 크기를 비교해 큰 배열, 작은 배열의 주소를 담음 			
			int[] small;
			int[] big;
			
			if(a > b) {
				big = A;
				small = B;
			} else {
				big = B;
				small = A;
			}
			
			int cnt = big.length - small.length; // 반복 횟수
			int max = Integer.MIN_VALUE; // 최댓값
			
			// cnt만큼 반복해서 마주보는 숫자 곱의 최대를 찾는다. 
			for(int i = 0; i <= cnt; i++) {
				int sum = 0; // 임시 합산 
				for(int j = 0; j < small.length; j++) {
					// 작은 배열은 0 ~ length - 1까지 항상 반복
					sum += small[j]  * big[i + j];
				}
				max = Math.max(max, sum);
			}
			
			sb.append("#").append(tc).append(" ").append(max).append("\n");
		}
		System.out.println(sb.toString());
	}
}