package inventorymanagement;


import java.util.HashMap;

public class Inventory {
    private HashMap<String, Product> products;

    public Inventory() {
        this.products = new HashMap<>();
    }


    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }


    public void updateProduct(String productId, Product updatedProduct) {
        products.put(productId, updatedProduct);
    }

    public void deleteProduct(String productId) {
        products.remove(productId);
    }

    public Product getProduct(String productId) {
        return products.get(productId);
    }
    
    
    public void displayProducts() {
        for (Product product : products.values()) {
            System.out.println("ID: " + product.getProductId() + ", Name: " + product.getProductName() + 
                               ", Quantity: " + product.getQuantity() + ", Price: " + product.getPrice());
        }
    }

    
    
}
