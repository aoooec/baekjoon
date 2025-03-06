import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N = 1000000;
	static int[] arr = new int[N], tmp = new int[N];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < 1000000; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		} // 배열 채우기
		mergeSort(0, N-1);
		System.out.print(arr[500000]);
	} // end of main
	
	static void mergeSort(int start, int end) {
		if(start >= end) return;
		int mid = (start + end) / 2;
		mergeSort(start, mid);
		mergeSort(mid+1, end);
		merge(start, mid, end);
	}
	
	static void merge(int start, int mid, int end) {
		int L = start;
		int R = mid + 1;
		int idx = start;
		
		while(L <= mid && R <= end) {
			if(arr[L] <= arr[R]) {
				tmp[idx++] = arr[L++];
			} else {
				tmp[idx++] = arr[R++];
			}
		} 
		
		if(L <= mid) {
			for(int i = L; i <= mid; i++) {
				tmp[idx++] = arr[i]; 
			}
		} else {
			for(int i = R; i <= end; i++) {
				tmp[idx++] = arr[i]; 
			}
		} // 남은 수가 있으면 입력 
		for(int i = start; i <= end; i++) {
			arr[i] = tmp[i];
		}
	}
} // end of class
