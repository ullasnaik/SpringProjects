package net.codejava.spring.dao;

import java.util.List;

import net.codejava.spring.model.MutaionEntry;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class MutaionEntryDAOImpl implements MutaionEntryDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public MutaionEntryDAOImpl() {
		
	}
	
	public MutaionEntryDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<MutaionEntry> list() {
		@SuppressWarnings("unchecked")
		List<MutaionEntry> listUser = (List<MutaionEntry>) sessionFactory.getCurrentSession()
				.createCriteria(MutaionEntry.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listUser;
	}

	@Override
	@Transactional
	public void saveOrUpdate(MutaionEntry user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	@Override
	@Transactional
	public void delete(String mutationEntryNo) {
		MutaionEntry userToDelete = new MutaionEntry();
		userToDelete.setMutationEntryNo(mutationEntryNo);
		sessionFactory.getCurrentSession().delete(userToDelete);
	}

	@Override
	@Transactional
	public MutaionEntry get(String mutationEntryNo) {
		String hql = "from User where id=" + mutationEntryNo;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<MutaionEntry> listUser = (List<MutaionEntry>) query.list();
		
		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		}
		
		return null;
	}
}