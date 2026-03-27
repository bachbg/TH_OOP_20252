import javax.swing.JOptionPane;

public class Problem61DoDont {
    public static void main(String[] args) {
        String[] options = {"I do", "I don't"};
        int option = JOptionPane.showOptionDialog(
            null, 
            "Do you want to change to the first class ticket?",
            null,
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[1]
        );
        
        JOptionPane.showMessageDialog(null, "You've chosen: " + (option == JOptionPane.YES_OPTION ? "Yes" : "No"));
        System.exit(0);
    }
}