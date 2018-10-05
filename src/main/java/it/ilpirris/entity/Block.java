package it.ilpirris.entity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.xml.bind.DatatypeConverter;

import com.fasterxml.jackson.annotation.JsonIgnore;

import it.ilpirris.runnable.BlockGenerator;

public class Block {


	private ArrayList<Transaction> transactions;
	private String hash;
	private String previousHash;
	private int nonce = -1;
	
	@JsonIgnore
	private String transactionsAggregate = "";
	
	public Block(String creator, String previousHash, ArrayList<Transaction> pendingTransactions)
	{
		this.previousHash = previousHash;
		this.transactions = new ArrayList<>();
		
		Transaction rewardTransaction = new Transaction(new User("BlockchainSystem"), new User(BlockGenerator.serviceOwner), BlockGenerator.newBlockReward);
		
		pendingTransactions.add(rewardTransaction);
		addTransactions(pendingTransactions);
		
		this.transactions.forEach(this::appendAggregate);
		generateHash();
	}
	

	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
	}
	public void addTransactions(ArrayList<Transaction> transactions)
	{
		this.transactions.addAll(transactions);
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public String getPreviousHash() {
		return previousHash;
	}
	public void setPreviousHash(String previousHash) {
		this.previousHash = previousHash;
	}
	public int getNonce() {
		return nonce;
	}
	public void setNonce(int nonce) {
		this.nonce = nonce;
	}
	public void increaseNonce()
	{
		this.nonce++;
	}
	
	public void generateHash()
	{
		String aggregate = this.transactionsAggregate+previousHash+nonce;
		
		this.hash = hashString(aggregate);
	}
	
	
	private String hashString(String toHash)
	{
		try
		{
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
			messageDigest.update(toHash.getBytes());
			return DatatypeConverter.printHexBinary(messageDigest.digest());
		}
		catch (NoSuchAlgorithmException e)
		{
			System.out.println("cazzo fai?");
			return null;
		}

	}
	
	private void appendAggregate(Transaction transaction)
	{
		
		this.transactionsAggregate = this.transactionsAggregate + transaction.getAggregate();
	}
}
