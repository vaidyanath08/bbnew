/**
 * 
 */
package com.backbase.controller.Impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.backbase.controller.TransactionController;
import com.backbase.model.Transactions;
import com.backbase.service.TransactionService;

/**
 * @author Vaidyanath Rajpoot
 *
 */
@RestController
public class TransactionControllerImpl implements TransactionController {
	
	private static final Logger logger = Logger.getLogger(TransactionControllerImpl.class);
 

	@Autowired
	TransactionService txnService;

	@Override
	public List<Transactions> getAllTransactions() {
		logger.debug("Inside getAllTransactions() method ");

		List<Transactions> txnList = txnService.getTransactions();
		return txnList;
	}

	@Override

	public List<Transactions> getTxnBasedOnTxnType(@PathVariable("type") String type) {
		logger.debug("Inside getTxnBasedOnTxnType() method ");
		List<Transactions> txnTypeList = txnService.getTransactionsBasedOnTxnType(type);
		return txnTypeList;
	}

	@Override

	public Double getTotalTxnAmountBasedOnTxnType(@PathVariable("type") String type) {
		logger.debug("Inside getTotalTxnAmountBasedOnTxnType() method ");
		Double totalTxnAmount = txnService.getTotalTxnAmountbyTxnType(type);
		return totalTxnAmount;
	}

}
