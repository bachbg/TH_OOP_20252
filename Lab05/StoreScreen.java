package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.exception.PlayerException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class StoreScreen extends JFrame {
    private Store store;
    private Cart cart;

    // Constructor nhận vào cả đối tượng Store và Cart để xử lý nghiệp vụ liên kết
    public StoreScreen(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
        
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Store");
        setSize(1024, 768);
        setLocationRelativeTo(null); // Hiển thị cửa sổ ở chính giữa màn hình
        setVisible(true);
    }

    // Tạo khu vực phía Bắc chứa MenuBar và Header thanh công cụ
    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    // Xây dựng thanh Menu Options theo đúng đặc tả giao diện
    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        
        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem addBook = new JMenuItem("Add Book");
        JMenuItem addCD = new JMenuItem("Add CD");
        JMenuItem addDVD = new JMenuItem("Add DVD");
        smUpdateStore.add(addBook);
        smUpdateStore.add(addCD);
        smUpdateStore.add(addDVD);

        JMenuItem viewStore = new JMenuItem("View store");
        JMenuItem viewCart = new JMenuItem("View cart");
        
        menu.add(smUpdateStore);
        menu.add(viewStore);
        menu.add(viewCart);

        // Xử lý sự kiện chuyển đổi màn hình sang CartScreen khi nhấn View Cart từ Menu
        viewCart.addActionListener(e -> {
            new CartScreen(this.cart);
            this.dispose(); // Đóng màn hình Store hiện tại
        });

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }

    // Tạo thanh tiêu đề thương hiệu AIMS và nút View Cart nhanh
    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        JButton btnViewCart = new JButton("View cart");
        btnViewCart.setPreferredSize(new Dimension(100, 50));
        btnViewCart.setMaximumSize(new Dimension(100, 50));
        
        // Sự kiện cho nút View Cart trên Header
        btnViewCart.addActionListener(e -> {
            new CartScreen(this.cart);
            this.dispose();
        });

        header.add(Box.createRigidArea(new Dimension(10, 0)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(btnViewCart);
        header.add(Box.createRigidArea(new Dimension(10, 0)));

        return header;
    }

    // Tạo khu vực trung tâm hiển thị danh sách lưới sản phẩm (Grid Layout 3x3)
    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 9, 9));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        // Giới hạn hiển thị tối đa 9 item mẫu lên giao diện cửa hàng
        int limit = Math.min(mediaInStore.size(), 9);
        for (int i = 0; i < limit; i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }
        return center;
    }

    // Lớp nội bộ (Inner Class) đại diện cho từng ô hiển thị sản phẩm Media cụ thể
    private class MediaStore extends JPanel {
        private Media media;

        public MediaStore(Media media) {
            this.media = media;
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            // Hiển thị tên tiêu đề sản phẩm
            JLabel titleLabel = new JLabel(media.getTitle());
            titleLabel.setFont(new Font(titleLabel.getFont().getName(), Font.PLAIN, 20));
            titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            // Hiển thị giá tiền sản phẩm
            JLabel costLabel = new JLabel(media.getCost() + " $");
            costLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            // Khối chứa các nút chức năng (FlowLayout căn giữa)
            JPanel container = new JPanel();
            container.setLayout(new FlowLayout(FlowLayout.CENTER));

            JButton btnAddToCart = new JButton("Add to cart");
            container.add(btnAddToCart);
            
            // Xử lý sự kiện nút "Add to cart": Thêm trực tiếp vào đối tượng Cart và thông báo công cụ
            btnAddToCart.addActionListener(e -> {
                cart.addMedia(media);
                JOptionPane.showMessageDialog(StoreScreen.this, 
                    "Added \"" + media.getTitle() + "\" to cart successfully!", 
                    "Add to Cart", JOptionPane.INFORMATION_MESSAGE);
            });

            // Nếu sản phẩm thuộc dạng có thể phát nhạc/video (Playable) thì hiển thị thêm nút Play
            if (media instanceof Playable) {
                JButton btnPlay = new JButton("Play");
                container.add(btnPlay);
                
                // XỬ LÝ LỖI EXCEPTION TẠI ĐÂY (Nhiệm vụ mục 14)
                btnPlay.addActionListener(e -> {
                    try {
                        // Gọi phương thức play(), có khả năng ném ra PlayerException
                        ((Playable) media).play();
                        
                        // Nếu phát thành công không lỗi, hiển thị JDialog thông báo nội dung đang chạy
                        JDialog dialog = new JDialog(StoreScreen.this, "Playing Media", true);
                        dialog.setLayout(new GridBagLayout());
                        JLabel playingLabel = new JLabel("Now playing: " + media.getTitle());
                        playingLabel.setFont(new Font(playingLabel.getFont().getName(), Font.BOLD, 14));
                        dialog.add(playingLabel);
                        dialog.setSize(350, 150);
                        dialog.setLocationRelativeTo(StoreScreen.this);
                        dialog.setVisible(true);
                        
                    } catch (PlayerException ex) {
                        // HIỂN THỊ HỘP THOẠI BÁO LỖI CHO NGƯỜI DÙNG KHI ĐỘ DÀI LENGTH <= 0
                        JOptionPane.showMessageDialog(
                            StoreScreen.this, 
                            ex.getMessage(), 
                            "Media Playback Error", 
                            JOptionPane.ERROR_MESSAGE
                        );
                        ex.printStackTrace(); // In vết stack trace phục vụ debug hệ thống
                    }
                });
            }

            // Định dạng khoảng cách và đường viền bao quanh khối hiển thị sản phẩm
            this.add(Box.createVerticalGlue());
            this.add(titleLabel);
            this.add(costLabel);
            this.add(Box.createVerticalGlue());
            this.add(container);
            this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
    }
}