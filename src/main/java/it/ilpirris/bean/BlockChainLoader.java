package it.ilpirris.bean;


import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import it.ilpirris.factory.BlockChainFactory;

@Configuration
public class BlockChainLoader {

	BlockChainFactory factory;
	
	
	@PostConstruct
	public void init()
	{
		this.factory = new BlockChainFactory();
	}
	
	
	@Bean
	public BlockChainFactory blockChainFactory()
	{
		return this.factory;
	}
	

	
}