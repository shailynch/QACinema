package com.qa.cinema.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.cinema.models.Comments;

@Repository
public interface CommentsRepo extends JpaRepository<Comments, Long> {

	@Query(value = "SELECT * FROM FORUM_COMMENTS", nativeQuery = true)
	public List<Comments> allComments();

	@Query(value = "SELECT * FROM FORUM_COMMENTS WHERE topic_id = ?1", nativeQuery = true)
	public List<Comments> topicComments();

}
