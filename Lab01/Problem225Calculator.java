import javax.swing.JOptionPane;

public class Problem225Calculator {
    public static void main(String[] args) {
        String strNum1, strNum2;
        strNum1 = JOptionPane.showInputDialog(null, 
                    "Please input the first number: ", "Input the first number",
                    JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null, 
                    "Please input the second number: ", "Input the second number",
                    JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);

        JOptionPane.showMessageDialog(null, "Sum: " + (num1 + num2), "Sum of two numbers", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Difference: " + (num1 - num2), "Difference of two numbers", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Product: " + (num1 * num2), "Product of two numbers", JOptionPane.INFORMATION_MESSAGE);
        
        if (num2 == 0) {
            JOptionPane.showMessageDialog(null, "Can't divide by 0", "Error", 0);
        } else {
            JOptionPane.showMessageDialog(null, "Quotient: " + (num1 / num2), "Quotient of two numbers", JOptionPane.INFORMATION_MESSAGE);
        }
        System.exit(0);
    }
}