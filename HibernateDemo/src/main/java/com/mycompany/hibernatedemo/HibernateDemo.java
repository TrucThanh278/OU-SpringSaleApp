/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.hibernatedemo;

import com.ntt.repository.impl.CategoryRepositoryImpl;
import com.ntt.repository.impl.ProductRepositoryImpl;

/**
 *
 * @author admin
 */
public class HibernateDemo {

    public static void main(String[] args) {
//        CategoryRepositoryImpl s = new CategoryRepositoryImpl();
//        s.getCates().forEach(c -> System.out.println(c.getName()));\

        ProductRepositoryImpl s = new ProductRepositoryImpl();
        s.getProducts(null).forEach(p -> System.out.printf("%s - %s \n", p.getName(), p.getPrice()));
        
    }
}
