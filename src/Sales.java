//Christian_Phillip_Bagotsay-CPE_1A_1
//OOP_Assignment-Sales.java

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.zip.DataFormatException;
import javax.swing.*;



public class Sales {

    public static void main(String[] args) throws Exception{

        ArrayList<Product> products = new ArrayList<Product>();
        final float[] total_Price = {0};
        StringBuilder str = new StringBuilder();

        final JButton option1 = new JButton("Add Stock");
        final JButton option2 = new JButton("Purchase");
        final JButton option3 = new JButton("Product List");

        option1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Product myProduct = new Product();
                JTextField prodID = new JTextField();
                JTextField prodName = new JTextField();
                JTextField unitPrice = new JTextField();
                JTextField prdQty = new JTextField();

                Object[] fields = {
                        "Product ID: ", prodID,
                        "Product Name:  ",prodName,
                        "Unit Price:    ",unitPrice,
                        "Product Quantity:  ", prdQty,
                };

                JOptionPane.showConfirmDialog(null, fields, "Input Product Information", JOptionPane.OK_CANCEL_OPTION);

                String id_Text = prodID.getText();
                String name_Text = prodName.getText();
                String price_Text = unitPrice.getText();
                float price_Val = Float.parseFloat(price_Text);
                String pQty_Text = prdQty.getText();
                int pQty_Val = Integer.parseInt(pQty_Text);

                myProduct.add_Product(id_Text,name_Text,price_Val,pQty_Val);
                products.add(myProduct);
                str.append(myProduct.toString()).append("\n");

            }
        });
        option2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int count = 0;
                float temp_Price = 0;
                int prod_Index;
                boolean test = false;
                JTextField prodID = new JTextField();
                JTextField pQty = new JTextField();

                Object[] field1 = {
                        "Product ID: ", prodID
                };
                Object[] field2 = {
                        "Quantity: ", pQty
                };


                JOptionPane.showConfirmDialog(null, field1, "Input Product ID", JOptionPane.OK_CANCEL_OPTION);
                String pID_str = prodID.getText();

                for (int i = 0; i < products.size();i++) {
                    test = pID_str.equals(products.get(i).getProduct_ID());
                    count++;
                    System.out.println(products.get(i).toString());

                    if(test){
                        break;
                    }
                }

                prod_Index = count - 1;

                if(!test) {
                    JOptionPane.showMessageDialog(null,"Product ID not found.",null, JOptionPane.WARNING_MESSAGE);
                }
                else{
                    JOptionPane.showConfirmDialog(null, field2, "Input Quantity", JOptionPane.OK_CANCEL_OPTION);
                    String pQty_str = pQty.getText();
                    int pQty_Val = Integer.parseInt(pQty_str);

                    if(pQty_Val <= 0 || pQty_Val > products.get(prod_Index).getProduct_Quantity()){
                        JOptionPane.showMessageDialog(null,"Invalid Amount.",null, JOptionPane.WARNING_MESSAGE);
                        throw new ArithmeticException();
                    }
                    else {
                        temp_Price = products.get(prod_Index).getProduct_Unit_Price()*pQty_Val;

                        JOptionPane.showMessageDialog(null,"Total Price for Current Item: " + temp_Price,"Success",JOptionPane.PLAIN_MESSAGE);
                        total_Price[0] += temp_Price;
                        JOptionPane.showMessageDialog(null,"Total Price: " + total_Price[0],"Success",JOptionPane.PLAIN_MESSAGE);
                        products.get(prod_Index).setProduct_Quantity(products.get(prod_Index).getProduct_Quantity()-pQty_Val);
                        products.get(prod_Index).setSold_Quantity(pQty_Val);
                        products.get(prod_Index).setTotal_Sales(temp_Price);

                    }


                }


            }
        });
        option3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(null, str);
            }
        });
        JOptionPane.showOptionDialog(null, "Choose Desired Operation", "Product List",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE,null,new JButton[]{option1,option2,option3},null);




    }
}