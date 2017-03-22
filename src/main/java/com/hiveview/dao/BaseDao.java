package com.hiveview.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface BaseDao<T> {

	public Integer save(T t);

	public Integer delete(T t);

	public T get(T t);

	public List<T> getList(T t);

	public Integer update(T t);

	public int count(T t);
	
	public List<T> getPagin(T t);
	
	public Integer getCount(T t);
}