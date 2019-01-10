package com.funkflute.kotlin.wishlist

import java.util.UUID
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import java.util.concurrent.atomic.AtomicLong

@RestController
class UserController {

    @PostMapping("/users")
    fun makeNewUser(@RequestBody user: User) : User {
        return User(user.name, user.email)
    }

    @PostMapping("/users/{user_id}/lists")
    fun makeNewList(@PathVariable user_id: UUID, @RequestBody list: List) = List(list.name, user_id)

}