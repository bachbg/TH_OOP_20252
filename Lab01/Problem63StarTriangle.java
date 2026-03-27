import java.util.*;

public class Problem63StarTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input the height of the triangle: ");
        int iHeight = sc.nextInt();
        if (iHeight <= 0) {
            System.out.println("Height cannot be less than or equal to 0!");
        } else {
            for (int line = 0; line < iHeight; line++) {
                System.out.println(String.join("", Collections.nCopies(iHeight - line, " ")) + String.join("", Collections.nCopies(2 * line + 1, "*")));
            }
        }
        sc.close();
    }
}