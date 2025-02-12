import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
         
            sc.nextLine();
            int[] arr = new int[10];
             
            for(int i = 0; i < 10; i++) {
                arr[i] = sc.nextInt();
            }
             
            Arrays.sort(arr);
             
            System.out.println("#" + test_case + " " + arr[9]);
 
        }
    }
}