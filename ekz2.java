import org.w3c.dom.ls.LSOutput;

import java.util.*;

class Triangle {
    private int a;
    private int c;


    public Triangle(int a, int b, int c) throws Exception {
        if ((a+b > c) && (a+c > b) && (b+c > a)) {
            if (a == b) {
                this.a = a;
                this.c = c;
            } else if (a == c) {
                this.a = a;
                this.c = b;
            } else if (b == c) {
                this.a = b;
                this.c = a;
            } else {
                throw new Exception("Неправильный равнобедренный треугольник");
            }
        } else {
            throw new Exception("Неправильный треугольник");
        }
    }

    public int perimeter() {
        return a*2 + c;
    }

    public double square() {
        return a * a * Math.sin(corners()[2]) / 2;
    }

    public double[] corners() {
        double cos_a = (double)(c*c) / (double)(2*a*c);
        double a = Math.acos(cos_a) * 180 / Math.PI;
        return new double[]{a, a, 180-2*a};
    }

    public boolean equals(Triangle t) {
        if (this.a == t.a && this.c == t.c) {
            return true;
        }

        return false;
    }

    public String toString() {
        return "a - " + a + " b - " + a + " c - " + c + " corners - " + Arrays.toString(corners());
    }
}



public class ekz2 {
    public static void main(String[] args) {
        try {
            Triangle a = new Triangle(3, 3, 4);
            System.out.println(a.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}













