import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[][] maze;
    static boolean[][] visited;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        maze = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {

            String row = sc.next();

            for (int j = 0; j < m; j++) {

                maze[i][j] = Integer.parseInt(String.valueOf(row.charAt(j)));
            }
        }
        findWayOut(0, 0);
        System.out.println(maze[n-1][m-1]);
    }

    private static void findWayOut(int y, int x) {

        Queue<int[]> queue = new LinkedList<>();
        int[][] arr = new int[n][m];

        queue.add(new int[]{ 0,0 });

        arr[0][0] = 1;
        visited[0][0] = true;
        while (!queue.isEmpty()){

            int[] nowCoordinate = queue.poll();
            int nowY = nowCoordinate[0];
            int nowX = nowCoordinate[1];

            for(int i =0;i<4;i++){
                int nextX = nowX+dx[i];
                int nextY = nowY+dy[i];

                if(nextX>=0&&nextY>=0&&nextY<n&&nextX<m){
                    if (maze[nextY][nextX]!=0&&!visited[nextY][nextX]){
                        visited[nextY][nextX] = true;
                        maze[nextY][nextX] = maze[nowY][nowX]+1;
                        queue.add(new int[]{nextY,nextX});
                    }
                }
            }

        }
    }
}