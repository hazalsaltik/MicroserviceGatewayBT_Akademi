package com.bt_akademi.user_management.controller;

import com.bt_akademi.user_management.model.service.AbstractProductService;
import com.bt_akademi.user_management.model.service.AbstractTransactionService;
import com.bt_akademi.user_management.security.model.UserPrincipal;
import com.google.gson.JsonElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

// ****22 ->
@RestController
@RequestMapping("gateway/transaction")
public class TransactionController
{
    @Autowired
    private AbstractTransactionService transactionService;

    /*
        @AuthenticationPrincipal ile oturum açan kullanıcıya
        Controller üzerinden kolayca erişilir.
     */
    @GetMapping
    public ResponseEntity<?>  getAllTransactionsOfAuthorizedUser(@AuthenticationPrincipal UserPrincipal user)
    {
        return ResponseEntity.ok(transactionService.findAllByUserID(user.getId()));
    }

    @DeleteMapping("delete/{transactionID}")
    public ResponseEntity deleteByID(@PathVariable Integer transactionID)
    {
        transactionService.deleteById(transactionID);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody JsonElement transaction)
    {
        return ResponseEntity.ok(transactionService.save(transaction));
    }
}
