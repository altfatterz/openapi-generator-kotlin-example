package com.example

import org.springdoc.core.Constants
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.servlet.view.UrlBasedViewResolver.REDIRECT_URL_PREFIX

@Controller
class HomeController {

    @Value(Constants.SWAGGER_UI_PATH)
    private val swaggerUiPath: String? = null

    @GetMapping("/")
    fun index(): String {
        return REDIRECT_URL_PREFIX + swaggerUiPath
    }
}
