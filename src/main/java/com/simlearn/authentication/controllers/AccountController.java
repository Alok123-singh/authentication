package com.simlearn.authentication.controllers;

import com.simlearn.authentication.dto.AccountDto;
import com.simlearn.authentication.dto.ResetPasswordDto;
import com.simlearn.authentication.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:5173")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/account")
    @ResponseStatus(HttpStatus.CREATED)
    public void createAccount(@RequestBody AccountDto accountDto) {
        accountService.createAccount(accountDto);
    }

    @GetMapping("/username/{username}")
    public boolean checkUsername(@PathVariable String username) {
        return accountService.checkUserName(username);
    }

    @GetMapping("/email/{email}")
    public boolean checkEmail(@PathVariable String email) {
        return accountService.checkEmail(email);
    }

    @PostMapping("/password")
    public void resetPassword(@RequestBody ResetPasswordDto resetPasswordDto) {
        accountService.resetPassword(resetPasswordDto);
    }
}
