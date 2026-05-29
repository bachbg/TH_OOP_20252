package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
    private Cart cart;

    @FXML private TableView<Media> tblMedia; [cite: 171]
    @FXML private TableColumn<Media, String> colMediaTitle; [cite: 172]
    @FXML private TableColumn<Media, String> colMediaCategory; [cite: 172]
    @FXML private TableColumn<Media, Float> colMediaCost; [cite: 172]
    
    @FXML private Button btnPlay; [cite: 184]
    @FXML private Button btnRemove; [cite: 184]
    @FXML private TextField tfFilter; [cite: 195]
    @FXML private RadioButton radioBtnFilterId; [cite: 195]
    @FXML private RadioButton radioBtnFilterTitle; [cite: 195]
    @FXML private Label lblTotalCost; // Thêm hiển thị tổng chi phí tự động cập nhật

    public CartScreenController(Cart cart) {
        this.cart = cart;
    }

    @FXML
    public void initialize() { [cite: 173]
        // Khởi tạo các cột dữ liệu lấy từ thuộc tính lớp Media thông qua PropertyValueFactory [cite: 179]
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title")); [cite: 179]
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category")); [cite: 179]
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost")); [cite: 179]
        
        // Gán ObservableList của giỏ hàng cho bảng hiển thị [cite: 175, 178]
        tblMedia.setItems(this.cart.getItemsOrdered()); [cite: 175]
        
        // Thiết lập ẩn hai nút Play và Remove lúc chưa chọn hàng [cite: 186]
        btnPlay.setVisible(false); [cite: 186]
        btnRemove.setVisible(false); [cite: 186]

        // Theo dõi thay đổi dòng được lựa chọn trong bảng để cập nhật trạng thái nút [cite: 187]
        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                if (newValue != null) { [cite: 189]
                    updateButtonBar(newValue); [cite: 189]
                }
            }
        });
        
        // Lắng nghe biến động giỏ hàng để cập nhật liên tục tổng số tiền hiển thị [cite: 198]
        updateTotalCost();
        this.cart.getItemsOrdered().addListener((ListChangeListener<Media>) c -> updateTotalCost());
    }

    private void updateButtonBar(Media media) { [cite: 189]
        btnRemove.setVisible(true);
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }

    private void updateTotalCost() {
        float total = 0;
        for (Media m : cart.getItemsOrdered()) {
            total += m.getCost();
        }
        lblTotalCost.setText(total + " $");
    }

    // Xử lý sự kiện nhấn nút Remove để xóa sản phẩm khỏi danh sách [cite: 190, 191]
    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media); // Tự động cập nhật giao diện thông qua cấu trúc ObservableList [cite: 192]
    }
}