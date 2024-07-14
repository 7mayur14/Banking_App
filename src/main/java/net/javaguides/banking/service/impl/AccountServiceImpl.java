package net.javaguides.banking.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.javaguides.banking.dto.AccountDto;
import net.javaguides.banking.entity.Account;
import net.javaguides.banking.mapper.AccountMapper;
import net.javaguides.banking.repository.AccountRepository;
import net.javaguides.banking.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
	private AccountRepository accountRepository;
	
	
	public AccountServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	
	//Code For account creation
	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		Account account =AccountMapper.mapToAccount(accountDto);
		Account savedAccount = accountRepository.save(account);
		return AccountMapper.mapAccountDto(savedAccount);
		//return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto getAccountById(long id) {
		Account account= accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist"));
		return AccountMapper.mapAccountDto(account);
	}
	
	//Code for Account deposit
	@Override
	public AccountDto deposit(Long id, double amount) {
			Account account= accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist"));
			
			double total = account.getBalance()+amount;
			account.setBalance(total);
			Account savedAccount = accountRepository.save(account);
			return AccountMapper.mapAccountDto(savedAccount);
	}
	
	//Code for account withdraw
	@Override
	public AccountDto withdraw(Long id, double amount) {
		
		Account account= accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist"));
		
		if(account.getBalance()<amount){
			throw new RuntimeException("Insufficiant amount");
		}
		double total=account.getBalance()-amount;
		account.setBalance(total);
		Account savedAccount = accountRepository.save(account);
		return AccountMapper.mapAccountDto(savedAccount);
	}

	//code for show all accounts
	@Override
	public List<AccountDto> getAllAccounts() {
		List<Account> accounts = accountRepository.findAll();		
		return accounts.stream().map((account) -> AccountMapper.mapAccountDto(account)).collect(Collectors.toList());
		
	}
	
	//code for account deletion 
	@Override
	public void deleteAccount(Long id) {
		
		@SuppressWarnings("unused")
		Account account= accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist"));
		
		accountRepository.deleteById(id);
		
		return;
		
	}

}
