import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().trim().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        String[] songInput = new String[N];
        HashMap<String, String> songs = new HashMap<>();

        for(int i = 0; i < N; i++) {
            String[] song = br.readLine().split(" ");
            String key = song[2] + song[3] + song[4];

            if (!songs.containsKey(key)) {
                songs.put(key, song[1]);
            } else {
                songs.put(key, "?");
            }
        }

        for(int i = 0; i < M; i++) {
            String music = br.readLine().replaceAll(" ", "");

            System.out.println(songs.getOrDefault(music, "!"));
        }

    }

}