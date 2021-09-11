package com.account.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.account.driver.JPAUtil;
import com.account.dto.Laptop;


public class LaptopDaoImpl implements LaptopDao {
	private EntityManager em;
	public LaptopDaoImpl() {
		// TODO Auto-generated constructor stub
		em=JPAUtil.getEntityManager();
	}
	@Override
	public void commitTransation() {
		// TODO Auto-generated method stub
		em.getTransaction().commit();
	}

	@Override
	public void beginTransation() {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
	}

	@Override
	public void addLaptop(Laptop laptop) {
		// TODO Auto-generated method stub
		em.persist(laptop);
	}

	@Override
	public long getLaptopCount() {
		// TODO Auto-generated method stub
		String qstr="SELECT count(laptop.id) From Laptop laptop";
		TypedQuery<Long> query=em.createQuery(qstr,Long.class);
		Long count=query.getSingleResult();
		return count;
	}

	@Override
	public List<Laptop> getAllLaptop() {
		// TODO Auto-generated method stub
		Query query=em.createNamedQuery("getAllBooks");
		return query.getResultList();
	}

	@Override
	public Laptop getLaptopById(int id) {
		// TODO Auto-generated method stub
		return em.find(Laptop.class, id);
	}

	@Override
	public List<Laptop> getLaptopBySpecification(String Spec) {
		// TODO Auto-generated method stub
		String qstr="SELECT laptop FROM Laptop laptop WHERE laptop.lapSpecification LIKE :pspec";
		TypedQuery<Laptop> query=em.createQuery(qstr,Laptop.class);
		query.setParameter("pspec", "%"+Spec+"%");
		return query.getResultList();
	}

	@Override
	public List<Laptop> getLaptopByType(String Type) {
		// TODO Auto-generated method stub
		String qstr="SELECT laptop FROM Laptop laptop WHERE laptop.lapType LIKE :ptype";
		TypedQuery<Laptop> query=em.createQuery(qstr,Laptop.class);
		query.setParameter("ptype", "%"+Type+"%");
		return query.getResultList();
	}

}
