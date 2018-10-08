package it.ilpirris.factory;


import it.ilpirris.entity.BlockChain;

public class BlockChainFactory {
	
	
	private Thread generator;
	private BlockChain blockChain;
	private boolean newBlockChain = false;
	
	
	public BlockChainFactory()
	{
		this.blockChain = new BlockChain();
		this.setGenerator(new Thread());
	}
	
	public BlockChainFactory(BlockChain blockChain) {
		this.blockChain = blockChain;
		this.setGenerator(new Thread());
	}

	public BlockChain getBlockChain() {
		return blockChain;
	}

	public void setBlockChain(BlockChain blockChain) {
		this.blockChain = blockChain;
	}

	public boolean isNewBlockChain() {
		return newBlockChain;
	}

	public void setNewBlockChain(boolean newBlockChain) {
		this.newBlockChain = newBlockChain;
	}

	public Thread getGenerator() {
		return generator;
	}

	public void setGenerator(Thread generator) {
		this.generator = generator;
	}
	
	public void startMining()
	{
		this.generator.start();
	}
	
	public void stopMining()
	{
		this.generator.interrupt();
	}
	
	

}
