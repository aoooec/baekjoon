import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		//1004
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine()); // 1 ~ 2000000
		Queue stack = new Queue();
		for(int i = 0; i < N; i++) {
			String comm = br.readLine();
			switch(comm) {
			case "front":
				sb.append(stack.front()).append("\n");
				break;
			case "back":
				sb.append(stack.back()).append("\n");
				break;
			case "size":
				sb.append(stack.size()).append("\n");
				break;
			case "empty":
				sb.append(stack.isEmpty() ? 1 : 0).append("\n");
				break;
			case "pop":
				sb.append(stack.pop()).append("\n");
				break;
			default:
				st = new StringTokenizer(comm, " ");
				st.nextToken();
				stack.push(Integer.parseInt(st.nextToken()));					
			}
		}
		System.out.print(sb.toString());
	}
}

class Queue {
	int front;
	int rear;
	ArrayList<Integer> queue = new ArrayList<Integer>();
	
	public Queue() {
		super();
		this.front = -1;
		this.rear = -1;
	}
	
	void push(int item) {
		rear++;
		queue.add(item);
	} 
	
	boolean isEmpty() {
		return rear == front;
	}
	
	int pop() {
		if(isEmpty()) return -1;
		return queue.get(++front);
	}
	
	int size() {
		return rear-front;
	}
	
	int front() {
		return isEmpty() ? -1 : queue.get(front+1);
	}
	
	int back() {
		return isEmpty() ? -1 : queue.get(rear);
	}
}