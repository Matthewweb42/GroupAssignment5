//Matthew Webecke's Code
public class ProductNode {
    String productName;
    String locator;
    int quantity;
    float price;
    ProductNode next;
    //Constructor # 1
    ProductNode(){
        productName = "";
        locator = "";
        quantity = 0;
        price = 0.0f;
    // Intialize other variables here
        next= null;
    }
    //Constructor # 2
    ProductNode(String productName, String locator, int quantity, float price){
        this.productName = productName;
        this.locator = locator;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }

    
}