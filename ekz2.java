import org.w3c.dom.ls.LSOutput;

import java.util.*;

class Triangle {
    private double a;
    private double c;


    public Triangle(double x_a, double y_a, double x_b, double y_b, double x_c, double y_c) throws Exception {

        double a = Math.sqrt(Math.pow(Math.abs(x_a - x_b), 2) + Math.pow(Math.abs(y_a - y_b), 2));
        double b = Math.sqrt(Math.pow(Math.abs(x_a - x_c), 2) + Math.pow(Math.abs(y_a - y_c), 2));
        double c = Math.sqrt(Math.pow(Math.abs(x_b - x_c), 2) + Math.pow(Math.abs(y_b - y_c), 2));

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
    
    public double perimeter() {
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

class TriangleUtils {
    public static double generalPerimeter(Triangle[] triangles) {
        double sum = 0;
        for (Triangle triangle : triangles) {
            sum += triangle.perimeter();
        }
        return sum;
    }

    public static boolean twoEquals(Triangle[] triangles) {
        for (int i = 0; i < triangles.length-1; i++) {
            for (int j = i+1; j < triangles.length; j++) {
                if (triangles[i].equals(triangles[j])) {
                    return true;
                }
            }
        }
        return false;
    }
}


public class ekz2 {
    public static void main(String[] args) {
        try {
            Triangle a = new Triangle(1, 4, 4,1,1,1);
            Triangle b = new Triangle(2, 5, 5,2,2,2);
            Triangle c = new Triangle(3, 6, 6,3,3,3);
            Triangle d = new Triangle(3, 6, 6,3,3,3);

            System.out.println(a.toString());
            System.out.println(b.toString());
            System.out.println(c.toString());

            System.out.println(TriangleUtils.twoEquals(new Triangle[]{a,b,c,d}));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}













