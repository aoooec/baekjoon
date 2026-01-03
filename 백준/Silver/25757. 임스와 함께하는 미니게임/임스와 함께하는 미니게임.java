import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        char game = st.nextToken().charAt(0);

        int split = 0;
        switch (game) {
            case 'Y':
                split = 1;
                break;
            case 'F':
                split = 2;
                break;
            case 'O':
                split = 3;
                break;
            default: break;
        }

        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String player = br.readLine();
            set.add(player);
        }

        System.out.print((set.size() / split));
    }
}
