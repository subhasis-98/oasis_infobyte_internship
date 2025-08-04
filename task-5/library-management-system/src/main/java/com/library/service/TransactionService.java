// TransactionService.java placeholder
package com.library.service;

import com.library.model.Book;
import com.library.model.Transaction;
import com.library.repository.BookRepository;
import com.library.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private BookRepository bookRepository;

    public Transaction issueBook(Long bookId, Long memberId) {
        Book book = bookRepository.findById(bookId).orElseThrow();
        if (!book.isAvailable()) {
            throw new RuntimeException("Book is not available");
        }
        Transaction transaction = new Transaction();
        transaction.setBook(book);
        transaction.setMember(new com.library.model.Member());
        transaction.getMember().setId(memberId);
        transaction.setIssueDate(LocalDate.now());
        transaction.setDueDate(LocalDate.now().plusDays(14));
        transaction.setIsReservation(false);
        book.setAvailable(false);
        bookRepository.save(book);
        return transactionRepository.save(transaction);
    }

    public Transaction returnBook(Long transactionId) {
        Transaction transaction = transactionRepository.findById(transactionId).orElseThrow();
        transaction.setReturnDate(LocalDate.now());
        long daysOverdue = ChronoUnit.DAYS.between(transaction.getDueDate(), LocalDate.now());
        if (daysOverdue > 0) {
            transaction.setFine(daysOverdue * 1.0); // $1 per day
        }
        transaction.getBook().setAvailable(true);
        bookRepository.save(transaction.getBook());
        return transactionRepository.save(transaction);
    }

    public List<Transaction> generateReport(Long memberId) {
        return transactionRepository.findByMemberId(memberId);
    }

    public Transaction reserveBook(Long bookId, Long memberId) {
        Book book = bookRepository.findById(bookId).orElseThrow();
        Transaction transaction = new Transaction();
        transaction.setBook(book);
        transaction.setMember(new com.library.model.Member());
        transaction.getMember().setId(memberId);
        transaction.setIssueDate(LocalDate.now());
        transaction.setIsReservation(true);
        return transactionRepository.save(transaction);
    }
}