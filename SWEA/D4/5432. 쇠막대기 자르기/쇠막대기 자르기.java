import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
 
        for(int tc = 1; tc <= T; tc++) {
            Stack<Character> stack = new Stack<>();
            String input = br.readLine();
            int cnt = 0; // 겹쳐진 쇠막대 개수
            int piece = 0; // 잘린 총 쇠막대 조각의 개수
            boolean prev = true; // 이전 값이 '('였으면 true, ')'였으면 false -> 레이저 찾기
 
            for(int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if(c == '(') {
                    stack.add(c); // 왼쪽 괄호인 경우 스택에 삽입
                    prev = true;
                    cnt++; // 겹쳐진 쇠막대 개수 증가
                }
                else {
                    if(prev) {
                        cnt--; // 이전 값이 '('이고 현재 값이 ')'이면 레이저 -> 겹쳐진 쇠막대 개수 하나 감소 보정
                        prev = false;
                        piece += cnt; // 겹쳐진 만큼의 조각 개수가 더해짐
                    } else {
                        cnt--; // 레이저가 아니고 현재 값이 ')'인 경우 막대 종료 -> 겹쳐진 쇠막대 카운트 감소
                        piece++; // 종료된 막대 1개의 끝 조각
                    }
                    stack.pop(); // 두 경우 다 공통적으로 stack에서 제거
                }
            }
            sb.append("#").append(tc).append(" ").append(piece).append("\n");
        }
        System.out.print(sb.toString());
    }
}