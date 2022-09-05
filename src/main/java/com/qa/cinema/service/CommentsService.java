package com.qa.cinema.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.cinema.models.Comments;
import com.qa.cinema.repo.CommentsRepo;

@Service
public class CommentsService {

	@Autowired
	private CommentsRepo repo;

	public CommentsService(CommentsRepo repo) {
		this.repo = repo;
	}

	// create comment
	public Comments addComment(Comments newComment) {
		return repo.save(newComment);
	}

	// read comments
	public Comments readCommentById(Long id) {
		return repo.findById(id).get();
	}

	// read all comments
	public List<Comments> readAllComments() {
		return repo.allComments();
	}

	// update comments
	public Comments updateComment(Comments updateComment, Long id) {
		Optional<Comments> currentComment = this.repo.findById(id);
		if (currentComment.get() instanceof Comments) {
			Comments oldComment = currentComment.get();
			oldComment.setCommentAuthor(updateComment.getCommentAuthor());
			oldComment.setCommentContent(updateComment.getCommentContent());
			oldComment.setCommentCreateTime(updateComment.getCommentCreateTime());

			return repo.save(oldComment);
		}
		return null;
	}

	// Delete comment
	public Boolean deleteCommentById(Long id) {
		Optional<Comments> currentBooking = this.repo.findById(id);
		boolean isPresent = (currentBooking.isPresent()) ? true : false;
		if (isPresent) {
			this.repo.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

}
