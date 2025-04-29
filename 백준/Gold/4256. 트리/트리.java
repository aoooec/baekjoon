import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static class Node {
		Node left;
		Node right;
		int data;
		public Node(int data) {
			this.data = data;
		}
	}

	private static int[] pre, in;
	private static int preIdx;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()); // tc
		while(T-- > 0) {
			int n = Integer.parseInt(br.readLine()); // 1~1000
			pre = new int[n]; // 전위순회 배열
			in = new int[n]; // 중위순회 배열 
			preIdx = 0; 
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < n; i++) {
				pre[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < n; i++) {
				in[i] = Integer.parseInt(st.nextToken());
			}
			
			Node root = build(0, n - 1);
			postorder(root, sb);
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
	
	/** 재귀적으로 탐색 */
	public static Node build(int inStart, int inEnd) {
		if(inStart > inEnd) return null; // 교차하는 경우 탈출 
		
		Node root = new Node(pre[preIdx++]); // 어떤 노드의 부모가 되는 노드
		
		int rootIdx = -1; 
		for(int i = inStart; i <= inEnd; i++) {
			if(in[i] == root.data) { // 중위 순회에서 부모 노드의 값과 일치하는 경우의 인덱스를 찾음 
				rootIdx = i;
				break;
			}
		}
		
		root.left = build(inStart, rootIdx - 1); // 왼쪽 트리
		root.right = build(rootIdx + 1, inEnd); // 오른쪽 트리 
		
		return root;
	}
	
	public static void postorder(Node root, StringBuilder sb) {
		if(root == null) return;
		postorder(root.left, sb);
		postorder(root.right, sb);
		sb.append(root.data).append(" ");
	}
}
