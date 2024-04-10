//Christian_Phillip_Bagotsay-CPE_1A_1
//OOP_Assignment-Sales.java

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;



public class Sales {

    public static void main(String[] args) throws Exception{
        Product myProduct = new Product();
        ArrayList<Product> products = new ArrayList<Product>();

        StringBuilder str = new StringBuilder();

        final JButton option1 = new JButton("Add Stock");
        final JButton option2 = new JButton("Purchase");
        final JButton option3 = new JButton("Product List");

        option1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

            }
        });
        option2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               try {
                   boolean test = false;
                   JTextField prodID = new JTextField();
                   Object[] field1 = {
                           "Product ID: ", prodID
                   };

                   JOptionPane.showConfirmDialog(null, field1, "Input Product ID", JOptionPane.OK_CANCEL_OPTION);

                   for(int i = 0; i <= products.size(); i++){
                       test = prodID.equals(products.get(i).getProduct_ID());
                   }
                   if(!test){
                       throw new DataException(){

                       }
                   }
               }
               catch(Exception d){
                   JOptionPane.showMessageDialog(null,"Product ID not found.",null, JOptionPane.WARNING_MESSAGE);

               }
            }
        });
        option3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Product product : products) {
                    str.append(product.toString());
                    str.append("\n");
                }
                JOptionPane.showMessageDialog(null, str);
            }
        });
        JOptionPane.showOptionDialog(null, "Choose Desired Operation", "Product List",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE,null,new JButton[]{option1,option2,option3},null);




    }
}