import java.io.*;
import java.util.*;

public class Main {

    static char[][] board;
    static boolean[][] visited;
    static int z = 'Z';
    static boolean[] used = new boolean[z + 1];
    static int maximum = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int R;
    static int C;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        R = Integer.parseInt(tk.nextToken());
        C = Integer.parseInt(tk.nextToken());
        board = new char[R + 1][C + 1];
        visited = new boolean[R + 1][C + 1];

        for (int i = 1; i <= R; i++) {
            String now = br.readLine();
            for (int j = 1; j <= C; j++) {
                board[i][j] = now.charAt(j - 1);
            }
        }
        visited[1][1] = true;
        used[board[1][1]] = true;

        dfs(1, 1, 1);
        System.out.println(maximum);
    }

    private static void dfs(int i, int j, int depth) {

        maximum = Math.max(depth, maximum);

        for (int k = 0; k < 4; k++) {

            if (i + dx[k] > 0 && j + dy[k] > 0 && i + dx[k] <= R && j + dy[k] <= C) {
                if (visited[i + dx[k]][j + dy[k]]) {
                    continue;
                }
                if (used[board[i + dx[k]][j + dy[k]]]) {
                    continue;
                }
                visited[i + dx[k]][j + dy[k]] = true;
                used[board[i + dx[k]][j + dy[k]]] = true;
                dfs(i + dx[k], j + dy[k], depth + 1);
                visited[i + dx[k]][j + dy[k]] = false;
                used[board[i + dx[k]][j + dy[k]]] = false;

            }
        }
    }
}