package models;

public class Point {
    // Instance variables to store x and y coordinates
    private double x;
    private double y;

    // Constructor to initialize the Point with x and y coordinates
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Getter methods to retrieve x and y coordinates
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // Setter methods to update x and y coordinates
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    // Override toString method to provide a string representation of the Point
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public double distanceTo(Point other) {
        // Calculate the distance between two points
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public static void main(String[] args) {
        // Example usage
        Point myPoint = new Point(3.5, 7.2);
        System.out.println("Initial Point: " + myPoint);

        // Updating coordinates
        myPoint.setX(5.0);
        myPoint.setY(9.8);

        // Displaying updated point
        System.out.println("Updated Point: " + myPoint);
    }
}


