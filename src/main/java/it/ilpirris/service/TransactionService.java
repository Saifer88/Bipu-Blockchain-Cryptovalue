package it.ilpirris.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.ilpirris.entity.Transaction;
import it.ilpirris.entity.User;
import it.ilpirris.exception.NotEnoughMoneyException;
import it.ilpirris.factory.BlockChainFactory;

@Service
public class TransactionService {
	
	@Autowired
	BlockChainFactory factory;
	
	public void handleTransation(Transaction transaction) throws NotEnoughMoneyException
	{	
		if (transaction.getSender().getBalance() < transaction.getAmount()) 
			throw new NotEnoughMoneyException();
		
		factory.getBlockChain().addPendingTransaction(transaction);
	}

	
	public User getBalance(User user)
	{
		user.setBalance(0);
		factory
			.getBlockChain()
			.getBlocks()
			.forEach(e -> 
				{
					e
					.getTransactions()
					.stream()
					.filter(t -> t.getSender().getName().equals(user.getName()))
					.forEach(t -> user.setBalance(user.getBalance() - t.getAmount()));
					
					e
					.getTransactions()
					.stream()
					.filter(t -> t.getReceiver().getName().equals(user.getName()))
					.forEach(t -> user.setBalance(user.getBalance() + t.getAmount()));			
				});
		
		return user;
	}
	
}
