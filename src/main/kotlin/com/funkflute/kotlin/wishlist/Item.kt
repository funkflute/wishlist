package com.funkflute.kotlin.wishlist

import java.util.UUID
import java.util.Date

data class Item (
	var name: String,
	var url: String,
	var list_id: UUID? = null
) {
	val id          : UUID  = UUID.randomUUID()
	var created_at  : Date  = Date()
    var purchased_at: Date? = null
}
