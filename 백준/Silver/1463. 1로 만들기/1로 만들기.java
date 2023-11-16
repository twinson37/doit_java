import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] dpList = new int[n + 1];

        for (int i = 2; i <= n; i++) {

            int beforeNum = dpList[i - 1];

            if (i % 3 == 0) {
                beforeNum = Math.min(dpList[i / 3], beforeNum);
            }

            if (i % 2 == 0) {
                beforeNum = Math.min(dpList[i / 2], beforeNum);
            }

            dpList[i] = beforeNum + 1;
        }

        System.out.println(dpList[n]);
    }
}