import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        int T = 10;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int tc = sc.nextInt();
            int N = sc.nextInt();
            int M = sc.nextInt();
            System.out.println("#" + tc + " " + power(N, M, N));
        }
    }

    static int power(int n, int m, int fix) {
        if(m == 1) return n;
        return power(n*fix, m - 1, fix);
    }
}