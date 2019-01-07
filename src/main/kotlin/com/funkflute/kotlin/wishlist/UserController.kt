package com.funkflute.kotlin.wishlist

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import java.util.concurrent.atomic.AtomicLong

@RestController
class UserController {

    @PostMapping("/user")
    fun makeNewUser(@RequestBody user: User) = User(user.name, user.email)

}