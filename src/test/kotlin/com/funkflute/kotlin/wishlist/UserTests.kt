package com.funkflute.kotlin.wishlist

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue

class UserTests {
	@Test
    fun `Test User Creation`() {
		val name = "John"
		val email = "john@example.com"
		val user = User(name, email)
        assertEquals(user.name, name)
        assertEquals(user.email, email)
        assertTrue(user.id.toString().contains('-'))
    }
}	