package com.qa.cinema.test.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.cinema.models.Comments;
import com.qa.cinema.repo.CommentsRepo;
import com.qa.cinema.service.CommentsService;

@SpringBootTest
public class CommentsServiceUnitTest {

	@Autowired
	private CommentsService service;

	@MockBean
	private CommentsRepo repo;

	@Test
	public void createComment_validComment_saveComment() {
		Comments validComment = new Comments(1L, 1L, "content", "time", "author");
		Comments saveComment = new Comments(1L, "content", "time", "author");

		Mockito.when(this.service.addComment(saveComment)).thenReturn(validComment);
		assertEquals(validComment, this.service.addComment(saveComment));
		Mockito.verify(this.repo, Mockito.times(1)).save(saveComment);
	}

	@Test
	public void updateComment_validComment_updateComment() {
		Comments validComment = new Comments(1L, 1L, "content", "time", "author");
		Comments updateComment = new Comments(2L, "content2", "time2", "author2");

		Mockito.when(this.repo.findById(validComment.getCommentId())).thenReturn(Optional.of(validComment));
		this.service.updateComment(updateComment, validComment.getCommentId());

		Mockito.verify(this.repo, Mockito.times(1)).save(validComment);
		Mockito.verify(this.repo, Mockito.times(1)).findById(validComment.getCommentId());
	}

	@Test
	public void deleteComment_comment() {
		Comments validComment = new Comments(1L, 1L, "content", "time", "author");

		Mockito.when(this.repo.findById(validComment.getCommentId())).thenReturn(Optional.of(validComment));
		this.service.deleteCommentById(validComment.getCommentId());
		Mockito.verify(this.repo, Mockito.times(1)).deleteById(validComment.getCommentId());
	}

	@Test
	public void deleteComment_invalidComment_unsuccessful() {
		Comments invalidComment = new Comments();
		invalidComment.setCommentId(56L);
		invalidComment.setCommentCreateTime("time");

		Mockito.when(this.repo.findById(invalidComment.getCommentId())).thenReturn(Optional.ofNullable(null));
		this.service.deleteCommentById(invalidComment.getCommentId());
	}

	@Test
	public void readComments_validComment_Comments(Long topic_id) {
		List<Comments> comments = new ArrayList<>();
		comments.add(new Comments(1L, 1L, "content", "time", "author"));
		Mockito.when(this.service.readAllComments(topic_id)).thenReturn(comments);
		assertEquals(comments, this.service.readAllComments(topic_id));
		Mockito.verify(this.repo, Mockito.times(1)).topicComments(topic_id);
	}

	@Test
	public void readOneComment_validComment_oneComment() {
		Comments validComment = new Comments(1L, 1L, "content", "time", "author");
		Mockito.when(this.repo.findById(validComment.getCommentId())).thenReturn(Optional.of(validComment));
		assertThat(this.service.readCommentById(validComment.getCommentId())).isEqualTo(validComment);
		Mockito.verify(this.repo, Mockito.times(1)).findById(validComment.getCommentId());
	}
}
