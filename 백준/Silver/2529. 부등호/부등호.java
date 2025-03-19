import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static char[] arr;
	private static int k;
	private static long min = Long.MAX_VALUE, max = Long.MIN_VALUE;
	private static int[] ans;
	static String minS, maxS;
	

	public static void main(String[] args) throws Exception {
		// 1843
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine()); // 2~9
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		arr = new char[k];
		ans = new int[k+1];
		for(int i = 0; i < k; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		perm(0, 0);
		System.out.println(maxS);
		System.out.print(minS);
	}

	private static void perm(int idx, int visited) {
		if(idx==k+1) {
			StringBuilder ansToInt = new StringBuilder();
			for(int n: ans) ansToInt.append(n);
			long num = Long.parseLong(ansToInt.toString());
			if(min > num) {
				min = num;
				minS = ansToInt.toString();
			} if (max < num) {
				max = num;
				maxS = ansToInt.toString();
			}
			return;
		}
		for(int i = 0; i < 10; i++) {
			if((visited & (1<<i))!= 0) continue;
			
			if(idx == 0 || (arr[idx - 1] == '<' && ans[idx - 1] < i) || (arr[idx - 1] == '>' && ans[idx - 1] > i)) {
				ans[idx] = i;
				perm(idx+1, visited|(1<<i));
			}
		}
	}
}
