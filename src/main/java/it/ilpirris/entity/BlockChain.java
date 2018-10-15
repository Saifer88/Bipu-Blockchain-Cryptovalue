package it.ilpirris.entity;

import java.util.ArrayList;

import it.ilpirris.runnable.BlockGenerator;

public class BlockChain {
	
	private ArrayList<Block> blocks = new ArrayList<>();
	private ArrayList<Transaction> pendingTransactions = new ArrayList<>();
	
	private int difficulty = 6;

	public BlockChain()
	{
		blocks.add(new Block(BlockGenerator.serviceOwner,  null, pendingTransactions));
	}
	
	public ArrayList<Block> getBlocks() {
		return blocks;
	}
	public void setBlocks(ArrayList<Block> blocks) {
		this.blocks = blocks;
	}
	
	public void addBlock(Block block)
	{
		this.blocks.add(block);
	}
	public ArrayList<Transaction> getPendingTransactions() {
		return pendingTransactions;
	}
	public void setPendingTransactions(ArrayList<Transaction> pendingTransactions) {
		this.pendingTransactions = pendingTransactions;
	}
	
	public void addPendingTransaction(Transaction transaction)
	{
		this.pendingTransactions.add(transaction);
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int blockChainDifficulty) {
		this.difficulty = blockChainDifficulty;
	}
}
