import java.io.*;
import java.util.*;

public class Main {
    static class Pillar {
        int l;
        int h;

        public Pillar(int l, int h) {
            this.l = l;
            this.h = h;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        Pillar[] arr = new Pillar[N];
        int maxH = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            arr[i] = new Pillar(L, H);
            maxH = Math.max(maxH, H);
        }

        Arrays.sort(arr, Comparator.comparingInt(a -> a.l));

        int leftMax = -1, rightMax = -1;
        for (int i = 0; i < N; i++) {
            if (arr[i].h == maxH) {
                if (leftMax == -1) leftMax = i;
                rightMax = i;
            }
        }

        int ans = 0;
        int curr = arr[0].h;
        for (int i = 0; i < leftMax; i++) {
            curr = Math.max(curr, arr[i].h);
            int dx = arr[i + 1].l - arr[i].l;
            ans += curr * dx;
        }

        curr = arr[N - 1].h;
        for (int i = N - 1; i > rightMax; i--) {
            curr = Math.max(curr, arr[i].h);
            int dx = arr[i].l - arr[i - 1].l;
            ans += curr * dx;
        }

        ans += maxH * (arr[rightMax].l - arr[leftMax].l + 1);

        System.out.print(ans);
    }
}