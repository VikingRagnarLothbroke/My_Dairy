package com.twg.spring1.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.twg.spring1.Entities.Entry;
import com.twg.spring1.Entities.User;


@Component
public class EntryDaoImpl implements EntryDaoInterface {
	
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
	public void save(Entry entry) {
		
		hibernateTemplate.save(entry);
	}

	@Override
	public void update(Entry entry) {
	
		hibernateTemplate.update(entry);
		
	}

	@Override
	public Entry find(int id) {
		
		return hibernateTemplate.get(Entry.class, id);
	}

	@Override
	public List<Entry> findAll() {
		
		
		return hibernateTemplate.loadAll(Entry.class);
	}

	@Override
	public void delete(Entry entry) {
		
		hibernateTemplate.delete(entry);
	}

	@Override
	@Transactional
	public List<Entry> FindByUserId(int id) {
		
     DetachedCriteria criteria=DetachedCriteria.forClass(Entry.class);
		
	    criteria.add(Restrictions.eq("id", id));
	    
	    List<Entry> totalentries=null;
	    
	    try {
			totalentries=(List<Entry>)hibernateTemplate.findByCriteria(criteria);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return totalentries;
	}

}    
