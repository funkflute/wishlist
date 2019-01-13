package com.funkflute.kotlin.wishlist

import java.util.UUID
import java.util.Date

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertNull

class ItemTests {
	@Test
    fun `Test Item Creation`() {
		val name   : String = "A Pony"
		val url    : String = "john@example.com"
		val list_id: UUID   = UUID.randomUUID()

		val list = Item(name, url, list_id)

        assertEquals(list.name, name)
        assertEquals(list.url, url)
        assertEquals(list.list_id, list_id)
        assertTrue(list.id.toString().contains('-'))
		assertEquals(list.created_at::class, Date::class)
		assertNull(list.purchased_at)
		
		list.purchased_at = Date()
		assertEquals(list.purchased_at!!::class, Date::class)
    }
}	