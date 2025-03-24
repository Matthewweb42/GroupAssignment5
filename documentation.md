Person 1: ProductNode Class
Implement the ProductNode class with the following:

Attributes: productName, locator, quantity, price, and next (for linked list structure)

Constructors:

Default constructor (initialize fields to empty values or zero)

Parameterized constructor (initialize with given values)

Getters and Setters for each attribute (optional but useful)

Override toString() for easy printing




Person 2: Core ProductInventory Methods
Implement the following methods in ProductInventory:

showInventory() – Print all products in the inventory.

getTotalQuantity() – Return the total quantity of all products in inventory.

countProduct(String productName) – Count total quantity of a product with the given name.

countNeededQuantity(String productName, int neededQuantity) – Calculate how many more units are needed to reach neededQuantity.




Person 3: Add, Remove & Exception Handling
Implement:

addProduct(String productName, String locator, int quantity, float price)

Ensure no duplicate product with the same name & locator

Throw ProductException if quantity ≤ 0 or price ≤ 0

removeProduct(String productName, String locator)

Remove matching product if found

Define ProductException class




Person 4: Sorting & Removing Maximum
Implement:

removeMaximum() – Find and remove the product with the highest quantity.

sortInventory() – Sort products in descending order of quantity using removeMaximum().

Each person can test their part independently before merging everything into a final working program.