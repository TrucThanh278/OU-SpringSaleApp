/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.hibernatedemo;

import com.ntt.pojo.Product;
import com.ntt.repository.impl.CategoryRepositoryImpl;
import com.ntt.repository.impl.ProductRepositoryImpl;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author admin
 */
public class HibernateDemo {

    public static void main(String[] args) {
//        CategoryRepositoryImpl s = new CategoryRepositoryImpl();
//        s.getCates().forEach(c -> System.out.println(c.getName()));\        

//        ProductRepositoryImpl s = new ProductRepositoryImpl();
//        s.getProducts(null).forEach(p -> System.out.printf("%s - %s \n", p.getName(), p.getPrice()));

        Map<String, String> params = new HashMap<>();
//        params.put("q", "iPhone");
//        params.put("fromPrice", "28000000");
//        params.put("cateId", "2");
        params.put("page", "1");

        ProductRepositoryImpl s = new ProductRepositoryImpl();
        s.getProducts(params).forEach(p -> System.out.printf("%s\n", p.getName()));
    }
}
