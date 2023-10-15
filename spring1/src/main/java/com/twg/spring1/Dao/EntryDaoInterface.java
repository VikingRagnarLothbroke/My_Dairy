package com.twg.spring1.Dao;

import java.util.List;

import com.twg.spring1.Entities.Entry;

public interface EntryDaoInterface {
	public void save(Entry entry);
	public void update(Entry entry);
	public Entry find(int id);
	public List<Entry> findAll();
	public void delete(Entry entry);
	public List<Entry> FindByUserId(int id);
}
