package com.funkflute.kotlin.wishlist

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWolrdController {

    @GetMapping("/")
    fun greeting() = "Hello World"

}