import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.FileInputStream;
import java.util.StringTokenizer;

class Solution {

    static int n;
    static int[] h;
    static int b;
    static int minimum;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(tk.nextToken());

        for (int test_case = 1; test_case <= T; test_case++) {

            tk = new StringTokenizer(br.readLine());

            n = Integer.parseInt(tk.nextToken());
            h = new int[n];
            b = Integer.parseInt(tk.nextToken());
            minimum = Integer.MAX_VALUE;

            tk = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {

                int nowHeight = Integer.parseInt(tk.nextToken());
                h[i] = nowHeight;
            }

            backTracking(0,0);
            int answer = minimum - b;
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }

    private static void backTracking(int depth, int sum) {

        if(n==depth){
            if(sum>=b){

                minimum = Integer.min(minimum,sum);
            }
            return;
        }

        backTracking(depth+1,sum+h[depth]);
        backTracking(depth+1,sum);

    }
}