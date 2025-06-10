import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static class Gem implements Comparable<Gem> {
		int weight;
		int price;
		
		Gem(int weight, int price) {
			this.weight = weight;
			this.price = price;
		}
		
		@Override
		public int compareTo(Gem o) {
			return this.weight - o.weight;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 1~300000
		int K = Integer.parseInt(st.nextToken()); // 1~300000
		
		Gem[] gems = new Gem[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int w = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			gems[i] = new Gem(w, p);
		}
		Arrays.sort(gems);
		
		int[] bags = new int[K];
		
		for(int i = 0; i < K; i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(bags);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		long ans = 0;
		int gemIdx = 0;
		
		for(int i = 0; i < K; i++) {
			int bagWeight = bags[i];
			
			while(gemIdx < N && gems[gemIdx].weight <= bagWeight) {
				pq.add(gems[gemIdx].price);
				gemIdx++;
			}
			
			if(!pq.isEmpty()) {
				ans += pq.poll();
			}
		}
		
		System.out.print(ans);
	}
}
