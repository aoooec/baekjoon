import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        sb.append(n).append(" is ");
        if(n % 2 == 0) sb.append("even");
        else sb.append("odd");
        System.out.print(sb.toString());
    }
}