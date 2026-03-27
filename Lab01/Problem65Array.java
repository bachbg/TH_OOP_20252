import java.util.*;

public class Problem65Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the array length: ");
        int arrayLength = sc.nextInt();


        int[] array = new int[arrayLength];
        int iSum = 0;
        System.out.print("Enter the " + arrayLength + " (space divided) number of the array: ");
        for (int i = 0; i < arrayLength; i++) {
            array[i] = sc.nextInt();
            iSum += array[i];
        }
        Arrays.sort(array);

        System.out.print("Sorted array: ");
        for (int i = 0; i < arrayLength; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");
        System.out.println("Array's sum: " + iSum);
        System.out.println("Array's average: " + (double)(iSum / arrayLength));
        sc.close();
    }
}