package it.ilpirris.bean;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import it.ilpirris.entity.BlockChain;

@Configuration
public class BlockChainLoader {

	BlockChain blockChain;
	
	
	@PostConstruct
	public void init()
	{
		this.blockChain = new BlockChain();
	}
	
	
	@Bean
	public BlockChain blockChain()
	{
		return this.blockChain;
	}
	
}