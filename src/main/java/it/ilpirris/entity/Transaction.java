package it.ilpirris.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Transaction {
	
	private User sender;
	private User receiver;
	private int amount;
	
	public Transaction(User sender, User receiver, int amount)
	{	
		this.sender = sender;
		this.receiver = receiver;
		this.amount = amount;
	}
	
	public User getReceiver() {
		return receiver;
	}
	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}
	public User getSender() {
		return sender;
	}
	public void setSender(User sender) {
		this.sender = sender;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@JsonIgnore
	public String getAggregate()
	{
		return sender.getName()+receiver.getName()+amount;
	}

}
