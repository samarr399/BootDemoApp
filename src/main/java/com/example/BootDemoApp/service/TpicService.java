package com.example.BootDemoApp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.BootDemoAp.model.Topic;
import com.example.BootDemoAp.model.topicRepository;

@Service
public class TpicService {
	@Autowired
	private topicRepository repo;

	private List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic("Html", "HTML", "Design Language"),
			new Topic("Javascript", "JS", "Beutification Language"), new Topic("Java", "Java", "Backend Language"),
			new Topic("Sql", "SQL", "Database Language")));

	public List<Topic> getAllTopics() {
		return topics;
	}

	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public String addTopic(Topic topic) {
		repo.save(topic);
		return "Topic is created";
	}

	public void updateTopic(Topic topic, String id) {
		for (int i = 0; i < topics.size(); i++) {
			Topic t = topics.get(i);
			if (t.getId().equals(id)) {
				topics.set(i, topic);
			}
		}
	}

	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));
	}
}
