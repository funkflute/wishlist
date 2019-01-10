package com.funkflute.kotlin.wishlist

import java.util.UUID
import java.util.Date
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue

class ListTests {
	@Test
    fun `Test New List Model`() {
		val name: String = "John's Wishlist"
		val user_id: UUID = UUID.randomUUID()
		val list = List(name, user_id)

        assertEquals(list.name, name)
        assertEquals(list.user_id, user_id)
        assertTrue(list.id.toString().contains('-'))
        assertEquals(list.created_at::class, Date::class)
    }
}	