package com.tati.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tati.dao.YoutubeDAO;
import com.tati.model.YoutubeData;

import jakarta.transaction.Transactional;

@Service
public class YoutubeServiceImpl implements YoutubeService{

	@Autowired
	private YoutubeDAO youtubeDAO;
	
	@Transactional
	public long save(YoutubeData data) {
		return youtubeDAO.save(data);
	}

}
