// TransactionController.java placeholder
package com.library.controller;

import com.library.model.Transaction;
import com.library.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/issue")
    public Transaction issueBook(@RequestParam Long bookId, @RequestParam Long memberId) {
        return transactionService.issueBook(bookId, memberId);
    }

    @PostMapping("/return/{id}")
    public Transaction returnBook(@PathVariable Long id) {
        return transactionService.returnBook(id);
    }

    @GetMapping("/report/{memberId}")
    public List<Transaction> generateReport(@PathVariable Long memberId) {
        return transactionService.generateReport(memberId);
    }

    @PostMapping("/reserve")
    public Transaction reserveBook(@RequestParam Long bookId, @RequestParam Long memberId) {
        return transactionService.reserveBook(bookId, memberId);
    }
}