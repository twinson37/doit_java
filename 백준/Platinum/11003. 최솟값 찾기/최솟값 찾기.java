import java.io.*;
import java.util.*;


public class Main{
    static class Node{
        public int val;
        public int index;

        Node(int val, int index){
            this.index = index;
            this.val =val;

        }
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(tk.nextToken());
        int l = Integer.parseInt(tk.nextToken());

        tk = new StringTokenizer(br.readLine());
        Deque<Node> deque =new LinkedList<>();

        int arr[] = new int[n];

        for(int i = 0; i<n;i++){
            arr[i] = Integer.parseInt(tk.nextToken());



            while(!deque.isEmpty()&&deque.getLast().val>arr[i]){
                deque.removeLast();
            }

            deque.addLast(new Node(arr[i],i));

            if(deque.getFirst().index-1<i-l){
                deque.removeFirst();
            }

            bw.write(deque.getFirst().val+" ");
        }


        bw.flush();
        bw.close();

    }
}

