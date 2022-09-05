package com.qa.cinema.test.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.qa.cinema.controllers.CommentsController;
import com.qa.cinema.models.Comments;
import com.qa.cinema.repo.CommentsRepo;
import com.qa.cinema.service.CommentsService;

@SpringBootTest
public class CommentsControllerUnitTest {

	@Autowired
	private CommentsController controller;

	@MockBean
	private CommentsService service;

	@MockBean
	private CommentsRepo repo;

	@Test
	public void createNewCommentTest() {
		Comments validComment = new Comments(1L, 1L, "content", "time", "author");
		Mockito.when(this.service.addComment(validComment)).thenReturn(validComment);
		ResponseEntity<Comments> response = new ResponseEntity<Comments>(validComment, HttpStatus.CREATED);
		assertThat(response).isEqualTo(controller.newComment(validComment));
		Mockito.verify(this.service, Mockito.times(1)).addComment(validComment);
	}

	@Test
	public void getAllCommentsTest() {
		Comments validComment = new Comments(1L, 1L, "content", "time", "author");
		List<Comments> comments = new ArrayList<>();
		comments.add(validComment);
		Mockito.when(this.service.readAllComments()).thenReturn(comments);
		assertThat(comments).isEqualTo(controller.getAllComments());
		Mockito.verify(this.service, Mockito.times(1)).readAllComments();
	}

	@Test
	public void getCommentsByIdTest() {
		Comments validComment = new Comments(1L, 1L, "content", "time", "author");
		List<Comments> comments = new ArrayList<>();
		comments.add(validComment);
		Mockito.when(this.service.readCommentById(validComment.getCommentId())).thenReturn(comments.get(0));
		Comments value = comments.get(0);
		assertThat(value).isEqualTo(controller.readCommentById(validComment.getCommentId()));
		Mockito.verify(this.service, Mockito.times(1)).readCommentById(validComment.getCommentId());
	}

	@Test
	public void updateCommentById() {
		Comments validComment = new Comments(1L, 1L, "content", "time", "author");
		List<Comments> comments = new ArrayList<>();
		comments.add(validComment);
		Comments updateComment = new Comments(2L, "content2", "time2", "author2");
		Mockito.when(this.service.updateComment(updateComment, validComment.getCommentId())).thenReturn(validComment);
		ResponseEntity<Comments> response = new ResponseEntity<Comments>(validComment, HttpStatus.OK);
		assertThat(response).isEqualTo(controller.updateCommentsById(validComment.getCommentId(), updateComment));
		Mockito.verify(this.service, Mockito.times(1)).updateComment(updateComment, validComment.getCommentId());
	}

	@Test
	public void deleteCommentTest() {
		Comments validComment = new Comments(1L, 1L, "content", "time", "author");
		List<Comments> comments = new ArrayList<>();
		comments.add(validComment);

		Mockito.when(this.service.deleteCommentById(validComment.getCommentId())).thenReturn(true);
		ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(true, HttpStatus.NO_CONTENT);
		assertThat(response).isEqualTo(controller.deleteComment(validComment.getCommentId()));
		Mockito.verify(this.service, Mockito.times(1)).deleteCommentById(validComment.getCommentId());
	}

}
