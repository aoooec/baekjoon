import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String doc = br.readLine();
        String k = br.readLine();
        int ans = 0;
        int sIdx = 0;
        int size = k.length();
        while(sIdx <= doc.length() - size) {
            boolean isOk = true;
            for(int i = sIdx, idx = 0; idx < size; idx++) {
                if (doc.charAt(i + idx) != k.charAt(idx)) {
                    isOk = false;
                    break;
                }
            }
            if(isOk) {
                ans++;
                sIdx += size;
            } else sIdx++;
        }
        System.out.print(ans);
    }
}
