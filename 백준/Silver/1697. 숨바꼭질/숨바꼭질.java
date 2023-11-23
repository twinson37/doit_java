import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int k;
    static int minimum = Integer.MAX_VALUE;
    static boolean[] visited= new boolean[100001];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(tk.nextToken());
        k = Integer.parseInt(tk.nextToken());

        bfs(n, 0);
        System.out.println(minimum);
    }

    public static void bfs(int position, int move) {

        Subin firstSubin = new Subin(position, move);
        Queue<Subin> q = new LinkedList<>();
        q.add(firstSubin);

        while (!q.isEmpty()) {

            Subin nowSubin = q.poll();
            int nowNumber = nowSubin.getPosition();
            int nowMove = nowSubin.getMove();
            if(visited[nowNumber]) continue;
            visited[nowNumber] = true;
            if (nowNumber == k) {
                minimum = Math.min(minimum, nowMove);
                break;
            }
            if(nowNumber-1>=0){
                q.add(new Subin(nowNumber-1, nowMove+1));
            }
            if(nowNumber+1<=100000){
                q.add(new Subin(nowNumber+1, nowMove+1));
            }
            if(nowNumber*2<=100000){
                q.add(new Subin(nowNumber*2, nowMove+1));
            }
        }

    }

    private static class Subin {

        int position;
        int move;

        public Subin(int position, int move) {
            this.position = position;
            this.move = move;
        }

        public int getPosition() {
            return this.position;
        }

        public int getMove() {
            return this.move;
        }
    }
}