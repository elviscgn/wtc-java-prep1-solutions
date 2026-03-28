package ex01_syntax;

public class NumberAnalyser {
    public static void main(String[] args) {
        int[] myArr = {-10,-5, 5, 0, -2, 2, 4, 7, 9, 1};
        int[] newArr = reverseArray(myArr);

        System.out.println(findMin(myArr));
        System.out.println(calculateAverage(myArr));

        System.out.println(newArr[0]);
        System.out.println(countEvens(newArr));
    }

    public static int findMax(int[] arr) {
        int largest = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
            // System.out.println(arr[i]);
        }

        return largest;
    }

    public static int findMin(int[] arr) {
        int smallest = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < smallest) {
                smallest = arr[i];
            }
            // System.out.println(arr[i]);
        }

        return smallest;
    }

    public static double calculateAverage(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        return (double) sum / arr.length;
    }

    public static int countEvens(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0 ) {
                count++;
            }
        }

        return count;
    }

    public static int[] reverseArray(int[] arr) {
        int[] revArray = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            revArray[i] = arr[arr.length-1-i];
        }

        return revArray;
    }


}
