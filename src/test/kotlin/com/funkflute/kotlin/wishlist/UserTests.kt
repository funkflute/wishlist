package com.funkflute.kotlin.wishlist

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue

class UserTests {
	@Test
    fun `Test User Creation`() {
		val user = User("John", "email@example.com")
        assertEquals(user.name, "John")
        assertEquals(user.email, "email@example.com")
        assertTrue(user.id.toString().contains('-'))
    }
}	