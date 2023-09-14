import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(tk.nextToken());
        tk = new StringTokenizer(br.readLine());
        int arr[] = new int[n];
        int start_idx = 0;
        int end_idx = n-1;
        int sum;
        int tmp = 0;
        int count = 0;

        for(int i = 0; i<n;i++){
            arr[i] = Integer.parseInt(tk.nextToken());
        }
        Arrays.sort(arr);

        for(int i=0;i<n;i++) {
            start_idx = 0;
            end_idx = n - 1;
            while (start_idx < end_idx) {
                if (arr[start_idx] + arr[end_idx] == arr[i]) {
                    if (start_idx != i && end_idx != i) {
                        count++;
                        break;

                    } else if (start_idx == i) {
                        start_idx++;
                    } else if ((end_idx == i)) {
                        end_idx--;
                    }
                } else if (arr[start_idx] + arr[end_idx] < arr[i]) {
                    start_idx++;
                } else end_idx--;
            }

        }



        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();

    }
}
