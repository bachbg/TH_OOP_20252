import javax.swing.JOptionPane;

public class Problem61YesNo {
    public static void main(String[] args) {
        int option = JOptionPane.showOptionDialog(
            null, 
            "Do you want to change to the first class ticket?",
            null,
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            null,
            null
        );
        
        JOptionPane.showMessageDialog(null, "You've chosen: " + (option == JOptionPane.YES_OPTION ? "Yes" : "No"));
        System.exit(0);
    }
}