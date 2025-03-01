import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		// 1203
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine()); // 2 ~ 50
		Person[] arr = new Person[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		for(int i = 0; i < N; i++) {
			int rank = 1;
			for(int j = 0; j < N; j++) {
				if(i == j) continue;
				if(arr[i].height < arr[j].height && arr[i].weight < arr[j].weight) {
					rank++;
				}
			}
			arr[i].rank = rank;
		}
		for(int i = 0; i < N; i++) {
			sb.append(arr[i].rank).append(" ");
		}
		System.out.print(sb.toString());
	}
}

class Person {
	int weight;
	int height;
	int rank;
	
	public Person(int weight, int height) {
		super();
		this.weight = weight;
		this.height = height;
	}
}
