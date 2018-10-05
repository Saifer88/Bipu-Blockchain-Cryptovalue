package it.ilpirris.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.ilpirris.entity.BlockChain;
import it.ilpirris.entity.Transaction;
import it.ilpirris.entity.User;

@Service
public class TransactionService {
	
	@Autowired
	BlockChain blockChain;
	
	public void handleTransation(Transaction transaction)
	{	
		transaction.getSender().getBalance();
		blockChain.getPendingTransactions().add(transaction);
	}

	
	public User getBalance(User user)
	{
		user.setBalance(0);
		blockChain
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
