public class Product {
    String name;
    int price;
    String description;
    int quantity;

    public Product(String name, int price, String description, int quantity){
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }
    public void setName(String newName){
        name = newName;
    }
    public String getName(){
        return name;
    }
    public void setPrice(int newPrice){
        price = newPrice;
    }
    public int getPrice(){
        return price;
    }
    public void setDescription(String newDescription){
        description = newDescription;
    }
    public String getDescription(){
        return description;
    }
    public void setQuantity(int newQuantity){
        quantity = newQuantity;
    }
    public int getQuantity(){
        return quantity;
    }
}
