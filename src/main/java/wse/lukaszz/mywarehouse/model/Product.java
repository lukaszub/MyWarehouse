package wse.lukaszz.mywarehouse.model;

public class Product {

    private String name;
    private String productNumber;
    private int quantity;
    private float price;
    private String desc;

    public Product(String name, String productNumber, int quantity, float price, String description) {
        this.name = name;
        this.productNumber = productNumber;
        this.quantity = quantity;
        this.price = price;
        this.desc = description;
    } 

    public Product() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductNumber() {
        return this.productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", productNumber='" + getProductNumber() + "'" +
            ", quantity='" + getQuantity() + "'" +
            ", price='" + getPrice() + "'" +
            ", desc='" + getDesc() + "'" +
            "}";
    }


    
}
