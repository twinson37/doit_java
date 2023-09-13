import java.io.*;
import java.util.*;

public class Main {
    public static void binary_search(int[] a, int num){
        int len = a.length;
        int mid = len/2;

        if (num>=a[mid]) {
            binary_search(a,num, mid, len-1);
//            return null;
        }else{
            binary_search(a,num, 0, mid-1);
        }
    }
    public static int binary_search(int[] a, int num, int start, int end){
        int mid = (start+end)/2;

        if (start>end){
//            System.out.println("3."+num +" mid["+mid+"]: "+a[mid]+ " end["+end+"]:"+a[end]);

            System.out.println(0);
            return 0;
        }else if(num==a[mid]){
//            System.out.println("4."+num +" mid["+mid+"]: "+a[mid]+ " end["+end+"]:"+a[end]);

            System.out.println(1);
            return 1;
        }else{
            if (num>a[mid]) {
//                System.out.println("1."+num +" mid["+mid+"]: "+a[mid]+ " end["+end+"]:"+a[end]);
                return binary_search(a,num, mid+1, end);
            }else{
//                System.out.println("2."+num +" mid["+mid+"]: "+a[mid]+ " end["+end+"]:"+a[end]);

                return binary_search(a,num, start, mid-1);
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer tk_N = new StringTokenizer(br.readLine()," ");
        int M = Integer.parseInt(br.readLine());
        StringTokenizer tk_M = new StringTokenizer(br.readLine()," ");
        int[] a = new int[N];

        for(int i = 0;i<N;i++){
            a[i] = Integer.parseInt(tk_N.nextToken());
        }

        Arrays.sort(a);

        for(int i = 0;i<M;i++){
            int b = Integer.parseInt(tk_M.nextToken());
            binary_search(a,b);
        }

        br.close();
//        bw.flush();
//        bw.close();
/*
        int a = Integer.parseInt(tk.nextToken());
        String array[] = str.split(" ");
 */
    }
}
