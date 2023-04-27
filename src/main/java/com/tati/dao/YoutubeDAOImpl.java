package com.tati.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tati.model.YoutubeData;

@Repository
public class YoutubeDAOImpl implements YoutubeDAO{
	
	@Autowired
	private SessionFactory sf;

	public long save(YoutubeData data) {
		sf.getCurrentSession().save(data);
		return data.getId();
	}

}
