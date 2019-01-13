package com.funkflute.kotlin.wishlist

import java.util.UUID
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import java.util.concurrent.atomic.AtomicLong
/*  */
@RestController
class ListController {

    @PostMapping("/lists/{list_id}/items")
    fun makeNewItem(@PathVariable list_id: UUID, @RequestBody item: Item) = Item(item.name, item.url, list_id)

}