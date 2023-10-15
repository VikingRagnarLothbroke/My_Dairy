package com.twg.spring1.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import com.twg.spring1.Entities.User;


@Component
public class UserDaoImpl implements UserDaoInterface {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	@Transactional
	public void save(User user) {
	
		hibernateTemplate.save(user);
	}

	@Override
	public void update(User user) {
		
		hibernateTemplate.update(user);
		
	}

	@Override
	@Transactional
	public List<User> finaAll() {
		
		return hibernateTemplate.loadAll(User.class);
	}

	@Override
	public void delete(User user) {
		hibernateTemplate.delete(user);
		
	}

	@Override
	@Transactional
	public User find(User user) {
		
		return hibernateTemplate.get(User.class, getClass());
	}

	@Override
	public User findByname(String username) {
		
		DetachedCriteria criteria=DetachedCriteria.forClass(User.class);
		
	    criteria.add(Restrictions.eq("name", username));
		
		User user=null;
		
		try {
			user=(User)hibernateTemplate.findByCriteria(criteria).get(0);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

}
