// TransactionRepository.java placeholder
package com.library.repository;

import com.library.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByMemberId(Long memberId);
}