import java.io.*;
import java.util.*;

public class Main {

    static int[][] maze;
    static boolean[][] visited;
    static int n, m;
    static Block[][] blocks;
    static int minimum = Integer.MAX_VALUE;

    static class Block {
        int i, j;
        boolean north;
        boolean south;
        boolean east;
        boolean west;

        Block(int i, int j) {
            this.i = i;
            this.j = j;

            checkPath();
        }

        public boolean isNorth() {
            return north;
        }

        public boolean isSouth() {
            return south;
        }

        public boolean isEast() {
            return east;
        }

        public boolean isWest() {
            return west;
        }

        private void checkPath() {

            if (i > 0 && maze[i - 1][j] == 1) {
                this.north = true;
            }
            if (i < n - 1 && maze[i + 1][j] == 1) {
                this.south = true;
            }
            if (j > 0 && maze[i][j - 1] == 1) {
                this.west = true;
            }
            if (j < m - 1 && maze[i][j + 1] == 1) {
                this.east = true;
            }

        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        maze = new int[n][m];
        visited = new boolean[n][m];

        blocks = new Block[n][m];

        for (int i = 0; i < n; i++) {

            String row = sc.next();

            for (int j = 0; j < m; j++) {

                maze[i][j] = Integer.parseInt(String.valueOf(row.charAt(j)));
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                blocks[i][j] = new Block(i, j);
            }
        }

        findWayOut(1, 0, 0);

        System.out.println(minimum);

    }

    private static void findWayOut(int depth, int y, int x) {

        Queue<Block> queue = new LinkedList<>();
        int[][] arr = new int[n][m];

        queue.add(blocks[y][x]);
        visited[y][x] = true;
        arr[0][0] = 1;
        while (!queue.isEmpty()){

            Block nowBlock = queue.poll();
            int nowY = nowBlock.i;
            int nowX = nowBlock.j;

            if (nowY == n - 1 && nowX == m - 1) {
                minimum = Math.min(minimum,arr[nowY][nowX]);
                return ;
            }

            if ((nowBlock.isEast() && !visited[nowY][nowX + 1])) {

                visited[nowY][nowX + 1] = true;
                queue.add(blocks[nowY][nowX+1]);
                arr[nowY][nowX+1] = arr[nowY][nowX]+1;
            }

            if (nowBlock.isNorth() && !visited[nowY - 1][nowX]) {

                visited[nowY - 1][nowX] = true;
                queue.add(blocks[nowY-1][nowX]);
                arr[nowY-1][nowX] = arr[nowY][nowX]+1;
            }
            if (nowBlock.isWest() && !visited[nowY][nowX - 1]) {

                visited[nowY][nowX - 1] = true;
                queue.add(blocks[nowY][nowX-1]);
                arr[nowY][nowX-1] = arr[nowY][nowX]+1;

            }
            if (nowBlock.isSouth() && !visited[nowY + 1][nowX]) {

                visited[nowY + 1][nowX] = true;
                queue.add(blocks[nowY+1][nowX]);
                arr[nowY+1][nowX] = arr[nowY][nowX]+1;
            }

        }
    }
}