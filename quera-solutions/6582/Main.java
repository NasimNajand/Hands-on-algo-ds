import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] A = new long[n + 1];
        A[0] = 0;
        for (int i = 1; i <= n; i++) {
            A[i] = scanner.nextLong();
        }
        int[] temp = new int[n + 1];
        temp[n] = n;
        // 3 2 3 2 4
        int lastMinPosition = n;
        for (int i = n - 1; i >= 1; i--) {
            if (A[i] < A[lastMinPosition]) {
                temp[i] = i;
                lastMinPosition = i;
            } else {
                temp[i] = lastMinPosition;
            }
        }

        long result = 0;
        for (int i = 1; i <= n; i++) {
            if (temp[i - 1] != temp[i]) {
                result += (Math.abs(temp[i] - temp[i - 1]) * A[temp[i]]);
            }
        }
        System.out.println(result + "");
    }
}
