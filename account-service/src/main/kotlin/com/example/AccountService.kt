package com.example

import com.example.model.Account
import com.example.web.api.AccountApiService
import org.springframework.stereotype.Service

@Service
class AccountService : AccountApiService {

    override fun getAccounts(): List<Account> {
        //TODO("Not yet implemented")
        return arrayListOf<Account>();
    }

}