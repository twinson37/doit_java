import java.io.*;
import java.util.*;

public class Main{
    static ArrayList<Integer>[] arr;
    static boolean[] dfs_visited;
    static boolean[] bfs_visited;
    static StringBuilder sb = new StringBuilder();



    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tk = new StringTokenizer(br.readLine());;
//        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(tk.nextToken());
        int m = Integer.parseInt(tk.nextToken());
        int v = Integer.parseInt(tk.nextToken());


        int first;
        int second;

        arr = new ArrayList[n+1];
        dfs_visited = new boolean[n+1];
        bfs_visited = new boolean[n+1];

        for(int i = 1;i<n+1;i++){
            arr[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < m; i++){

            tk = new StringTokenizer(br.readLine());
            first = Integer.parseInt(tk.nextToken());
            second = Integer.parseInt(tk.nextToken());

            arr[second].add(first);
            arr[first].add(second);

        }

        for(int i = 1;i<n+1;i++){
            Collections.sort(arr[i]);
        }

        dfs(v);
        sb.append("\n");
        bfs(v);

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();

    }

    static void dfs(int i){
        sb.append(i).append(" ");
        if(dfs_visited[i]) return;
        dfs_visited[i] = true;
        for(int j: arr[i]){
            if(!dfs_visited[j]) dfs(j);
        }
    }

    static void bfs(int i){
        Queue<Integer> q = new LinkedList<>();

        q.add(i);
        int j;
        while(!q.isEmpty()){
            j = q.poll();
            if(!bfs_visited[j]){
                bfs_visited[j] = true;
                sb.append(j).append(" ");
                for(int k:arr[j]){
                    if(!bfs_visited[k]) q.add(k);
                }
            }

        }
    }
}