package it.ilpirris.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.ilpirris.entity.BlockChain;
import it.ilpirris.factory.BlockChainFactory;


@RestController
public class BlockchainController {

	
	@Autowired
	BlockChainFactory blockChainFactory;
	
	@RequestMapping("/blockchain")
	public BlockChain getBlockchain()
	{
		return this.blockChainFactory.getBlockChain();
	}
	
	
	@RequestMapping(value = "/blockchain", method = RequestMethod.POST)
	public BlockChain postBlockchain(BlockChain remoteBlockChain)
	{
	
		int remoteLenght = remoteBlockChain.getBlocks().size();
		int localLenght = this.blockChainFactory.getBlockChain().getBlocks().size();
		
		
		if (remoteLenght >= localLenght)
			this.blockChainFactory.setBlockChain(remoteBlockChain);
		
		
		return this.blockChainFactory.getBlockChain();
	}
}
