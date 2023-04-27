package com.tati.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tati.model.YoutubeData;
import com.tati.service.YoutubeService;
import com.tati.utils.YoutubeAPI;

import java.util.List;

@RestController
public class YoutubeAPIController {
	
	@Autowired
	private YoutubeService youtubeService;
	
	
	
	@PostMapping("/api/data")
	public YoutubeData add(@RequestParam(name= "url") String url){
		if (url != null) {
			YoutubeAPI youtube = new YoutubeAPI();
			List<String> videoData = youtube.getVideoData(url);
			
			YoutubeData dataHolder= new YoutubeData();
			dataHolder.setVideoTitle(videoData.get(0));
			dataHolder.setPublishedAt(videoData.get(1));
			dataHolder.setViewCount(videoData.get(2));
			dataHolder.setLikeCount(videoData.get(3));
			dataHolder.setCommentCount(videoData.get(4));
			dataHolder.setEngagementRate(videoData.get(5));
			dataHolder.setChannelTitle(videoData.get(6));
			dataHolder.setVideoPopularTitle(videoData.get(7));
			dataHolder.setVideoPopularLink(videoData.get(8));
			
			youtubeService.save(dataHolder);
			
			return dataHolder;
		} else {
			return null;
		}
		
		
	}
}
