package com.qa.cinema.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.cinema.models.Comments;
import com.qa.cinema.service.CommentsService;

@RestController
@RequestMapping("/comments")
public class CommentsController {

	private final CommentsService service;

	public CommentsController(CommentsService service) {
		this.service = service;
	}

	// get all comments
	@GetMapping("/all")
	public List<Comments> getAllComments() {
		return service.readAllComments();
	}

	// add new comment
	@CrossOrigin
	@PostMapping("/add")
	public ResponseEntity<Comments> newComment(@RequestBody Comments comment) {
		Comments createComment = service.addComment(comment);
		return new ResponseEntity<Comments>(createComment, HttpStatus.CREATED);
	}

	// read Comment by Id
	@GetMapping("/{id}")
	public Comments readCommentById(@PathVariable Long id) {
		return service.readCommentById(id);
	}

	// update Comment by ID
	public ResponseEntity<Comments> updateCommentsById(@PathVariable("comment_id") Long Id,
			@RequestBody Comments comment) {
		Comments updateComment = this.service.updateComment(comment, Id);
		return new ResponseEntity<Comments>(updateComment, HttpStatus.OK);

	}

	// delete Comment by Id
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteComment(@PathVariable Long id) {
		return new ResponseEntity<Boolean>(this.service.deleteCommentById(id), HttpStatus.NO_CONTENT);
	}

}
