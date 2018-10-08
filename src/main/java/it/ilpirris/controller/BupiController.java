package it.ilpirris.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.ilpirris.controller.spec.AbstractController;
import it.ilpirris.entity.Transaction;
import it.ilpirris.entity.User;
import it.ilpirris.exception.NotEnoughMoneyException;
import it.ilpirris.service.TransactionService;

import org.springframework.web.bind.annotation.RequestMethod;


@RestController
public class BupiController extends AbstractController
{
	
	@Autowired
	TransactionService transactionService;
	
	@RequestMapping("/user/{name}")
	public User getUser(@PathVariable String name)
	{
		User user = new User(name);
		
		return transactionService.getBalance(user);
	}
	
	@RequestMapping(value = "/transaction", method = RequestMethod.POST)
	public String transaction(@RequestBody Transaction transaction) throws NotEnoughMoneyException
	{
		transactionService.handleTransation(transaction);
		return "Ok";
	}
	
}