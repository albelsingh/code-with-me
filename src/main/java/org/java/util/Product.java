package org.java.util;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Product {
    int id;
    String name;
    String description;
    double cost;
    List<Product> subProducts;
    /*
    * class Product {
	int id;
	String name;
	String description;
	double cost;
	List<Product> subProducts;
}

This product structure has been decided to be used to introduce the concept of bundled products.
A bundled product is formed by grouping together multiple sub products and sub bundled products.
//The cost attribute is not to be used for bundled product.
The cost of the bundled product will be added cost of indivisual sellable products that form the bundle.

Ex:

P1 -> p2, p3, p4
p3 -> p5, p6
p5 -> p6, p7

(* p2, p4, p6, p7 are indivisual sellable items)

then cost of p1 will be p2.cost + p4.cost + p6.cost + p6.cost + p7.cost


implement a function that can calculate the cost of the product
double getCost(Product p), where p can be an indivisual selling product or a bundled product.
    * */
    public double calculateCost(Product p){
        if( p.getSubProducts().isEmpty()){
            return p.getCost();
        }else{
          return p.getSubProducts().stream().map(Product::getCost).mapToDouble(cost->cost).sum();
        }
    }
    public double getCostOfSubProduct(List<Product> products){
        return products.stream().map(Product::getCost).mapToDouble(cost->cost).sum();
    }
    // Main driver method
    public static void main(String args[]) {
        Product product=new Product();
        product.setId(1);
        product.setCost(100.0);
        product.setName("Laptop");
        product.setDescription("it is hp laptop");
        product.setSubProducts(new ArrayList<>());
        System.out.println(product.calculateCost(product));

        Product product1=new Product();
        product1.setId(1);
        product1.setCost(100.0);
        product1.setName("Laptop");
        product1.setDescription("it is hp laptop");
        Product product10=new Product();
        product10.setCost(10);
        product10.setName("mobile");
        product10.setId(10);
        product10.setDescription("it is one plus mobile");
        Product product11=new Product();
        product11.setCost(10);
        product11.setName("mobile");
        product11.setId(10);
        product11.setDescription("it is one plus mobile");
        Product product12=new Product();
        product12.setCost(10);
        product12.setName("mobile");
        product12.setId(10);
        product12.setDescription("it is one plus mobile");
        ArrayList<Product> products=new ArrayList<>();
        products.add(product10);
        products.add(product11);
        products.add(product12);
        product1.setSubProducts(products);
        System.out.println(product.calculateCost(product1));
    }
}
