package com.twg.spring1.Business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.twg.spring1.Dao.EntryDaoInterface;
import com.twg.spring1.Entities.Entry;


@Component
public class EntryBusinessImpl implements EntryBusinessInterface {
	
	@Autowired
	private EntryDaoInterface entryDaoInterface;

	public EntryDaoInterface getEntryDaoInterface() {
		return entryDaoInterface;
	}

	public void setEntryDaoInterface(EntryDaoInterface entryDaoInterface) {
		this.entryDaoInterface = entryDaoInterface;
	}

	@Override
	public void save(Entry entry) {
		
		entryDaoInterface.save(entry);
	}

	@Override
	public void update(Entry entry) {
		
		entryDaoInterface.update(entry);
	}

	@Override
	public Entry find(int id) {
		
		return entryDaoInterface.find(id);
	}

	@Override
	public List<Entry> findAll() {
		
		return entryDaoInterface.findAll();
	}

	@Override
	public void delete(Entry entry) {
		
		entryDaoInterface.delete(entry);
	}

	@Override
	public List<Entry> FindByUserId(int id) {
		// TODO Auto-generated method stub
		return entryDaoInterface.FindByUserId(id);
	}

}
