package model;

import java.util.Date;

import model.enums.MessageStatus;

public class Message {
	private User author;
	private Conversation conversation;
	private Date timeOfCreation;
	private String content;
	private MessageStatus status;

}
