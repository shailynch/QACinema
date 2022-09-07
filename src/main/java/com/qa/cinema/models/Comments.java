package com.qa.cinema.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comments {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long commentId;

	@Column
	private Long topicId;
	@Column
	private String commentContent;
	@Column
	private String commentCreateTime;
	@Column
	private String commentAuthor;

	public Comments(Long commentId, Long topicId, String commentContent, String commentCreateTime,
			String commentAuthor) {
		super();
		this.commentId = commentId;
		this.topicId = topicId;
		this.commentContent = commentContent;
		this.commentCreateTime = commentCreateTime;
		this.commentAuthor = commentAuthor;
	}

	public Comments(Long topicId, String commentContent, String commentCreateTime, String commentAuthor) {
		super();
		this.topicId = topicId;
		this.commentContent = commentContent;
		this.commentCreateTime = commentCreateTime;
		this.commentAuthor = commentAuthor;
	}

	public Comments() {
		super();
	}

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public Long getTopicId() {
		return topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getCommentCreateTime() {
		return commentCreateTime;
	}

	public void setCommentCreateTime(String commentCreateTime) {
		this.commentCreateTime = commentCreateTime;
	}

	public String getCommentAuthor() {
		return commentAuthor;
	}

	public void setCommentAuthor(String commentAuthor) {
		this.commentAuthor = commentAuthor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(commentAuthor, commentContent, commentCreateTime, topicId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comments other = (Comments) obj;
		return Objects.equals(commentAuthor, other.commentAuthor)
				&& Objects.equals(commentContent, other.commentContent)
				&& Objects.equals(commentCreateTime, other.commentCreateTime) && Objects.equals(topicId, other.topicId);
	}

	@Override
	public String toString() {
		return "Comments [topicId=" + topicId + ", commentContent=" + commentContent + ", commentCreateTime="
				+ commentCreateTime + ", commentAuthor=" + commentAuthor + "]";
	}

}
