package models;

import java.util.ArrayList;

public class Shape {
    // Array to store the points that define the shape
    private Point[] points;

    // Default constructor to initialize the Shape with no points
    public Shape() {
        points = new Point[0];
    }

    // Constructor to initialize the Shape with an array of points
    public Shape(Point[] points) {
        // Check for null and perform defensive copy
        if (points != null) {
            this.points = new Point[points.length];
            for (int i = 0; i < points.length; i++) {
                this.points[i] = new Point(points[i].getX(), points[i].getY());
            }
        } else {
            // Handle case where points array is null
            throw new IllegalArgumentException("Points array cannot be null");
        }
    }

    // Getter method to retrieve the array of points
    public Point[] getPoints() {
        return points;
    }

    // Setter method to add point to the array of points
    public void addPoint(Point point) {
        // Check for null and perform defensive copy
        if (point != null) {
            // Create a new array with one more element than the current array
            Point[] newPoints = new Point[points.length + 1];

            // Copy the current array into the new array
            System.arraycopy(points, 0, newPoints, 0, points.length);

            // Add the new point to the end of the new array
            newPoints[points.length] = new Point(point.getX(), point.getY());

            // Update the points array
            points = newPoints;
        } else {
            // Handle case where point is null
            throw new IllegalArgumentException("Point cannot be null");
        }
    }


    // Override toString method to provide a string representation of the Shape
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Shape with points: [");
        for (Point point : points) {
            sb.append(point).append(", ");
        }
        // Remove the trailing ", " if there are points
        if (points.length > 0) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("]");
        return sb.toString();
    }

    public double calculatePerimeter() {
        // Calculate the perimeter of the shape
        double perimeter = 0.0;
        for (int i = 0; i < points.length; i++) {
            // Get the current point
            Point current = points[i];

            // Get the next point
            Point next = points[(i + 1) % points.length];

            // Add the distance between the current and next points to the perimeter
            perimeter += current.distanceTo(next);
        }
        return perimeter;
    }

    public double getLongest() {
        // Calculate the longest side of the shape
        double longest = 0.0;
        for (int i = 0; i < points.length; i++) {
            // Get the current point
            Point current = points[i];

            // Get the next point
            Point next = points[(i + 1) % points.length];

            // Calculate the distance between the current and next points
            double distance = current.distanceTo(next);

            // Update longest if the distance is greater than longest
            if (distance > longest) {
                longest = distance;
            }
        }
        return longest;
    }

    public double getAverage() {
        // Calculate the average side of the shape
        double average = 0.0;
        for (int i = 0; i < points.length; i++) {
            // Get the current point
            Point current = points[i];

            // Get the next point
            Point next = points[(i + 1) % points.length];

            // Calculate the distance between the current and next points
            double distance = current.distanceTo(next);

            // Add the distance to the average
            average += distance;
        }
        // Divide the average by the number of points
        average /= points.length;
        return average;
    }
}

