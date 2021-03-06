package com.ryum.accountbook.account.repository;

import com.ryum.accountbook.account.dto.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 결제수단 Repository
 * 
 * @author ryum
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

}
