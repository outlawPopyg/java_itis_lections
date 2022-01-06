import java.util.*;

class Rect {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    private int a;
    private int b;

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
        // left top cords
        this.x1 = this.min(x1,x2,x3,x4);
        this.y1 = this.max(y1,y2,y3,y4);

        // bottom right cords
        this.x2 = this.max(x1,x2,x3,x4);
        this.y2 = this.min(y1,y2,y3,y4);

        this.a = this.x2 - this.x1;
        this.b = this.y1 - this.y2;

    }

    public int perimeter() {
        return 2 * (a + b);
    }

    public int square() {
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

public class ekz3_paralell_rectangle {
    public static void main(String[] args) {
        Rect r = new Rect(2,3,5,3,2,1,5,1);
        System.out.println(r.toString());
        Rect r2 = new Rect(4,4,7,4,4,2,7,2);
    }
}