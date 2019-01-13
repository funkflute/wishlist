package com.funkflute.kotlin.wishlist

import java.util.UUID
import java.util.Date

data class List (
	val name   : String,
	val user_id: UUID?
) {
	val id        : UUID = UUID.randomUUID()
	val created_at: Date = Date()
}
