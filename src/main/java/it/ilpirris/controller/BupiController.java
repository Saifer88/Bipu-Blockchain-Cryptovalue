package it.ilpirris.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.ilpirris.entity.BlockChain;
import it.ilpirris.entity.Transaction;
import it.ilpirris.entity.User;
import it.ilpirris.service.IdleService;
import it.ilpirris.service.TransactionService;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class BupiController {

	@Autowired
	IdleService idleService;
	
	@Autowired
	BlockChain blockChain;
	
	@Autowired
	TransactionService transactionService;
	
	
	@RequestMapping("/blockchain")
	public BlockChain getBlockchain()
	{
		return this.blockChain;
	}
	
	@RequestMapping("/user/{name}")
	public User getUser(@PathVariable String name)
	{
		User user = new User(name);
		
		return transactionService.getBalance(user);
	}
	
	@RequestMapping(value = "/transaction", method = RequestMethod.POST)
	public String transaction(@RequestBody Transaction transaction)
	{
		transactionService.handleTransation(transaction);
		return "Ok";
	}
	

}