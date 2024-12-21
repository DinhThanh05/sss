package hust.soict.globalict.aims;

import hust.soict.globalict.aims.media.Media;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Media> mediaList;

    public Cart() {
        mediaList = new ArrayList<>();
    }

    // Thêm Media vào Cart
    public void addMedia(Media media) {
        mediaList.add(media);
        System.out.println("Added: " + media.getTitle());
    }

    // Xóa Media khỏi Cart
    public void removeMedia(Media media) {
        mediaList.remove(media);
        System.out.println("Removed: " + media.getTitle());
    }

    // Hiển thị tất cả Media trong Cart
    public void displayCart() {
        if (mediaList.isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            System.out.println("Cart contains:");
            for (Media media : mediaList) {
                System.out.println(media);
            }
        }
    }

    // Lấy tổng số lượng các Media trong Cart
    public int getTotalItems() {
        return mediaList.size();
    }

    // Lấy danh sách các Media trong Cart (Items Ordered)
    public List<Media> getItemsOrdered() {
        return new ArrayList<>(mediaList); // Trả về danh sách các Media
    }
}
