package org.jpanda.util; 
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
@Repository
public class NativeSqlHelper{
	@PersistenceContext
	private EntityManager entityManager; 
	
	@SuppressWarnings("unchecked")
	public <T>Object getSingal(String sql){ 
		Query query = entityManager.createNativeQuery(sql);
		List<T> list = query.getResultList();  
		if(list!=null && list.size()>0){ 
			Object  o = list.get(0); 
			return o;
		}
		else 
		{
			return null;
		} 
	}
	@SuppressWarnings("unchecked")
	public <T> Object getSingal(String sql,Object[] params){
		Query query = entityManager.createNativeQuery(sql);
		if(params != null && params.length>0){
			for(int i=0;i<params.length;i++)
			{
				query.setParameter(i+1, params[i]);
			}
		}
		List<T> list = query.getResultList();  
		if(list!=null && list.size()>0){ 
			Object  o = list.get(0); 
			return o;
		}
		else 
		{
			return null;
		} 
	}
	@SuppressWarnings("unchecked")
	public <T> Object getSingal(String sql,Object[] params,Class<T> type) {

		Query query = entityManager.createNativeQuery(sql,type);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i + 1, params[i]);
			}
		}
		List<T> list = query.getResultList();
		if (list != null && list.size() > 0) {
			Object o = list.get(0);
			return o;
		} else {
			return null;
		}
	}
	@SuppressWarnings("unchecked")
	public <T> List<T> queryByNativeSQL(String sql,final int... rowStartIdxAndCount){  
		Query query = entityManager.createNativeQuery(sql);
		if (rowStartIdxAndCount != null && rowStartIdxAndCount.length > 0) {
			int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);
			if (rowStartIdx > 0) {
				query.setFirstResult(rowStartIdx);
			} 
			if (rowStartIdxAndCount.length > 1) {
				int rowCount = Math.max(0, rowStartIdxAndCount[1]);
				if (rowCount > 0) {
					query.setMaxResults(rowCount);
				}
			}
		}
		return query.getResultList();
	}
	@SuppressWarnings("unchecked")
	public <T> List<T> queryByNativeSQL(String sql,Object[] params,final int... rowStartIdxAndCount){
		Query query = entityManager.createNativeQuery(sql);
		if(params != null && params.length>0){
			for(int i=0;i<params.length;i++)
			{
				query.setParameter(i+1, params[i]);
			}
		}
		if (rowStartIdxAndCount != null && rowStartIdxAndCount.length > 0) {
			int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);
			if (rowStartIdx > 0) {
				query.setFirstResult(rowStartIdx);
			}

			if (rowStartIdxAndCount.length > 1) {
				int rowCount = Math.max(0, rowStartIdxAndCount[1]);
				if (rowCount > 0) {
					query.setMaxResults(rowCount);
				}
			}
		}
		return query.getResultList();
	}
	@SuppressWarnings("unchecked")
	public  <T> List<T> queryByNativeSQL(String sql,Class<T> type,final int... rowStartIdxAndCount)
	{
		Query query = entityManager.createNativeQuery(sql,type);
		if (rowStartIdxAndCount != null && rowStartIdxAndCount.length > 0) {
			int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);
			if (rowStartIdx > 0) {
				query.setFirstResult(rowStartIdx);
			}

			if (rowStartIdxAndCount.length > 1) {
				int rowCount = Math.max(0, rowStartIdxAndCount[1]);
				if (rowCount > 0) {
					query.setMaxResults(rowCount);
				}
			}
		}
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public  <T> List<T> queryByNativeSQL(String sql,Object[] params,Class<T> type,final int... rowStartIdxAndCount)
	{
		Query query = entityManager.createNativeQuery(sql,type);
		if(params != null && params.length>0){
			for(int i=0;i<params.length;i++)
			{
				query.setParameter(i+1, params[i]);
			}
		} 
		if (rowStartIdxAndCount != null && rowStartIdxAndCount.length > 0) {
			int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);
			if (rowStartIdx > 0) {
				query.setFirstResult(rowStartIdx);
			}

			if (rowStartIdxAndCount.length > 1) {
				int rowCount = Math.max(0, rowStartIdxAndCount[1]);
				if (rowCount > 0) {
					query.setMaxResults(rowCount);
				}
			}
		} 
		return query.getResultList();
	}
	
	public void exeNativeSQL(String sql)
	{ 
		Query query = entityManager.createNativeQuery(sql);		
		query.executeUpdate(); 
	}
	
	public boolean exeNativeSQL(List<Object> sqls){  
		boolean b = false;
		for(Object sql : sqls){
			Query query = entityManager.createNativeQuery(sql.toString());
		    query.executeUpdate();
		} 
		entityManager.flush();
		b = true; 
		return b;
	}
	
	public  int  exeNativeSQL(String sql,Object[] params){
		Query query = entityManager.createNativeQuery(sql);
		if(params != null && params.length>0){
			for(int i=0;i<params.length;i++)
			{
				query.setParameter(i+1, params[i]);
			}
		} 
		return query.executeUpdate(); 
	}
}
