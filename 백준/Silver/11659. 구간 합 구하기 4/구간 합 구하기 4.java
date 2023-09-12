import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n+1];
        arr[0] = 0;
        int ans=0;
        for (int l =1;l<n+1;l++){
            if(l==0) {
                arr[l] = sc.nextInt();
            }else{
                arr[l]= arr[l-1]+sc.nextInt();
            }
        }

        for(int k = 0;k<m;k++){
            ans = 0;
            ans -= arr[sc.nextInt()-1];
            ans+= arr[sc.nextInt()];
            System.out.println(ans);
        }


    }
}