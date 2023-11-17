import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int complex[][];
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};
    static boolean visited[][];
    static ArrayList<Integer> answer = new ArrayList<>();
    static int size;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer tk = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(tk.nextToken());

        complex = new int[n + 1][n + 1];
        visited = new boolean[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {

            tk = new StringTokenizer(br.readLine());
            String nowLine = tk.nextToken();
            for (int j = 1; j <= n; j++) {
                complex[i][j] = Integer.parseInt(nowLine.substring(j - 1, j));
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (!visited[i][j] && complex[i][j] == 1) {

                    visited[i][j] = true;
                    size = 0;
                    bfs(i, j);
                    answer.add(size);
                }
            }
        }
        answer.sort(Comparator.naturalOrder());
        sb.append(answer.size()).append("\n");
        for (int ans : answer) {
            sb.append(ans).append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }

    private static void bfs(int i, int j) {

        size++;
        for (int k = 0; k < 4; k++) {
            int x = dx[k];
            int y = dy[k];
            if ((i + x > 0) && (i + x <= n) && (y + j > 0) && (y + j <= n)) {
                if (complex[i + x][j + y] == 1 && !visited[i + x][j + y]) {
                    visited[i + x][j + y] = true;
                    bfs(i + x, j + y);
                }
            }

        }
    }
}