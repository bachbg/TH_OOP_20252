package hust.soict.dsai.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingAccumulator extends JFrame {
    private JTextField tfInput;
    private JTextField tfOutput;
    private int sum = 0;

    public SwingAccumulator() {
        // Lấy Content Pane của JFrame để thêm thành phần [cite: 28]
        Container cp = getContentPane(); [cite: 28]
        cp.setLayout(new GridLayout(2, 2)); [cite: 29]

        cp.add(new JLabel("Enter an Integer: ")); [cite: 29]
        tfInput = new JTextField(10); [cite: 29]
        cp.add(tfInput); [cite: 29]
        tfInput.addActionListener(new TFInputListener()); [cite: 29]

        cp.add(new JLabel("The Accumulated Sum is: ")); [cite: 30]
        tfOutput = new JTextField(10); [cite: 30]
        tfOutput.setEditable(false); [cite: 30]
        cp.add(tfOutput); [cite: 30]

        setTitle("Swing Accumulator"); [cite: 31]
        setSize(350, 120); [cite: 31]
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Đóng ứng dụng khi nhấn X
        setVisible(true); [cite: 31]
    }

    public static void main(String[] args) {
        new SwingAccumulator(); [cite: 31]
    }

    private class TFInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            int numberIn = Integer.parseInt(tfInput.getText()); [cite: 32]
            sum += numberIn; [cite: 33]
            tfInput.setText(""); [cite: 33]
            tfOutput.setText(sum + ""); [cite: 33]
        }
    }
}