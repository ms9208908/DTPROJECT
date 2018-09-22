package com.niit.backend.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.dao.ItemDAO;
import com.niit.backend.dto.Item;


@Repository("itemDAO")
@Transactional
public class ItemDAOImpl implements ItemDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	@Override
	public boolean addItem(Item item) {
		try{
		Session session=getSession();
		session.save(item);
		return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateItem(Item item) {
		try{
		Session session=getSession();
		session.update(item);
		return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Item getItemByProductIdAndCustomerId(int productid, String customerId) {
		try{
		Session session=getSession();
		Query query=session.createQuery
		("from Item where  customerId=:cId");
		
		query.setParameter("cId",customerId);
		List<Item> items=query.list();
		System.out.println("items : "+items);
		if(!items.isEmpty()){
			
			Item item= items.get(0);
			if(item.getProduct().getProductId()==productid){
				return item;
			}
			else {
				return null;
			}
		}
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public List<Item> getItemsListByCart(int cartId) {
		Session session = getSession();
		try{
			String hql = "From com.niit.backend.dto.Item where cart_cartid = :cartId";
			Query query = session.createQuery(hql);
			query.setParameter("cartId", cartId);
			List<Item> results = (List<Item>)query.getResultList();
			return results;
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
			return null;
		}
	}

	public boolean increaseQuantity(int itemId) {
		Session session = sessionFactory.getCurrentSession();
		try{
			Item item = session.get(Item.class, itemId);
			item.setQuantity(item.getQuantity()+1);
			session.update(item);
			return true;
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
	}

	public boolean decreaseQuantity(int itemId) {
		Session session = sessionFactory.getCurrentSession();
		try{
			Item item = session.get(Item.class, itemId);
			item.setQuantity(item.getQuantity()-1);
			session.update(item);
			return true;
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
		
	}

	public boolean deleteItem(int itemId) {
		Session session = sessionFactory.getCurrentSession();
		try{
			Item item = session.get(Item.class, itemId);
			
			session.delete(item);
			return true;
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
			return false;
		}
	}
	

}
