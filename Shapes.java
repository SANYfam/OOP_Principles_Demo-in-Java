/* OOP PRINCIPLES:- Demo
===========================
 Objects, classes, inheritance, abstraction, polymorphism, overriding, overloading, interface....

    * Given the following abstract class:

    *     public abstract class Shape {
    *      public abstract double area();
    *      public abstract double perimeter();
    *  }
    *
    * Implement a Circle, Triangle, and Rectangle class which extend the class Shape.
    * Ex: public class Circle extends Shape ... etc
 */

//public abstract class Shape : as abstract class
//public interface class Shape  : as interface class challeng?


/* YBfurther : implemented Squar and Ellipse as well */

public class Shapes 
{

    public abstract class Shape
    {
        public abstract double area();
        public abstract double perimeter();
    }

    public class Rectangle extends Shape 
    {
        private final double width, length; //sides

        public Rectangle() 
        {
            this(1,1); // constructor for Rectangle with defult values of length = 1 & width = 1
        }

        public Rectangle(double width, double length) 
        {
            this.width = width;
            this.length = length;
        }

        @Override
        public double area() 
        {
            // A = w * l
            return width * length;
        }

        @Override
        public double perimeter()
        {
            // P = 2(w + l)
            return 2 * (width + length);
        }

    }

    public class Square extends Shape
    {
        private final double length; // all 4 sides of a square
        
        public Square()
        {
            this(1);  // constructor for Squer with defult value of length = 1
        }

        public Square(double length)
        {
            this.length = length;
        }

        @Override
        public double area()
        {
            return length * length;
        }

        @Override
        public double perimeter()
        {
            // perimeter of a square = 2 (l + l) = 2 * 2 * l  or 4 * length
            return 2 * (length + length);
        }
    }

    public class Circle extends Shape 
    {
        private final double radius;
        final double pi = Math.PI;

        public Circle() {
            this(1);
        }   
        public Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public double area() {
            // A = π r^2
            return pi * Math.pow(radius, 2);
        }

        public double perimeter() {
            // P = 2πr
            return 2 * pi * radius;
        }
    }

    public class Triangle extends Shape
    {
        private final double a, b, c; // sides

        public Triangle()
        {
            this(1,1,1);
        }

        public Triangle(double a, double b, double c) 
        {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public double area()
        {
            // Heron's formula:
            // A = SquareRoot(s * (s - a) * (s - b) * (s - c)) 
            // where s = (a + b + c) / 2, or 1/2 of the perimeter of the triangle 
            double s = (a + b + c) / 2;
            return Math.sqrt(s * (s - a) * (s - b) * (s - c));
        }

        @Override
        public double perimeter()
        {
            // P = a + b + c
            return a + b + c;
        }
    } 

    public class Ellipse extends Shape
    {
         private final double SemiMajorAxis, SemiMinorAxis;
         final double pi = Math.PI;

        public Ellipse() // default constructor that set/init values of the smjraxis and smnraxis to 1,1 respectively
        {
            this(1,1);
        }
        
        public Ellipse(double SMjA, double SMiA)
        {
            this.SemiMajorAxis = SMjA;
            this.SemiMinorAxis = SMiA;
        }

        @Override
        public double area()
        {
            // Area of the ellipse = Pie(π) x Semi-Major Axis x Semi-Minor Axis
            //final double pi = Math.PI;
            return pi * SemiMajorAxis * SemiMinorAxis;
        }

        public double perimeter()
        {
            //  where Semi-MajorrAxis = a, and smnraxis = b
            // The perimeter of Ellipse = (2 * π) * sqrt[((a * a) + (b * b)) / (2)]
            
            double a, b, c, d, e, f;
            a = 2 * pi;
            b = Math.pow(SemiMajorAxis, 2);
            c = Math.pow(SemiMinorAxis, 2);
            d = (b + c) / (2);
            //e = sqrt(d);
            e = Math.pow(d, 0.5);
            f = a * e;
            return f;

        }
        
    }

    public static void main(String[] args) 
    {
        Shapes program = new Shapes();
        program.start();
    }

    public void start()
    {

        // Rectangle test
        double width = 5, length = 7;
        Shape rectangle = new Rectangle(width, length);
        System.out.println("Rectangle width: " + width + " and length: " + length
                + "\nResulting area: " + rectangle.area()
                + "\nResulting perimeter: " + rectangle.perimeter() + "\n");

        // Circle test
        double radius = 5;
        Shape circle = new Circle(radius);
        System.out.println("Circle radius: " + radius
            + "\nResulting Area: " + circle.area()
            + "\nResulting Perimeter: " + circle.perimeter() + "\n");

        // Triangle test
        double a = 5, b = 3, c = 4;
        Shape triangle = new Triangle(a,b,c);
        System.out.println("Triangle sides lengths: " + a + ", " + b + ", " + c
                + "\nResulting Area: " + triangle.area()
                + "\nResulting Perimeter: " + triangle.perimeter() + "\n");

        // Square test
        double squareSideLength = 12;
        Shape square = new Square(squareSideLength);
        System.out.println("\nSquare sides length: " + squareSideLength
                + "\nResulting Area: " + square.area()
                + "\nResulting Perimeter: " + square.perimeter() + "\n");

        // Ellipse Test
        double smjraxis = 70.0, smnraxis = 60.1;
        Shape ellipse = new Ellipse(smjraxis, smnraxis);
        System.out.println("\nEllipse's Semi-Major and Semi-Minor axises : " + smjraxis + ", " + smnraxis     
                + "\nResulting Area: " + ellipse.area()
                + "\nResulting Perimeter: " + ellipse.perimeter() + "\n");


    }
  
}