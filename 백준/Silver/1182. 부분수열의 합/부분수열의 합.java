import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


class Main {
    static int answer = 0;
    static int n;
    static int s;
    static boolean[] visited;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tk.nextToken());
        s = Integer.parseInt(tk.nextToken());
        visited = new boolean[n];
        tk = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {

            list.add(Integer.parseInt(tk.nextToken()));
        }

        for (int i = 0; i < n; i++) {
            visited[i] = true;
            back(i, list.get(i));
        }
        System.out.println(answer);
    }

    private static void back(int i, int sum) {

        if (sum == s) {
            answer++;
        }

        for (int j = i + 1; j < n; j++) {
            if (visited[j]) {
                continue;
            }

            visited[j] = true;
            back(j, sum + list.get(j));
            visited[j] = false;
        }
    }
}