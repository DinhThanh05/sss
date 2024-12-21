package hust.soict.globalict.aims.screen;

import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.cart.Cart;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
    @FXML
    private TableView<Media> tblMedia;
    @FXML
    private TableColumn<Media, String> colMediaTitle;
    @FXML
    private TableColumn<Media, String> colMediaCategory;
    @FXML
    private TableColumn<Media, Double> colMediaCost;
    @FXML
    private Label lblTotalCost;

    private Cart cart;

    public CartScreenController(Cart cart) {
        this.cart = cart;
    }

    @FXML
    private void initialize() {
        // Liên kết cột với thuộc tính của Media
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        // Đặt dữ liệu cho TableView
        ObservableList<Media> items = FXCollections.observableArrayList(cart.getItemsOrdered());
        tblMedia.setItems(items);

        // Hiển thị tổng chi phí
        updateTotalCost();
    }

    @FXML
    private void backToStore() {
        System.out.println("Back to store...");
        // Thêm logic để quay lại màn hình cửa hàng
    }

    @FXML
    private void exitApp() {
        System.exit(0);
    }

    @FXML
    private void placeOrder() {
        System.out.println("Order placed!");
        cart.getItemsOrdered().clear();
        tblMedia.getItems().clear();
        updateTotalCost();
    }

    private void updateTotalCost() {
        double totalCost = cart.totalCost();
        lblTotalCost.setText(String.format("%.2f $", totalCost));
    }
}
