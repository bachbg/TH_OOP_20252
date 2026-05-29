package hust.soict.dsai.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NumberGrid extends JFrame {
    private JButton[] btnNumbers = new JButton[10]; [cite: 56]
    private JButton btnDelete, btnReset; [cite: 57]
    private JTextField tfDisplay; [cite: 57]

    public NumberGrid() {
        tfDisplay = new JTextField(); [cite: 57]
        tfDisplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT); [cite: 58]

        JPanel panelButtons = new JPanel(new GridLayout(4, 3)); [cite: 58]
        addButtons(panelButtons); [cite: 58]

        Container cp = getContentPane(); [cite: 58]
        cp.setLayout(new BorderLayout()); [cite: 58]
        cp.add(tfDisplay, BorderLayout.NORTH); [cite: 58]
        cp.add(panelButtons, BorderLayout.CENTER); [cite: 59]

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); [cite: 59]
        setTitle("Number Grid"); [cite: 59]
        setSize(200, 200); [cite: 59]
        setVisible(true); [cite: 59]
    }

    void addButtons(JPanel panelButtons) { [cite: 60]
        ButtonListener btnListener = new ButtonListener(); [cite: 60]
        for (int i = 1; i <= 9; i++) { [cite: 61]
            btnNumbers[i] = new JButton("" + i); [cite: 61]
            panelButtons.add(btnNumbers[i]); [cite: 61]
            btnNumbers[i].addActionListener(btnListener); [cite: 61]
        }

        btnDelete = new JButton("DEL"); [cite: 61]
        panelButtons.add(btnDelete); [cite: 61]
        btnDelete.addActionListener(btnListener); [cite: 61]

        btnNumbers[0] = new JButton("0"); [cite: 62]
        panelButtons.add(btnNumbers[0]); [cite: 62]
        btnNumbers[0].addActionListener(btnListener); [cite: 62]

        btnReset = new JButton("C"); [cite: 62]
        panelButtons.add(btnReset); [cite: 62]
        btnReset.addActionListener(btnListener); [cite: 63]
    }

    public static void main(String[] args) {
        new NumberGrid();
    }

    // HOÀN THIỆN ĐẦY ĐỦ lớp nội xử lý sự kiện nút bấm [cite: 64]
    private class ButtonListener implements ActionListener { [cite: 64]
        @Override
        public void actionPerformed(ActionEvent e) { [cite: 64]
            String button = e.getActionCommand(); [cite: 64]
            
            if (button.charAt(0) >= '0' && button.charAt(0) <= '9') { [cite: 65]
                tfDisplay.setText(tfDisplay.getText() + button); [cite: 65]
            } 
            else if (button.equals("DEL")) { [cite: 66]
                // XỬ LÝ TRƯỜNG HỢP "DEL": Xóa ký tự cuối cùng vừa nhập [cite: 66, 68]
                String currentText = tfDisplay.getText();
                if (currentText.length() > 0) {
                    tfDisplay.setText(currentText.substring(0, currentText.length() - 1));
                }
            } 
            else { [cite: 66]
                // XỬ LÝ TRƯỜNG HỢP "C": Xóa toàn bộ màn hình hiển thị [cite: 66, 68]
                tfDisplay.setText("");
            }
        }
    }
}