package com.shilong.oa.domain;

import java.util.HashSet;
import java.util.Set;

public class Forum {
		private Long id;
		private String name;
		private String description;
		private int position;
		private Set<Topic> topics=new HashSet<Topic>();
		private Topic lastTopic;
		private int articleCount;
		private int topicCount;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public int getPosition() {
			return position;
		}
		public void setPosition(int position) {
			this.position = position;
		}
		public Set<Topic> getTopics() {
			return topics;
		}
		public void setTopics(Set<Topic> topics) {
			this.topics = topics;
		}
		public Topic getLastTopic() {
			return lastTopic;
		}
		public void setLastTopic(Topic lastTopic) {
			this.lastTopic = lastTopic;
		}
		public int getArticleCount() {
			return articleCount;
		}
		public void setArticleCount(int articleCount) {
			this.articleCount = articleCount;
		}
		public int getTopicCount() {
			return topicCount;
		}
		public void setTopicCount(int topicCount) {
			this.topicCount = topicCount;
		}
		
}
