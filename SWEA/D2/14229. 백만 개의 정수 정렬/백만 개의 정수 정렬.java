import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N = 1000000;
	static int[] arr = new int[N];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < 1000000; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		} // 배열 채우기
		quickSort(0, N-1);
		System.out.print(arr[500000]);
	} // end of main
	
	static void quickSort(int start, int end) {
		if(start < end) {
			int pivot = partition(start, end);
			quickSort(start, pivot-1);
			quickSort(pivot+1, end);
		}
	}
	
	static int partition(int start, int end) {
		int pivot = arr[end]; // 로무토 -> 마지막 요소가 피봇 
		int i = start - 1; // pivot보다 작은 값을 가지는 부분의 경계 
		
		for(int j = start; j < end; j++) { 
			if(arr[j] <= pivot) { // 값이 pivot보다 작거나 같으면 
				i++; // 경계 +1
				int tmp = arr[i]; 
				arr[i] = arr[j]; // 경계 안에 해당 값을 넣음 
				arr[j] = tmp; // pivot보다 큰 값은 경계 밖으로 넘김 
			}
		}
		int tmp = arr[i+1]; // pivot이 있어야 할 자리 i+1
		arr[i+1] = arr[end];
		arr[end] = tmp;
		
		return i+1;
	}
} // end of class
