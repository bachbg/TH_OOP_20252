package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javax.swing.*;
import java.io.IOException;

public class CartScreen extends JFrame {
    private Cart cart;

    public CartScreen(Cart cart) {
        this.cart = cart;

        // Tạo JFXPanel chuyên dụng nhúng thành phần FX vào Swing [cite: 163, 165]
        JFXPanel fxPanel = new JFXPanel(); [cite: 165]
        this.add(fxPanel);

        this.setTitle("Cart");
        this.setSize(1024, 768);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        // Chạy tiến trình khởi tạo giao diện FX trên luồng Thread chuyên biệt của JavaFX [cite: 133]
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("cart.fxml"));
                    
                    // Khởi tạo bộ điều khiển Controller và liên kết dữ liệu [cite: 166]
                    CartScreenController controller = new CartScreenController(cart);
                    loader.setController(controller);
                    
                    Parent root = loader.load(); [cite: 161, 166]
                    fxPanel.setScene(new Scene(root)); // Gán Scene vào Container JFXPanel [cite: 167]
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}