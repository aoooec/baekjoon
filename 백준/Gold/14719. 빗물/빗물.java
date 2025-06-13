import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[] height = new int[W];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < W; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}
		int ans = 0;
		for(int i = 1; i < W - 1; i++) {
			int leftMax = 0;
			int rightMax = 0;
			for(int j = 0; j < i; j++) {
				leftMax = Math.max(leftMax, height[j]);
			}
			for(int j = i + 1; j < W; j++) {
				rightMax = Math.max(rightMax, height[j]);
			}
			int rain = Math.min(leftMax, rightMax) - height[i];
			if(rain > 0) ans += rain;
		}
		System.out.print(ans);
	}
}
