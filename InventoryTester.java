public class InventoryTester {
    public static void main(String[] args){
        ProductInventory inventory = new ProductInventory();
        // Add Products to inventory
        inventory.addProduct("Apple iphone 7 plus 32gb rose gold", "box256", 10, 699.80);
        inventory.addProduct("Apple iphone 7 plus 32gb rose gold", "shelf4", 4, 699.80);
        inventory.addProduct("Apple macbook pro", "box15", 2, 1500.87);
        inventory.addProduct("Dell Monitor", "shelf10", 12, 221.54);
        // Show inventory
        inventory.showInventory();
        /*
        Product Name Locator Quantity Price
        --------------------------------------------------------------------------
        Apple iphone 7 plus 32gb rose gold box256 10 699.80
        Apple iphone 7 plus 32gb rose gold shelf4 4 699.80
        Apple macbook pro box14 2 1500.87
        Dell Monitor shelf10 12 221.54
        */
        // Sort Products in inventory
        inventory.sortInventory();
        // Show inventory After sorting
        inventory.showInventory();
        /*
        Product Name Locator Quantity Price
        --------------------------------------------------------------------------
        Dell Monitor shelf10 12 221.54
        Apple iphone 7 plus 32gb rose gold box256 10 699.80
        Apple iphone 7 plus 32gb rose gold shelf4 4 699.80
        Apple macbook pro box14 2 1500.87
        */
        System.out.println(inventory.countProduct("Apple iphone 7 plus 32gb rose gold"));
        // Should return 14
        System.out.println(inventory.countNeededQuantity("Dell Monitor", 15)); // Should return 3
        inventory.removeMaximum();
        inventory.removeProduct("Apple iphone 7 plus 32gb rose gold", "shelf4");
        System.out.println(inventory.getTotalQuantity()); // Should return 12
    }
}
    