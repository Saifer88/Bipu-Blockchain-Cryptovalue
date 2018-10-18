package it.ilpirris.runnable;


import java.util.Collections;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import it.ilpirris.entity.Block;
import it.ilpirris.entity.BlockChain;
import it.ilpirris.factory.BlockChainFactory;


public class BlockGenerator implements Runnable
{
	
	Logger logger = LogManager.getLogger();
	
	private BlockChainFactory blockChainFactory;
	private BlockChain blockChain;
	public final static String serviceOwner = "saifer";
	public final static int newBlockReward = 250;
	
	public BlockGenerator(BlockChainFactory blockChainFactory) 
	{
		this.blockChainFactory = blockChainFactory;
		this.blockChain = blockChainFactory.getBlockChain();
	}

	@Override
	public void run() {
		logger.info("Starting Block generator");
		while(true)
			blockChain.addBlock(generateBlock());
	}
	
	
	public Block generateBlock()
	{
		Block lastBlock = blockChain.getBlocks().get(blockChain.getBlocks().size() - 1);
		Block block = new Block( BlockGenerator.serviceOwner, lastBlock.getHash(), blockChain.getPendingTransactions());
		//blockChain.setPendingTransactions(new ArrayList<>());
		mineHash(blockChain.getDifficulty(), block);
		logger.info("Block Found " + block.getHash() );

		return block;
	}
	
	private void mineHash(int difficulty, Block block)
	{
		String startingDesired = String.join("", Collections.nCopies(difficulty, "0"));

		while (!block.getHash().startsWith(startingDesired) && !blockChainFactory.isNewBlockChain())
		{
			block.increaseNonce();
			block.generateHash();
		}
		
	
	}
}
