package lab6;

class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() { return x; }
    public double getY() { return y; }
}

class Quadrilateral {
    private Point p1, p2, p3, p4;

    public Quadrilateral(Point p1, Point p2, Point p3, Point p4) {
        this.p1 = p1; this.p2 = p2; this.p3 = p3; this.p4 = p4;
    }

    public Point getP1() { return p1; }
    public Point getP2() { return p2; }
    public Point getP3() { return p3; }
    public Point getP4() { return p4; }

    protected double distance(Point a, Point b) {
        return Math.sqrt(Math.pow(a.getX()-b.getX(),2) + Math.pow(a.getY()-b.getY(),2));
    }

    protected double trapezoidArea(double base1, double base2, double height) {
        return (base1 + base2) * height / 2.0;
    }
}

class Trapezoid extends Quadrilateral {
    public Trapezoid(Point p1, Point p2, Point p3, Point p4) {
        super(p1, p2, p3, p4);
    }

    public double area() {
        double base1 = distance(getP1(), getP2());
        double base2 = distance(getP3(), getP4());
        double height = Math.abs(getP1().getY() - getP3().getY());
        return trapezoidArea(base1, base2, height);
    }
}

class Parallelogram extends Quadrilateral {
    public Parallelogram(Point p1, Point p2, Point p3, Point p4) {
        super(p1, p2, p3, p4);
    }

    public double area() {
        double base = distance(getP1(), getP2());
        double height = Math.abs(getP1().getY() - getP3().getY());
        return base * height;
    }
}

class Rectangle extends Parallelogram {
    public Rectangle(Point p1, Point p2, Point p3, Point p4) {
        super(p1, p2, p3, p4);
    }

    public double area() {
        double width = distance(getP1(), getP2());
        double height = distance(getP1(), getP4());
        return width * height;
    }
}

class Square extends Rectangle {
    public Square(Point p1, Point p2, Point p3, Point p4) {
        super(p1, p2, p3, p4);
    }

    public double area() {
        double side = distance(getP1(), getP2());
        return side * side;
    }
}

public class lab61 {
    public static void main(String[] args) {
        Trapezoid trapezoid = new Trapezoid(new Point(0,0), new Point(4,0), new Point(3,3), new Point(1,3));
        Parallelogram parallelogram = new Parallelogram(new Point(0,0), new Point(5,0), new Point(6,3), new Point(1,3));
        Rectangle rectangle = new Rectangle(new Point(0,0), new Point(4,0), new Point(4,3), new Point(0,3));
        Square square = new Square(new Point(0,0), new Point(3,0), new Point(3,3), new Point(0,3));

        System.out.println("Trapezoid area: " + trapezoid.area());
        System.out.println("Parallelogram area: " + parallelogram.area());
        System.out.println("Rectangle area: " + rectangle.area());
        System.out.println("Square area: " + square.area());
    }
}
