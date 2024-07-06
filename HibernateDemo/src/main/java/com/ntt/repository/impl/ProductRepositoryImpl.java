/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntt.repository.impl;

import com.mycompany.hibernatedemo.HibernateUtils;
import com.ntt.pojo.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author admin
 */
public class ProductRepositoryImpl {
    public List<Product> getProducts(Map<String, String> params) {
        try (Session s = HibernateUtils.getFactory().openSession()){
            CriteriaBuilder b = s.getCriteriaBuilder();
            CriteriaQuery<Product> q = b.createQuery(Product.class);
            
            Root root = q.from(Product.class);
            q.select(root);
            
            
            List<Predicate> predicates = new ArrayList<>();
            
            //Search by product name
            String kw = params.get("q");
            if (kw != null && !kw.isEmpty()){
                Predicate p1 = b.like(root.get("name"), String.format("%%%s%%", kw));
                q.where(p1);
            }
            
            
            String fromPrice = params.get("fromPrice");
            if (fromPrice != null && !fromPrice.isEmpty()){
                Predicate p2 = b.greaterThanOrEqualTo(root.get("price"), Double.parseDouble(fromPrice));
                predicates.add(p2);
            }
            
            String toPrice = params.get("toPrice");
            if (toPrice != null && !toPrice.isEmpty()){
                Predicate p3 = b.greaterThanOrEqualTo(root.get("price"), Double.parseDouble(fromPrice));
                predicates.add(p3);
            }
            
            String cateId = params.get("cateId");
            if (cateId != null & !cateId.isEmpty()){
                Predicate p4 = b.equal(root.get("category"), Integer.parseInt(cateId));
                predicates.add(p4);
            }
            
            q.where(predicates.toArray(Predicate[]::new));
            
            Query query = s.createQuery(q);
            return query.getResultList();
        }
    }
}
