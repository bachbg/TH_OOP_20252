import java.util.*;

public class Problem66Matrix {
    public static void main(String[] args) {
        int iRows, iCols;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        while (true) {
            iRows = sc.nextInt();
            if (iRows <= 0) {
                System.out.print("You entered an invalid number of rows, try again: ");
            } else {
                break;
            }
        }
        System.out.print("Enter number of columns: ");
        while (true) {
            iCols = sc.nextInt();
            if (iCols <= 0) {
                System.out.print("You entered an invalid number of columns, try again: ");
            } else {
                break;
            }
        }

        int[][] matrix1 = new int[iRows][iCols];
        int[][] matrix2 = new int[iRows][iCols];
        int[][] resultMat = new int[iRows][iCols];
        
        for (int i = 0; i < iRows; i++) {
            System.out.print("Enter " + iCols + " numbers for the " + (i + 1) + "'th row of matrix 1: ");
            for (int j = 0; j < iCols; j++) {
                matrix1[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < iRows; i++) {
            System.out.print("Enter " + iCols + " numbers for the " + (i + 1) + "'th row of matrix 2: ");
            for (int j = 0; j < iCols; j++) {
                matrix2[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < iRows; i++) {
            for (int j = 0; j < iCols; j++) {
                resultMat[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        
        System.out.println("The first matrix: ");
        for (int i = 0; i < iRows; i++) {
            for (int j = 0; j < iCols; j++) {
                System.out.print(matrix1[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("The second matrix: ");
        for (int i = 0; i < iRows; i++) {
            for (int j = 0; j < iCols; j++) {
                System.out.print(matrix2[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("The sum matrix: ");
        for (int i = 0; i < iRows; i++) {
            for (int j = 0; j < iCols; j++) {
                System.out.print(resultMat[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}