package model;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity(name = "CONVERSTAIONS")
public class Conversation {
	
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE)
	private BigInteger conversationId;
	
	@ManyToMany
	private List<User> members;
	
	@OneToMany
	private List<Message> messages;

	public BigInteger getConversationId() {
		return conversationId;
	}

	public void setConversationId(BigInteger conversationId) {
		this.conversationId = conversationId;
	}

	public List<User> getMembers() {
		return members;
	}

	public void setMembers(List<User> members) {
		this.members = members;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
}
