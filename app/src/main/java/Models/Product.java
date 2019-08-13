package Models;

import io.realm.RealmObject;

public class Product extends RealmObject {

    private String productName;
    private String dateOfExpire;
    private String dataOfManufacture;
    private int price;


    public Product() {
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDateOfExpire() {
        return dateOfExpire;
    }

    public void setDateOfExpire(String dateOfExpire) {
        this.dateOfExpire = dateOfExpire;
    }

    public String getDataOfManufacture() {
        return dataOfManufacture;
    }

    public void setDataOfManufacture(String dataOfManufacture) {
        this.dataOfManufacture = dataOfManufacture;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
