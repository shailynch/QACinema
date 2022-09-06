package com.qa.models.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.qa.cinema.models.Comments;

import nl.jqno.equalsverifier.EqualsVerifier;

public class CommentsUnitTest {

	static Comments comment;

	@BeforeAll
	public static void createComment() {
		System.out.println("Creating Comment");
		comment = new Comments(1L, 1L, "test comment", "10:46", "Dan");
	}

	@Test
	public void testEquals() {
		EqualsVerifier
				.simple().forClass(Comments.class).withPrefabValues(Comments.class,
						new Comments(1L, "test", "10:47", "Dan"), new Comments(2L, "test2", "10:48", "Harrison"))
				.verify();
	}

	@Test
	public void testToString() {
		String expecting = "Comments [topicId=" + comment.getTopicId() + ", commentContent="
				+ comment.getCommentContent() + ", commentCreateTime=" + comment.getCommentCreateTime()
				+ ", commentAuthor=" + comment.getCommentAuthor() + "]";
		assertEquals(expecting, comment.toString());
	}

	@Test
	public void constructorTests() {
		Comments comment1 = new Comments();
		Comments comment2 = new Comments(1L, "string", "time", "author");
		Comments comment3 = new Comments(2L, 2L, "test2", "time2", "author2");

		assertTrue(comment1 instanceof Comments == true);
		assertTrue(comment2 instanceof Comments == true);
		assertTrue(comment3 instanceof Comments == true);
	}

	@Test
	public void setIdTest()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Comments testComment = new Comments();
		testComment.setCommentId(5L);

		Field expected = testComment.getClass().getDeclaredField("commentId");
		expected.setAccessible(true);
		assertEquals(expected.get(testComment), 5L);

	}

	@Test
	public void setTopicIdTest()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Comments testComment = new Comments();
		testComment.setTopicId(5L);

		Field expected = testComment.getClass().getDeclaredField("topicId");
		expected.setAccessible(true);
		assertEquals(expected.get(testComment), 5L);

	}

	@Test
	public void setContentTest()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Comments testComment = new Comments();
		testComment.setCommentContent("content");

		Field expected = testComment.getClass().getDeclaredField("commentContent");
		expected.setAccessible(true);
		assertEquals(expected.get(testComment), "content");

	}

	@Test
	public void setCreateTimeTest()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Comments testComment = new Comments();
		testComment.setCommentCreateTime("time");

		Field expected = testComment.getClass().getDeclaredField("commentCreateTime");
		expected.setAccessible(true);
		assertEquals(expected.get(testComment), "time");

	}

	@Test
	public void setAuthorTest()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Comments testComment = new Comments();
		testComment.setCommentAuthor("author");

		Field expected = testComment.getClass().getDeclaredField("commentAuthor");
		expected.setAccessible(true);
		assertEquals(expected.get(testComment), "author");

	}
}
