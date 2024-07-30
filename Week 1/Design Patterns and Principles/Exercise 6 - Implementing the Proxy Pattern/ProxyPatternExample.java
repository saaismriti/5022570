package proxypattern;

public class ProxyPatternExample {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");
        System.out.println("photo1:");
        System.out.println("First time:");
        image1.display();
        System.out.println("Second time:");
        image1.display(); 
        System.out.println("\nphoto2:");
        System.out.println("First time:");
        image2.display(); 
        System.out.println("Second time:");
        image2.display(); 
    }
}
