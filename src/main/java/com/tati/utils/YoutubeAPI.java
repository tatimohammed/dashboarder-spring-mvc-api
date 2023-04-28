package com.tati.utils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;
import com.google.api.services.youtube.model.Video;
import com.google.api.services.youtube.model.VideoSnippet;
import com.google.api.services.youtube.model.VideoStatistics;

import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class YoutubeAPI {
	private static final String APPLICATION_NAME = "Youtube API Java Sample";
	private static final String API_KEY = "YOUR_API_KEY";

	// Getting Video data based on the URL
	public List<String> getVideoData(String url) {

		String videoId = null;

		Pattern pattern = Pattern.compile("^https://www\\.youtube\\.com/watch\\?v=([^&]+).*");
		Matcher matcher = pattern.matcher(url);
		if (matcher.matches()) {
			videoId = matcher.group(1);
		} else {
			videoId = url.substring(url.lastIndexOf("/") + 1);
		}

		// List to store the video data
		List<String> list = new ArrayList<String>();

		try {
			// Set up the API client
			YouTube youtube = new YouTube.Builder(GoogleNetHttpTransport.newTrustedTransport(),
					GsonFactory.getDefaultInstance(), null).setApplicationName(APPLICATION_NAME).build();

			// Fetch the video data using the video ID and API key
			com.google.api.services.youtube.YouTube.Videos.List videosListByIdRequest = youtube.videos()
					.list("snippet, contentDetails, statistics");
			videosListByIdRequest.setKey(API_KEY);
			videosListByIdRequest.setId(videoId);
			Video video = videosListByIdRequest.execute().getItems().get(0);

			// Get the video data
			VideoSnippet snippet = video.getSnippet();
			VideoStatistics statistics = video.getStatistics();

			// Channel Data ----------------------------------

			// Id
			String channelID = snippet.getChannelId();
			// Call the search().list method to retrieve the most popular video in the
			// channel
			YouTube.Search.List searchListRequest = youtube.search().list("id,snippet");
			searchListRequest.setChannelId(channelID);
			searchListRequest.setType("video");
			searchListRequest.setFields("items(id(videoId),snippet(title))");
			searchListRequest.setOrder("viewCount");
			searchListRequest.setMaxResults(1L);
			SearchListResponse response = searchListRequest.setKey(API_KEY).execute();

			// Retrieve the video ID and title of the most popular video
			java.util.List<SearchResult> items1 = response.getItems();
			String videoPopularTitle = items1.get(0).getSnippet().getTitle();
			String videoPopularId = items1.get(0).getId().getVideoId();
			String videoLink = "https://www.youtube.com/watch?v=" + videoPopularId;

			// Title
			String channelTitle = snippet.getChannelTitle();

			// Video Data ----------------------------------

			// Video Title
			String videoTitle = snippet.getTitle();

			// published At
			String publishedTime = snippet.getPublishedAt().toString();
			LocalDateTime publishedDateTime = LocalDateTime.parse(publishedTime, DateTimeFormatter.ISO_DATE_TIME);

			// Format the LocalDateTime object using a custom DateTimeFormatter
			String publishedAt = publishedDateTime.format(DateTimeFormatter.ofPattern("MMMM d, yyyy 'at' hh:mm a"));

			// View Count
			BigInteger view_count = statistics.getViewCount();
			String viewCount = view_count.toString();

			// Like Count
			BigInteger like_count = statistics.getLikeCount();
			String likeCount = like_count.toString();

			// Comment Count
			BigInteger comment_count = statistics.getCommentCount();
			String commentCount = comment_count.toString();

			// Engagement Rate
			BigInteger total_interactions = like_count.add(comment_count);
			Double engagement_rate = (total_interactions.doubleValue() / view_count.doubleValue()) * 100;
			String engagementRate = String.format("%.2f", engagement_rate);

			// Add data to the list
			// list = [Title, Published At, View Count, Like Count, Comment Count,
			// engagement_rate,Channel name, Most popular video title, Most popular video
			// link]
			list.add(videoTitle.replaceAll("&#39;", "'"));
			list.add(publishedAt);
			list.add(viewCount);
			list.add(likeCount);
			list.add(commentCount);
			list.add(engagementRate);
			list.add(channelTitle.replaceAll("&#39;", "'"));
			list.add(videoPopularTitle.replaceAll("&#39;", "'"));
			list.add(videoLink);

			return list;

		} catch (GeneralSecurityException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

}
