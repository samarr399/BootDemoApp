package com.example.BootDemoAp.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
@Component
public interface topicRepository extends CrudRepository<Topic, String> {
	public Optional<Topic> findById(String id);
}
