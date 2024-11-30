package net.javaProject.banking.controller;

import net.javaProject.banking.dto.TransactionDto;
import net.javaProject.banking.service.TransactionService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("BMS/transaction")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;
    @PostMapping("/create")
    public ResponseEntity<TransactionDto> createTransaction(@RequestBody TransactionDto transactionDto){

        TransactionDto saveTransaction = transactionService.createTransaction(transactionDto);
        return new ResponseEntity<>(saveTransaction, HttpStatus.CREATED);
    }

    @GetMapping("/{Id}")
    public ResponseEntity<List<TransactionDto>> getTransactionDetailsById(@PathVariable Long Id) {
        List<TransactionDto> listOfTransaction = transactionService.getTransactionDetailsByID(Id);
        if (!listOfTransaction.isEmpty()) {
            return ResponseEntity.ok(listOfTransaction);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    @GetMapping("/{Id1}/{Id2}")
    public ResponseEntity<List<TransactionDto>> getTransactionDetailsByIdToId(@PathVariable Long Id1 , @PathVariable Long Id2){
        List<TransactionDto> listOfFromToTransactions = transactionService.getTransactionDetailsByIDToId(Id1, Id2);
        if(!listOfFromToTransactions.isEmpty()){
            return ResponseEntity.ok(listOfFromToTransactions);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
