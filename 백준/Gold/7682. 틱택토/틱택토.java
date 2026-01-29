import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();

        while (!s.equals("end")) {
            boolean isValid = true;
            char[] game = s.toCharArray();
            int xc = 0, oc = 0;

            for (char c : game) {
                if (c == 'X') xc++;
                else if (c == 'O') oc++;
            }

            if (xc < oc || oc + 1 < xc) {
                isValid = false;
            }

            if (isValid) {
                int bingo = 0;
                boolean winX = false, winO = false;

                for (int i = 0; i < game.length; i += 3) {
                    if (game[i] != '.' && game[i] == game[i + 1] && game[i + 1] == game[i + 2]) {
                        if (game[i] == 'X') winX = true;
                        else if (game[i] == 'O') winO = true;

                        bingo++;
                    }
                }

                for (int i = 0; i < 3; i++) {
                    if (game[i] != '.' && game[i] == game[i + 3] && game[i] == game[i + 6]) {
                        if (game[i] == 'X') winX = true;
                        else if (game[i] == 'O') winO = true;

                        bingo++;
                    }
                }

                if (game[0] != '.' && game[0] == game[4] && game[4] == game[8]) {
                    if (game[0] == 'X') winX = true;
                    else if (game[0] == 'O') winO = true;
                    bingo++;
                }

                if (game[2] != '.' && game[2] == game[4] && game[4] == game[6]) {
                    if (game[2] == 'X') winX = true;
                    else if (game[2] == 'O') winO = true;

                    bingo++;
                }

                if (bingo > 2 || (winO && winX) || ((xc + oc < 9) && bingo == 0) || (winO && oc != xc) || ((xc == oc) && winX)) {
                    isValid = false;
                }
            }


            sb.append(isValid ? "valid" : "invalid").append("\n");

            s = br.readLine();
        }

        System.out.print(sb);
    }
}