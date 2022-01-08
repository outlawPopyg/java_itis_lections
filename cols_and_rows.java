import java.util.*;

public class sumfact {

    public static int getCountsOfDigits(long number) {
        int count = (number == 0) ? 1 : 0;
        while (number != 0) {
            count++;
            number /= 10;
        }
        return count;
    }

    public static int[] getArrayOfNumber(int number) {
        int[] arr = new int[getCountsOfDigits(number)];
        int i = 1;
        while (number != 0) {
            arr[arr.length-i] = number % 10;
            number /= 10;
            i++;
        }

        return arr;
    }

    public static boolean findSubArray(int[] a, int[] b) {
        int length = 0;
        for (int i = 0; i < b.length; i++) {
            if (a[length] == b[i]) {
                length++;
            } else {
                length = 0;
            }
            if (a.length == length) {
                return true;
            }
        }
        return false;
    }

    public static int[] createRowFromCol(int[][] arr, int col) {
        int[] row = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            row[i] = arr[i][col];
        }
        return row;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        int cols = sc.nextInt();
        int rows = sc.nextInt();
        int[][] digits = new int[cols][rows];
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                digits[i][j] = sc.nextInt();
            }
        }

        boolean flag = true;
        for (int i = 0; (i < numbers.length-1 && flag); i++) {
            int[] cur = getArrayOfNumber(numbers[i]);
            boolean isFindRow = false;
            boolean isFindCol = false;

            for (int k = 0; (k < cols && !isFindRow); k++) {
                if (findSubArray(cur, digits[k])) {
                    isFindRow = true;
                    System.out.println("step " + i + " isFindRow = " + isFindRow);
                }
            }

            if (isFindRow) {
                int[] next = getArrayOfNumber(numbers[i+1]);
                for (int col = 0; (col < rows && !isFindCol); col++) {
                    int[] row = createRowFromCol(digits, col);
                    if (findSubArray(next, row)) {
                        isFindCol = true;
                        System.out.println("step " + i + " isFindCol = " + isFindCol);
                    }
                }
            }

            flag = isFindCol & isFindRow;

            System.out.println("step " + i + " flag = " + flag);
        }
        if (flag) {
            System.out.println("Right");
        } else {
            System.out.println("Wrong");
        }
    }
}