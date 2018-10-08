package it.ilpirris.service;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.ilpirris.factory.BlockChainFactory;
import it.ilpirris.runnable.BlockGenerator;

@Service
public class IdleService {
	
	@Autowired
	private BlockChainFactory blockChainFactory;
	
	
	private BlockGenerator blockGenerator;
	
	
	@PostConstruct
	public void startingIdle()
	{
		this.blockGenerator = new BlockGenerator(this.blockChainFactory);
		
		
		this.blockChainFactory.setGenerator(new Thread(blockGenerator));
		
		this.blockChainFactory.startMining();
		
		
	}
}
