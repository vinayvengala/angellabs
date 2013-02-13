package co.angellabs.profileservices.dao.impl;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import co.angellabs.entities.dto.User;

import co.angellabs.profileservices.dao.UserBasicServicesDAO;


public class UserBasicServicesDAOImpl implements UserBasicServicesDAO  {

	@Autowired
	private SessionFactory sessionFactory;
	//@Autowired
	//private HibernateTemplate hibernateTemplate;
	
	
	@Transactional
	public boolean saveUser(User user) {
		
		sessionFactory.getCurrentSession().save(user);
		return true;

	}
	@Transactional
	public User validateUser(int user_id) {

		String sqlqry="UPDATE users SET enabled=1 WHERE user_id="+user_id+"";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sqlqry);
		query.executeUpdate();
		Object obj=sessionFactory.getCurrentSession().get(User.class, user_id);
		
		return (User)obj;
	}

}
