package com.example.BootDemoApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.BootDemoAp.model.Topic;
import com.example.BootDemoApp.service.TpicService;

@RestController
@RequestMapping("/topic")
public class TopicController {
	@Autowired
	private TpicService topicService;

	@RequestMapping("/index")
	public List<Topic> topics() {
		return topicService.getAllTopics();
	}

	@RequestMapping("/get-topic/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@RequestBody Topic topic) {
		topicService.addTopic(topic);
		return "Topic is created";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public String create(@RequestBody Topic topic, @PathVariable String id) {
		topicService.updateTopic(topic, id);
		return "Topic is updated";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public String deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
		return "Topic is deleted";
	}
}
