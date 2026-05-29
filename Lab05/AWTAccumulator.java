package hust.soict.dsai.swing; // Đổi thành globalict nếu học lớp Global ICT

import java.awt.*;
import java.awt.event.*;

public class AWTAccumulator extends Frame {
    private TextField tfInput;
    private TextField tfOutput;
    private int sum = 0; // Tích lũy tổng, khởi tạo bằng 0 [cite: 12]

    // Constructor thiết lập giao diện và bộ xử lý sự kiện
    public AWTAccumulator() {
        setLayout(new GridLayout(2, 2)); // Grid layout 2 dòng, 2 cột [cite: 12]

        add(new Label("Enter an Integer: ")); [cite: 13]
        tfInput = new TextField(10); [cite: 13]
        add(tfInput); [cite: 14]
        tfInput.addActionListener(new TFInputListener()); [cite: 13]

        add(new Label("The Accumulated Sum is: ")); [cite: 16]
        tfOutput = new TextField(10); [cite: 16]
        tfOutput.setEditable(false); // Thiết lập chế độ chỉ đọc [cite: 16]
        add(tfOutput); [cite: 15]

        setTitle("AWT Accumulator"); [cite: 16]
        setSize(350, 120); [cite: 15]
        setVisible(true); [cite: 15]
    }

    public static void main(String[] args) {
        new AWTAccumulator(); [cite: 17]
    }

    // Lớp nội (Inner class) xử lý sự kiện khi nhấn Enter tại TextField đầu vào
    private class TFInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            // Lấy chuỗi từ input, ép kiểu sang số nguyên và cộng dồn vào tổng [cite: 18]
            int numberIn = Integer.parseInt(tfInput.getText()); [cite: 18]
            sum += numberIn; [cite: 19]
            tfInput.setText(""); // Xóa nội dung ô nhập liệu sau khi nhấn Enter [cite: 19]
            tfOutput.setText(sum + ""); // Hiển thị tổng mới [cite: 19]
        }
    }
}