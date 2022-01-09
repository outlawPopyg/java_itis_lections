import java.util.*;


public class Stroki {

    public static boolean contains(char ch, String set) {
        for (int i = 0; i < set.length(); i++) {
            if (ch == set.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    public static int[] countOf(String str, String GLASN, String SOGL) {
        int[] a = { 0, 0 };

        for (int i = 0; i < str.length(); i++) {
            if (contains(str.charAt(i), GLASN)) {
                a[0]++;
            } else {
                a[1]++;
            }
        }
        return a;
    }

    public static boolean secondCondition(String[][] s, String GLASN, String SOGL) {
        int colCount = 0;
        for (int i = 0; i < s.length; i++) {
            boolean rightCol = true;
            for (int j = 0; (j < s.length && rightCol); j++) {
                int rightElems = 0;
                String cur = s[j][i];
                int c = 0;
                for (int k = 0; k < cur.length(); k++) {
                    if (contains(cur.charAt(k), GLASN)) {
                        c++;
                        if (k == cur.length()-1 && c == 2) {
                            rightElems ++;
                            c = 0;
                        }
                    } else if (contains(cur.charAt(k), SOGL) && c == 2) {
                        rightElems ++;
                        c = 0;
                    } else {
                        c = 0;
                    }
                }
                System.out.println(rightElems);
                if (rightElems != 3) {
                    rightCol = false;
                }
            }
            if (rightCol) {
                colCount++;
            }
        }
        if (colCount == 2) {
            return true;
        } else {
            return false;
        }
    }




    public static void main(String[] args) {
        final String SOGL = "bcdfghjklmnpqrstvwxzBCDFGHJKLMNPQRSTVWXZ";
        final String GLASN = "aeiouyAEIOUY";

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[][] chars = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chars[i][j] = sc.next();
            }
        }

        boolean flag = true;
        for (int i = 0; (i < n && flag); i++) {
            int c[] = countOf(chars[i][i], GLASN, SOGL);
            if (c[0] <= c[1]) {
                flag = false;
            }
        }
        
        flag &= secondCondition(chars, GLASN, SOGL);

        System.out.println(flag);
    }
}
