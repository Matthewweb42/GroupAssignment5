public class ProductInventory {
    ProductNode inventoryHead = new ProductNode();
    public void showInventory(){
        ProductNode current = inventoryHead;
        while (current != null) {
            System.out.println(String.format("%s %s %d %f", current.productName, current.locator, current.quantity, current.price));
            current = current.next;
        }
    }
    public int getTotalQuantity(){
        ProductNode current = inventoryHead;
        int count = 0;
        while(current != null) {
            count += current.quantity;
            current = current.next;
        }
        return count;
    }
    public ProductNode removeMaximum(){
        if(inventoryHead == null) return null; /// prevents from running if the inventory is empty
        ProductNode refNode = inventoryHead;  //// starts at the head of the inventory
        ProductNode prevNode = null;     ///// initiates prev nodes for the reference and the max reference
        ProductNode maxPrevNode = null;
        ProductNode maxNode = refNode;     ///sets maxNode to the head initially
        while(refNode != null){
            if(refNode.quantity > maxNode.quantity){  /// checks to see if the current reference has a higher quantity than the current max
                maxPrevNode = prevNode;   //// saves the reference and prev reference of this node if so
                maxNode = refNode;
            }
            prevNode = refNode;    /// changes reference points
            refNode = refNode.next;
        }
        if(maxNode == inventoryHead){   /// checks case in which the maximum is the head
            inventoryHead = inventoryHead.next; /// changes the head ref to the next node if so
        } else{
            maxPrevNode.next = maxNode.next;     //// if not it simply sets the node behind the maximum to refer to the node after the maximum, effectively deleting it
        }
        return maxNode;           ///// returns the reference to that node found to be the maximum
    }
    public void sortInventory(){
        ProductNode sortedHead = null;      //// makes new reference nodes, one for the new list and one to track the return value of removeMax()
        ProductNode poppedNode;
        while(inventoryHead != null){         //// while there is content within the original inventory
            poppedNode = removeMaximum();     //// pops off the maximum quantity product node
            if(sortedHead == null){          //// if its the first value in the list, it sets the head just to that popped node.
                sortedHead = poppedNode;
            }else{                             //// on every other iteration, the popped node now points to the current head value
                poppedNode.next = sortedHead;
                sortedHead = poppedNode;         ///// AFTER the popped node points to that head, the popped node now becomes the new head of the sorted list.
            }
        }
        inventoryHead = sortedHead;                //// returns the last node popped off.
        // If necessary, we can put a dummy node just before this that's next points to sortedHead if other functions depend on the head containing blank data.
    }

    //Matthew Webecke's Code
    public void addProduct(String productName, String locator, int quantity, double price){
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
        // replace the empty first node if it exists
        if (inventoryHead.productName == "" && inventoryHead.locator == "") {
            inventoryHead = newNode;
        } else {
            current.next = newNode;
        }
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
        ProductNode current = inventoryHead;
        int count = 0;
        while (current != null) {
            if (current.productName.equals(productName)) {
                count += current.quantity;
            }
            current = current.next;
        }
        return count;
    }
    public int countNeededQuantity(String productName, int neededQuantity){
        int count = this.countProduct(productName);
        return neededQuantity - count;
    }
    class ProductException extends RuntimeException {
        public ProductException(String s) {
            super(s);
        }
    } // end ProductException
} // End ProductInventory
    