import java.util.Scanner;

public class rotatearray {

    // Swap two elements
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Reverse array from i to j
    static void reverse(int[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    // Rotate array using extra array
    static int[] rotate(int[] arr, int k) {
        int n = arr.length;
        k = k % n;

        int[] ans = new int[n];
        int j = 0;

        // Last k elements
        for (int i = n - k; i < n; i++) {
            ans[j++] = arr[i];
        }

        // First n-k elements
        for (int i = 0; i < n - k; i++) {
            ans[j++] = arr[i];
        }

        return ans;
    }

    // Rotate array in-place
    static void rotateInplace(int[] arr, int k) {
        int n = arr.length;
        k = k % n;

        reverse(arr, 0, n - k - 1);
        reverse(arr, n - k, n - 1);
        reverse(arr, 0, n - 1);
    }

    // Print array
    static void printarray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("ENTER ARRAY SIZE:");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("ENTER " + n + " ELEMENTS:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("ENTER K:");
        int k = sc.nextInt();

        System.out.println("ORIGINAL ARRAY:");
        printarray(arr);

        // Using extra array
        int[] ans = rotate(arr, k);

        System.out.println("ARRAY AFTER ROTATION:");
        printarray(ans);

        sc.close();
    }
}