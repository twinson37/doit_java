import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    static int x;
    static int y;
    static int yDepth = 0;

    static ArrayList<ArrayList<Integer>> relation = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        int n = Integer.parseInt(br.readLine());
        tk = new StringTokenizer(br.readLine());

        x = Integer.parseInt(tk.nextToken());
        y = Integer.parseInt(tk.nextToken());

        int m = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {

            relation.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            tk = new StringTokenizer(br.readLine());
            int nowX = Integer.parseInt(tk.nextToken());
            int nowY = Integer.parseInt(tk.nextToken());

            relation.get(nowX).add(nowY);
            relation.get(nowY).add(nowX);
        }

        bfs(x, 0);

        if (yDepth != 0) {

            System.out.println(yDepth);
        } else {
            System.out.println(-1);
        }
    }

    private static void bfs(int i, int depth) {

        if (visited[i]) {
            return;
        }
        visited[i] = true;

        if (i == y) {

            yDepth = depth;
            return;
        }
        ArrayList<Integer> nowNode = relation.get(i);

        int size = nowNode.size();

        for (int j = 0; j < size; j++) {
            Integer nowNumber = nowNode.get(j);
            if (!visited[nowNumber]) {
                bfs(nowNumber, depth + 1);
            }
        }
    }
}