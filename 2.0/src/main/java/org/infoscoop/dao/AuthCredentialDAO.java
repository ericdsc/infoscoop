package org.infoscoop.dao;

import java.util.List;


import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.infoscoop.dao.model.AuthCredential;
import org.infoscoop.util.SpringUtil;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class AuthCredentialDAO extends HibernateDaoSupport{
	public static AuthCredentialDAO newInstance(){
		return (AuthCredentialDAO)SpringUtil.getContext().getBean("authCredentialDAO");        
	}
	
	public AuthCredential get(Long id){
		return (AuthCredential)super.getHibernateTemplate().get(AuthCredential.class, id);
	}

	public AuthCredential select(String uid, String authType, String authUid){
		List results = super.getHibernateTemplate().findByCriteria(
				DetachedCriteria.forClass(AuthCredential.class).add(
						Expression.conjunction()
						.add(Expression.eq("Uid", uid))
						.add(Expression.eq("AuthType", authType))
						.add(Expression.eq("AuthUid", authUid))
						)
						);	
		if(results.isEmpty()){
			return null;
		}else{
			return (AuthCredential)results.get(0);
		}
	}

	public AuthCredential select(String uid, Integer sysNum){
		List results = super.getHibernateTemplate().findByCriteria(
				DetachedCriteria.forClass(AuthCredential.class).add(
						Expression.conjunction()
						.add(Expression.eq("Uid", uid))
						.add(Expression.eq("SysNum", sysNum))
						)
						);	
		if(results.isEmpty()){
			return null;
		}else{
			return (AuthCredential)results.get(0);
		}
	}
	
	public Long add(AuthCredential c){
		return (Long)super.getHibernateTemplate().save(c);
	}

	public void update(AuthCredential c){
		super.getHibernateTemplate().update(c);	
	}
	
	public List select(String uid){
		return super.getHibernateTemplate().findByCriteria(
				DetachedCriteria.forClass(AuthCredential.class).add(Expression.eq("Uid", uid)).addOrder(Order.asc("SysNum")).addOrder(Order.asc("id"))
		);
	}
	
	public void delete(AuthCredential c){
		super.getHibernateTemplate().delete(c);	
	}
	
}
