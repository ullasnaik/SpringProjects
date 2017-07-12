package net.codejava.spring.dao;

import java.util.List;

import net.codejava.spring.model.MutaionEntry;

public interface MutaionEntryDAO {
	public List<MutaionEntry> list();
	
	public MutaionEntry get(String id);
	
	public void saveOrUpdate(MutaionEntry user);
	
	public void delete(String id);
}