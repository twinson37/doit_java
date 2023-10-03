import java.io.*;
import java.util.*;

public class Main{

    static ArrayList<Integer>[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tk = new StringTokenizer(br.readLine());;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(tk.nextToken());
        int m = Integer.parseInt(tk.nextToken());

        arr = new ArrayList[n+1];
        visited = new boolean[n+1];

        int first;
        int second;
        for(int i = 0; i < n+1; i++){
            arr[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < m; i++){

            tk = new StringTokenizer(br.readLine());
            first = Integer.parseInt(tk.nextToken());
            second = Integer.parseInt(tk.nextToken());

            arr[second].add(first);
            arr[first].add(second);

        }
        int count=0;

        for(int i =1; i <n+1;i++){
            if(!visited[i]){
                count++;
                dfs(i);
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();

    }

    public static void dfs(int i){
        if(visited[i]) return;
        visited[i] = true;

        for (int j : arr[i]) {
            if(!visited[j]) dfs(j);
        }
    }
}
