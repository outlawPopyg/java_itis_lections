import java.util.*;

class Rect {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public int leftX;
    public int leftY;
    public int rightX;
    public int rightY;
    public int otherX;
    public int otherY;

    private double a;
    private double b;

    public int min(int ...args) {
        int min = args[0];
        for (int i = 1; i < args.length; i++) {
            if (args[i] < min) {
                min = args[i];
            }
        }
        return min;
    }

    public int max(int ...args) {
        int max = args[0];
        for (int i = 1; i < args.length; i++) {
            if (args[i] > max) {
                max = args[i];
            }
        }
        return max;
    }

    public Rect(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        int[] xs = { x1, x2, x3, x4};
        int[] ys = { y1, y2, y3, y4};
        int minSum = Integer.MAX_VALUE;
        int maxSum = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; (j < 4 && i != j); j++) {
                if (xs[i] + ys[i] < xs[j] + ys[j] && xs[i]+ys[i] < minSum) {
                    minSum = xs[i] + ys[i];
                    this.leftX = xs[i];
                    this.leftY = ys[i];
                } else if (xs[i]+ys[i] > xs[j]+ys[j] && xs[i]+ys[i] > maxSum)  {
                    maxSum = xs[i]+ys[i];
                    this.rightX = xs[i];
                    this.rightY = ys[i];
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            if (xs[i] != this.leftX && xs[i] != this.rightX && ys[i] != this.leftY && ys[i] != this.rightY) {
                this.otherX = xs[i];
                this.otherY = ys[i];
            }
        }

        this.a = Math.sqrt(Math.pow(Math.abs(otherX - leftX), 2) + Math.pow(Math.abs(otherY - leftY), 2));
        this.b = Math.sqrt(Math.pow(Math.abs(otherX - rightX), 2) + Math.pow(Math.abs(otherY - rightY), 2));

    }

    public double perimeter() {
        return 2 * (a + b);
    }

    public double square() {
        return a * b;
    }

    public boolean commonPoints(Rect that) {
        if (this.x2 > that.x1 && this.x1 < that.x2 && this.y1 > that.y2 && this.y2 < that.y1) {
            return true;
        }
        return false;
    }

    public boolean equals(Rect that) {
        if (this.a == that.a && this.b == that.b) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "a - " + a + ", b - " + b + ", perimeter - " + perimeter() + ", square - " + square();
    }
}

public class sumfact {
    public static void main(String[] args) {
        Rect r = new Rect(5,9,10,6,7,3,3,6);
        System.out.println(r.leftX + " " + r.leftY + "  " + r.rightX + " " + r.rightY);
        System.out.println(r.toString());
    }
}