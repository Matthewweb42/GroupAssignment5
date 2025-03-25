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
    public void addProduct(String productName, String locator, int quantity, float price){

    }
    public void removeProduct(String productName, String locator){

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
    