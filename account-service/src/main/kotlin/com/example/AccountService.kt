package com.example

import com.example.client.AccountClient
import com.example.model.Account
import com.example.web.api.AccountApiService
import org.springframework.stereotype.Service

@Service
class AccountService(private val accountClient : AccountClient) : AccountApiService {

    override fun getAccounts(apiKey: String): List<Account> {

        return accountClient.getAccounts(apiKey);
    }

}