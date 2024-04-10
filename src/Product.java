//Christian_Phillip_Bagotsay-CPE_1A_1
//OOP_Assignment


import java.lang.String;
import java.util.ArrayList;

public class Product {
    private String product_ID;
    private String product_Name;
    private float product_Unit_Price;
    private int product_Quantity;
    private int sold_Quantity;
    private double total_Sales;
    public float discount;

    public Product(){

    }
    public Product(String product_ID, String product_Name, float product_Unit_Price, int product_Quantity, int sold_Quantity, double total_Sales, boolean isDiscounted, float discount){
        this.setProduct_ID(product_ID);
        this.setProduct_Name(product_Name);
        this.setProduct_Unit_Price(product_Unit_Price);
        this.setProduct_Quantity(product_Quantity);
        this.setSold_Quantity(sold_Quantity);
        this.setTotal_Sales(total_Sales);
        this.discount = discount;
    }

    public void add_Product(String product_ID, String product_Name, float product_Unit_Price, int product_Quantity){
        this.setProduct_ID(product_ID);
        this.setProduct_Name(product_Name);
        this.setProduct_Unit_Price(product_Unit_Price);
        this.setProduct_Quantity(product_Quantity);

    }



    public String getProduct_ID() {
        return product_ID;
    }

    public void setProduct_ID(String product_ID) {
        this.product_ID = product_ID;
    }

    public String getProduct_Name() {
        return product_Name;
    }

    public void setProduct_Name(String product_Name) {
        this.product_Name = product_Name;
    }

    public float getProduct_Unit_Price() {
        return product_Unit_Price;
    }

    public void setProduct_Unit_Price(float product_Unit_Price) {
        this.product_Unit_Price = product_Unit_Price;
    }

    public int getProduct_Quantity() {
        return product_Quantity;
    }

    public void setProduct_Quantity(int product_Quantity) {
        this.product_Quantity = product_Quantity;
    }

    public int getSold_Quantity() {
        return sold_Quantity;
    }

    public void setSold_Quantity(int sold_Quantity) {
        this.sold_Quantity = sold_Quantity;
    }

    public double getTotal_Sales() {
        return total_Sales;
    }

    public void setTotal_Sales(double total_Sales) {
        this.total_Sales = total_Sales;
    }

    @Override
    public String toString(){
        return "Product Name:   " + getProduct_Name() + "\n" + "Product ID:   " + getProduct_ID() + "\n" + "Unit Price: " + getProduct_Unit_Price() + "\n" + "Product Quantity: " + getProduct_Quantity() + "\n" + "Units Sold: " + getSold_Quantity() + "\n" + "Total Sales:   " + getTotal_Sales() + "\n";
    }
}
