package com.nag.simpleWebApp.service;

import com.nag.simpleWebApp.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProdutService {

    Product prod1 = new Product(1,"Computer",25000);
    Product prod2 = new Product(2,"Laptop",30000);
    List<Product> products = new ArrayList<>(Arrays.asList(prod1,prod2));

    public List<Product> getProducts(){
        return products;
    }

    public Product getProductById(int productId){
        return products.stream()
                .filter(p->p.getProdId()==productId)
                .findFirst().get();
    }

    public void addProduct(Product prod){
        products.add(prod);
    }

    public Product editById(int id,Product product){

        Product existingProduct = products.stream()
                .filter(p->p.getProdId()==id)
                .findFirst().get();

        existingProduct.setProdName(product.getProdName());
        existingProduct.setPrice(product.getPrice());

        return existingProduct;

    }

    public void deleteById(int id){
        int index=0;
        for(int i = 0;i<products.size();i++){
            if(products.get(i).getProdId()==id){
                index=i;
                break;
            }
        }

        products.remove(products.get(index));

    }
}