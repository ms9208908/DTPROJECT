package com.niit.backend.daoimpl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.dao.ProductDao;
import com.niit.backend.dto.Category;
import com.niit.backend.dto.Product;



@Repository("productDao")
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;

	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Transactional
	public boolean insertProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(product);
			return true;
		}
		catch(Exception e){
			System.out.println(e);
			return false;
			
		}
	}

	@Transactional
	public boolean updateProduct(Product product) {
		Session session=getSession();
		
		
		session.update(product);
		return true;
	}

	@Transactional
	public boolean deleteProduct(int productId) {
		Session session=getSession();
		Product product=session.get(Product.class, productId);
		product.setStatus("Deactive");
		session.update(product);
		return true;
	}

	@Transactional
	public Product getProductById(int productId) {
		Product product=getSession().get(Product.class, productId);
		return product;
	}

	
	@Transactional
	@Override
	public List<Product> getProducts() {
		
		@SuppressWarnings("unchecked")
		TypedQuery<Product> query=
		getSession().createQuery("from com.niit.backend.dto.Product where status='Active'");
		List<Product> list=query.getResultList();
		System.out.println("List of Products : "+list);
		return list;
		
	}

	@Transactional
	@Override
	public List<Product> getProducts(String category) {
		@SuppressWarnings("unchecked")
		TypedQuery<Product> query=getSession().createQuery("from com.niit.backend.dto.Product where category.categoryName=:a");
		query.setParameter("a",category);
		List<Product> list=query.getResultList();
		System.out.println("List of Products : "+list);
		return list;
	}

	@Override
	@Transactional
	public int getQuantity(int productId) {
		@SuppressWarnings("unchecked")
		TypedQuery<Product> query=getSession().createQuery("from com.niit.backend.dto.Product where productId=:a");
		query.setParameter("a",productId);
		List<Product> list=query.getResultList();
		return list.get(0).getQuantity();
	}

	@Override
	@Transactional
	public void updateQuantity(int productId, int newQuantity) {
		@SuppressWarnings("unchecked")
		TypedQuery<Product> query=getSession().createQuery("update com.niit.backend.dto.Product set quantity=quantity-:b where productId=:a");
		query.setParameter("b",newQuantity);
		query.setParameter("a",productId);
		query.executeUpdate();
		
	}

}



















