package com.example.client

import com.example.model.Account
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod.GET
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class AccountClient(
        private val restTemplate: RestTemplate,
        @Value("\${bank.rest.api:http://localhost:8081/accounts}")
        private val bankRestApi: String
) {

    private val logger = LoggerFactory.getLogger(javaClass)

    fun getAccounts(apiKey: String): List<Account> {

        logger.info("Received apiKey: {}", apiKey)

        // pass the apiKey as cookieValue
        val httpHeaders = HttpHeaders()
        httpHeaders.add("Cookie", apiKey);

        // call restTemplate
        val response = restTemplate.exchange(bankRestApi, GET, HttpEntity<String>(httpHeaders),
                Array<com.example.client.Account>::class.java)

        logger.info("Status code from playserver API: {}", response.statusCode)
        
        // map
        return response.body!!.map {
            Account(id = it.id, iban = it.iban)
        }
    }

}