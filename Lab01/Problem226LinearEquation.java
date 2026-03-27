import javax.swing.JOptionPane;

public class Problem226LinearEquation {
    public static void main(String[] args) {
        String num1, num2;
        num1 = JOptionPane.showInputDialog(null, "First number: ", "Input first number", JOptionPane.INFORMATION_MESSAGE);
        num2 = JOptionPane.showInputDialog(null, "Second number: ", "Input second number", JOptionPane.INFORMATION_MESSAGE);
        double a = Double.parseDouble(num1);
        double b = Double.parseDouble(num2);
        if (a != 0) {
            JOptionPane.showMessageDialog(null, "Solution: " + (-b / a), "First-degree equation", JOptionPane.INFORMATION_MESSAGE);
        } else {
            if (b != 0) {
                JOptionPane.showMessageDialog(null, "No solution", "Error", 0);
            } else {
                JOptionPane.showMessageDialog(null, "Infinite solutions", "First-degree equation", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        System.exit(0);
    }
}