import javax.swing.JOptionPane;

public class Problem226LinearSystem {
    public static void main(String[] args) {
        String num11, num12, num21, num22, num13, num23;
        num11 = JOptionPane.showInputDialog(null, "First number of first equation: ", null, JOptionPane.INFORMATION_MESSAGE);
        num12 = JOptionPane.showInputDialog(null, "Second number of first equation: ", null, JOptionPane.INFORMATION_MESSAGE);
        num13 = JOptionPane.showInputDialog(null, "RHS of first equation: ", null, JOptionPane.INFORMATION_MESSAGE);
        num21 = JOptionPane.showInputDialog(null, "First number of second equation: ", null, JOptionPane.INFORMATION_MESSAGE);
        num22 = JOptionPane.showInputDialog(null, "Second number of second equation: ", null, JOptionPane.INFORMATION_MESSAGE);
        num23 = JOptionPane.showInputDialog(null, "RHS of equation equation: ", null, JOptionPane.INFORMATION_MESSAGE);

        double a11 = Double.parseDouble(num11);
        double a12 = Double.parseDouble(num12);
        double a13 = Double.parseDouble(num13);
        double a21 = Double.parseDouble(num21);
        double a22 = Double.parseDouble(num22);
        double a23 = Double.parseDouble(num23);

        double det = a11 * a22 - a21 * a12;
        double det1 = - a12 * a23 + a22 * a13;
        double det2 = a11 * a23 - a13 * a21;
        if (det == 0) {
            if (det1 == 0) {
                if (det2 == 0) {
                    JOptionPane.showMessageDialog(null, "Infinite solutions", null, JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No solutions", null, 0);
                    }
            } else {
                JOptionPane.showMessageDialog(null, "No solutions", null, 0);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Solution is: x1 = " + (det1 / det) + " and x2 = " + (det2 / det), null, JOptionPane.INFORMATION_MESSAGE);
        }
        System.exit(0);
    }
}