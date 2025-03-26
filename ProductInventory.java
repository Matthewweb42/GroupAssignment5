public class ProductInventory {
    ProductNode inventoryHead = new ProductNode();
    public void showInventory(){
    }
    public int getTotalQuantity(){
        return 0;
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
    