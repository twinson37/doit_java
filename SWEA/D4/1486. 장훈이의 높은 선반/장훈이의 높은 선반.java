import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.FileInputStream;
import java.util.StringTokenizer;

class Solution {

    static int answer = 0;
    static int n;
    static int[] h;
    static int b;
    static int minimum;
    static int nowSum;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(tk.nextToken());

        for (int test_case = 1; test_case <= T; test_case++) {

            tk = new StringTokenizer(br.readLine());

            answer = 0;
            n = Integer.parseInt(tk.nextToken());
            h = new int[n];
            b = Integer.parseInt(tk.nextToken());
            nowSum = 0;
            minimum = Integer.MAX_VALUE;

            tk = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {

                int nowHeight = Integer.parseInt(tk.nextToken());
                h[i] = nowHeight;
            }

            for(int i = 0; i < n; i++){
                backTracking(i);
            }
            int answer = minimum - b;
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }

    private static void backTracking(int start) {

        if(nowSum>=b){

            minimum = Integer.min(minimum,nowSum);
            return;
        }

        for (int i = start; i < n; i++) {
            nowSum += h[i];
            backTracking(i+1);
            nowSum -= h[i];
        }
    }
}