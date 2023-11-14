import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static Queue<Integer> queue = new LinkedList<>();
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static boolean visited[];
    static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tk.nextToken());
        tk = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(tk.nextToken());
        visited = new boolean[n+1];

        for (int i = 0; i<=n; i++){

            list.add(new ArrayList<>());
        }

        for (int i = 0; i<m;i++){

            tk = new StringTokenizer(br.readLine());
            int nowNode = Integer.parseInt(tk.nextToken());
            int connectedNode = Integer.parseInt(tk.nextToken());

            list.get(nowNode).add(connectedNode);
            list.get(connectedNode).add(nowNode);
        }

        bfs(1);
        System.out.println(answer);
    }

    private static void bfs(int i) {

        queue.add(i);

        while (!queue.isEmpty()){

            int nowNode = queue.poll();

            visited[nowNode] = true;

            for(int nextNode : list.get(nowNode)){
                if(!visited[nextNode]){

                    queue.add(nextNode);
                    visited[nextNode]=true;
                    answer++;

                }
            }
        }
    }

}