package it.ilpirris.runnable;


import java.util.ArrayList;
import java.util.Collections;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import it.ilpirris.entity.Block;
import it.ilpirris.entity.BlockChain;


public class BlockGenerator implements Runnable
{
	
	Logger logger = LogManager.getLogger();
	
	private BlockChain blockChain;
	public final static String serviceOwner = "saifer";
	public final static int newBlockReward = 250;
	
	public BlockGenerator(BlockChain blockChain) 
	{
		this.blockChain = blockChain;
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
		blockChain.setPendingTransactions(new ArrayList<>());
		mineHash(blockChain.getDifficulty(), block);
		logger.info("Block Found");

		return block;
	}
	
	private void mineHash(int difficulty, Block block)
	{
		String startingDesired = String.join("", Collections.nCopies(difficulty, "0"));

		while (!block.getHash().startsWith(startingDesired))
		{
			block.increaseNonce();
			block.generateHash();
		}
	}
}
