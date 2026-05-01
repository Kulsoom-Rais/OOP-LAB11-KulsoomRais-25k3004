import java.util.*;

public class Task4 {

    // Generic method to sort a list of Numbers
    public static <T extends Number & Comparable<T>> void sortList(List<T> list) {
        Collections.sort(list);
    }

    // Wildcard method to calculate sum
    public static double calculateSum(List<? extends Number> list) {
        double sum = 0.0;
        for (Number num : list) {
            sum += num.doubleValue();
        }
        return sum;
    }

    // Wildcard method to find maximum value
    public static double findMax(List<? extends Number> list) {
        double max = Double.NEGATIVE_INFINITY;

        for (Number num : list) {
            if (num.doubleValue() > max) {
                max = num.doubleValue();
            }
        }
        return max;
    }

    // Print list
    public static void printList(List<?> list) {
        for (Object obj : list) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Using a List of Numbers (mix of Integer and Double via Number references)
        List<Number> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(5.5);
        numbers.add(20);
        numbers.add(3.3);
        numbers.add(15);

        // NOTE: Sorting mixed Integer and Double directly is not type-safe with Comparable,
        // so we sort using a custom Comparator instead
        numbers.sort(Comparator.comparingDouble(Number::doubleValue));

        double sum = calculateSum(numbers);
        double max = findMax(numbers);

        System.out.println("Sorted List:");
        printList(numbers);

        System.out.println("Sum: " + sum);
        System.out.println("Max: " + max);
    }
}


