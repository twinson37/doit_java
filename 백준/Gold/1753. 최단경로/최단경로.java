import java.io.*;
import java.util.*;

public class Main{

    static class Node implements Comparable<Node>{

        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int v_num = Integer.parseInt(tk.nextToken());
        int e = Integer.parseInt(tk.nextToken());
        int k = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        int u,v,w;

        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        int[] distance = new int[v_num+1];
        boolean[] visited = new boolean[v_num+1];
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for(int i = 0; i <= v_num; i++){
            list.add(new ArrayList<>());
            distance[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < e; i++){

            tk = new StringTokenizer(br.readLine());

            u = Integer.parseInt(tk.nextToken());
            v = Integer.parseInt(tk.nextToken());
            w = Integer.parseInt(tk.nextToken());

            list.get(u).add(new Node(v,w));
        }

        pq.add(new Node(k,0));

        distance[k]=0;

        while(!pq.isEmpty()){

            Node nowNode = pq.poll();

            int nowV = nowNode.v;

            if(visited[nowV]) continue;
            visited[nowV] = true;

            for (Node node : list.get(nowV)){

                if(distance[node.v]>node.w+distance[nowV]){
                    distance[node.v] = node.w+distance[nowV];
                    pq.add(new Node(node.v,distance[node.v]));
                }
            }

        }
        for(int i = 1; i<=v_num; i++){

            if (visited[i]) {
                System.out.println(distance[i]);
            } else {
                System.out.println("INF");
            }
        }
//        bw.write(String.valueOf(sb));
//        bw.flush();
//        bw.close();
    }
}