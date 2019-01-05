package com.funkflute.kotlin.wishlist

import java.util.UUID

data class User(val name: String, val email: String)
{
	val id:UUID = UUID.randomUUID()
}
