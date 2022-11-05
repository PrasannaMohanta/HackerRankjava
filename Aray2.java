import java.util.*;

public class Aray2 {
    // Java 1D Array part2

    public static boolean canWin(int leap, int[] game) {
        int i = 0;
        int n = game.length;
        while (true) {
            while (i + leap < n && game[i + leap] == 0) {
                i += leap;
            }
            while (i + 1 < n && game[i + 1] == 0) {
                i++;
            }
            if (i == n - 1 || i + leap >= n) {
                return true;
            }
            if (game[i + 1] != 0 && game[i + leap] != 0) {
                boolean backleap = false;
                for (int back = 0; game[i - back] == 0; back++) {
                    if (game[i - back + leap] == 0) {
                        i += leap - back;
                        backleap = true;
                        break;
                    }
                    if (i - back == 0) {
                        break;
                    }
                }
                if (backleap) {
                    continue;
                }
                return false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println((canWin(leap, game)) ? "YES" : "NO");
        }
        scan.close();
    }
}