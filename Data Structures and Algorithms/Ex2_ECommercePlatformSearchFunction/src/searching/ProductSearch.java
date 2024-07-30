package searching;
import java.util.Arrays;

public class ProductSearch {

	    public static Product linearSearch(Product[] products, int productId) {
	        for (Product product : products) {
	            if (product.getProductId() == productId) {
	                return product;
	            }
	        }
	        return null; 
	    }

	 
	    public static Product binarySearch(Product[] products, int productId) {
	        int left = 0;
	        int right = products.length - 1;

	        while (left <= right) {
	            int mid = left + (right - left) / 2;

	            if (products[mid].getProductId() == productId) {
	                return products[mid];
	            } else if (products[mid].getProductId() < productId) {
	                left = mid + 1;
	            } else {
	                right = mid - 1;
	            }
	        }
	        return null; 
	    }

	    public static void sortProductsById(Product[] products) {
	        Arrays.sort(products, (p1, p2) -> Integer.compare(p1.getProductId(), p2.getProductId()));
	    }
	}
