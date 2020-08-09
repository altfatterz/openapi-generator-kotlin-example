package com.example.client

import com.example.model.Account
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod.GET
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class AccountClient(private val restTemplate: RestTemplate) {

    fun getAccounts(apiKey: String): List<Account> {

        // pass the apiKey as cookieValue
        val httpHeaders = HttpHeaders();
        httpHeaders.add("Cookie", apiKey);

        // call restTemplate
        val response = restTemplate.exchange("URL", GET, HttpEntity<String>(httpHeaders),
                Array<com.example.client.Account>::class.java)

        // map
        return response.body!!.map {
            Account(id = it.id, iban = it.iban)
        }
    }

}