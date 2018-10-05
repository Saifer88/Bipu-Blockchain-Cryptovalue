package it.ilpirris.service;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.ilpirris.entity.BlockChain;
import it.ilpirris.runnable.BlockGenerator;

@Service
public class IdleService {
	
	
	
	@Autowired
	private BlockChain blockChain;
	
	
	private BlockGenerator blockGenerator;
	private Thread generator;
	
	
	@PostConstruct
	public void startingIdle()
	{
		this.blockGenerator = new BlockGenerator(this.blockChain);
		
		this.generator = new Thread(blockGenerator);
		generator.start();
	}
}
