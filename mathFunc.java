import java.lang.Math;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * There are various math functions that are supported by this class. 
 * They come in two categories: Basic, and Advanced
 * 
 * Basic:
 * boolean isPrime(int)
 * 
 * returns True if the number entered is prime. False if otherwise.
 * 
 * Advanced:
 * int[] simplifyRad(int) 
 *
 * returns 2 numbers, the first one is all of the radical numbers multipled together.
 * The second number has all of the whole numbers multipled together.
 * 
 * HashMap twoPoints(double x1, double y1, double x2, double y2)
 * 
 * returns a HashMap which contains various information about 2 points. It contains:
 * 
 * key "distance": returns the distance between the points as a double
 * 
 * key "exact": returns the radical form as the distance as a double
 * 
 * key "slope": returns the slope of the points
 * 
 * key "equation": returns the equation of the line as a String
 * 
 * key "midpoint_y": returns the midpoint between the y values
 * 
 * key "midpoint_x": returns the midpoint between the x values
 * 
 * HashMap onePoint(double x1, double x2, double slope)
 * 
 * returns a HashMap which contains various information about 1 point. It contains:
 * 
 * key "equation": returns the equation of the line as a String
 * 
 * key "slope": returns the slope as a double
*/

public class mathFunc {

    // Basic Methods
    public static boolean isPrime(int n) {
        int flag = 0;

        if (n > 1) {
            for (int i = 2; i < (int) Math.sqrt(n) + 1; i++) {
                if (n % i == 0) {
                    flag = 1;
                    break;
                }
            }

            if (flag == 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    // Advanced Methods

    public static int[] simplifyRad(int n) {
        ArrayList<ArrayList<Integer>> numbers = new ArrayList<ArrayList<Integer>>();
        int[] fNumbers = new int[2];

        numbers.add(new ArrayList<Integer>());
        numbers.add(new ArrayList<Integer>());
        fNumbers[0] = 1;
        fNumbers[1] = 1;

        int total = 1;
        int totalS = 1;

        while (true) {
            if (isPrime(n)) {
                numbers.get(0).add(n);
                break;
            } else {
                for (int i = 1; i < n; i++) {
                    if (isPrime(i) && (n % i == 0)) {
                        numbers.get(0).add(i);
                        n /= i;
                        break;
                    }
                }
            }
        }

        try { 
            while (true) {
                for (int i = 0; i < numbers.get(0).size(); i++) {
                    if (numbers.get(0).get(i) == numbers.get(0).get(i + 1)) {
                        numbers.get(1).add(numbers.get(0).get(i));
                        numbers.get(0).remove(i);
                        numbers.get(0).remove(i);

                        break;
                    }
                }
            }
        } finally {
            for (int i = 0; i < numbers.get(0).size(); i++) {
                fNumbers[0] = fNumbers[0] * numbers.get(0).get(i);
            }
            for (int i = 0; i < numbers.get(1).size(); i++) {
                fNumbers[1] = fNumbers[1] * numbers.get(1).get(i);
            }
            return fNumbers;
        }
    }

    public static HashMap twoPoints(double x1, double y1, double x2, double y2) {
        HashMap<Object, Object> exports = new HashMap<Object, Object>();

        // Finds midpoints
        exports.put("midpoint_x", (x1 + x2) / 2);
        exports.put("midpoint_y", (y1 + y2) / 2);

        // Finds distance between the points
        exports.put("distance", Math.sqrt(Math.pow((y2 - y1), 2) + Math.pow((x2 - x1), 2)));
        exports.put("exact", Math.pow((y2 - y1), 2) + Math.pow((x2 - x1), 2));

        // Finds the slope of the points
        double slope = (y2 - y1) / (x2 - x1);
        exports.put("slope", slope);

        // Finds the base
        double b = y1 - (slope * x1);

        // Finds the line equation of the lines
        exports.put("equation", slope + "x + " + b);

        return exports;
    }

    public static HashMap onePoint(double x1, double y1, double slope) {
        HashMap<Object, Object> exports = new HashMap<Object, Object>();

        // Finds the slope of the points
        exports.put("slope", slope);

        // Finds the base
        double b = y1 - (slope * x1);

        // Finds the line equation of the lines
        exports.put("equation", slope + "x + " + b);

        return exports;
    }
}
