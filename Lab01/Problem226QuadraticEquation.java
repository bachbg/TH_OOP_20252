import javax.swing.JOptionPane;

public class Problem226QuadraticEquation {
    public static void main(String[] args) {
        String num1, num2, num3;
        num1 = JOptionPane.showInputDialog(null, "First number", null, JOptionPane.INFORMATION_MESSAGE);
        num2 = JOptionPane.showInputDialog(null, "Second number", null, JOptionPane.INFORMATION_MESSAGE);
        num3 = JOptionPane.showInputDialog(null, "Third number", null, JOptionPane.INFORMATION_MESSAGE);
        double a, b, c;
        a = Double.parseDouble(num1);
        b = Double.parseDouble(num2);
        c = Double.parseDouble(num3);
        if (a == 0) {
            JOptionPane.showMessageDialog(null, "a must be different from 0", "Error", 0);
        } else {
            double delta = b * b - 4 * a * c;
            if (delta < 0) {
                JOptionPane.showMessageDialog(null, "The equation has no roots", null, 0);
            } else if (delta == 0) {
                JOptionPane.showMessageDialog(null, "The equation has one root: " + (-b / (2 *a)), null, JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "The equation has two roots: " + ((-b + Math.sqrt(delta)) / (2 * a)) + " and " + ((-b - Math.sqrt(delta)) / (2 * a)), null, JOptionPane.INFORMATION_MESSAGE);
            }
        }
        System.exit(0);
    }
}