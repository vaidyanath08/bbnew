/**
 * 
 */
package com.backbase.service;

import java.util.List;

import com.backbase.model.Transactions;

/**
 * @author Vaidyanath Rajpoot
 *
 */

public interface TransactionService {
	List<Transactions> getTransactions() ;

	List<Transactions> getTransactionsBasedOnTxnType(String txnType) ;
	
	Double getTotalTxnAmountbyTxnType(String txnType) ;
}
