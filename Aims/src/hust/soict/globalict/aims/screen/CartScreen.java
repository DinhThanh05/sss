package hust.soict.globalict.aims.screen;

import hust.soict.globalict.aims.cart.Cart;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CartScreen extends Application {
    private Cart cart;

    public CartScreen(Cart cart) {
        this.cart = cart;
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("cart.fxml"));
        loader.setController(new CartScreenController(cart));
        Scene scene = new Scene(loader.load());
        primaryStage.setTitle("Cart");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Cart cart = new Cart();
        // Thêm sản phẩm mẫu vào giỏ
        cart.addMedia(new Media("Book 1", "Books", 19.95));
        cart.addMedia(new Media("DVD 1", "DVDs", 14.95));
        cart.addMedia(new Media("CD 1", "CDs", 9.95));

        Application.launch(CartScreen.class, args);
    }
}
