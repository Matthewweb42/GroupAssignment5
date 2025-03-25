public class ProductInventory {
    ProductNode inventoryHead = new ProductNode();
    public void showInventory(){
    }
    public int getTotalQuantity(){
        return 0;
    }
    public ProductNode removeMaximum(){
        return null;
    }
    public void sortInventory(){

    }

    //Matthew Webecke's Code
    public void addProduct(String productName, String locator, int quantity, float price){
        if (quantity < 0 || price < 0){
            throw new ProductException("Invalid quantity or price");
        }
        ProductNode newNode = new ProductNode(productName, locator, quantity, price);
        ProductNode current = inventoryHead;
        while (current.next != null){
            if(current.next.productName.equals(productName) && current.next.locator.equals(locator)){
                throw new ProductException("Product already exists");
            }
            current = current.next;
        }
        current.next = newNode;
    }

    //Matthew Webecke's Code
    public void removeProduct(String productName, String locator){
        ProductNode current = inventoryHead;
        while (current.next != null){
            if (current.next.productName.equals(productName) && current.next.locator.equals(locator)){
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
        throw new ProductException("Product not found");

    }
    public int countProduct(String productName){
        return 0;
    }
    public int countNeededQuantity(String productName, int neededQuantity){
        return 0;
    }
    class ProductException extends RuntimeException {
        public ProductException(String s) {
            super(s);
        }
    } // end ProductException
} // End ProductInventory
    