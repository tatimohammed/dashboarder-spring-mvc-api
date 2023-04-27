package com.tati.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "YoutubeData")
public class YoutubeData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String videoTitle;

	private String publishedAt;
	
	private String viewCount;
	
	private String likeCount;
	
	private String commentCount;
	
	private String engagementRate;
	
	private String channelTitle;
	
	private String videoPopularTitle;
	
	private String videoPopularLink;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVideoTitle() {
		return videoTitle;
	}

	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}

	public String getPublishedAt() {
		return publishedAt;
	}

	public void setPublishedAt(String publishedAt) {
		this.publishedAt = publishedAt;
	}

	public String getViewCount() {
		return viewCount;
	}

	public void setViewCount(String viewCount) {
		this.viewCount = viewCount;
	}

	public String getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(String likeCount) {
		this.likeCount = likeCount;
	}

	public String getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(String commentCount) {
		this.commentCount = commentCount;
	}

	public String getEngagementRate() {
		return engagementRate;
	}

	public void setEngagementRate(String engagementRate) {
		this.engagementRate = engagementRate;
	}

	public String getChannelTitle() {
		return channelTitle;
	}

	public void setChannelTitle(String channelTitle) {
		this.channelTitle = channelTitle;
	}

	public String getVideoPopularTitle() {
		return videoPopularTitle;
	}

	public void setVideoPopularTitle(String videoPopularTitle) {
		this.videoPopularTitle = videoPopularTitle;
	}

	public String getVideoPopularLink() {
		return videoPopularLink;
	}

	public void setVideoPopularLink(String videoPopularLink) {
		this.videoPopularLink = videoPopularLink;
	}

	@Override
	public String toString() {
		return "YoutubeData [id=" + id + ", videoTitle=" + videoTitle + ", publishedAt=" + publishedAt + ", viewCount="
				+ viewCount + ", likeCount=" + likeCount + ", commentCount=" + commentCount + ", engagementRate="
				+ engagementRate + ", channelTitle=" + channelTitle + ", videoPopularTitle=" + videoPopularTitle
				+ ", videoPopularLink=" + videoPopularLink + "]";
	}
	
	

}
