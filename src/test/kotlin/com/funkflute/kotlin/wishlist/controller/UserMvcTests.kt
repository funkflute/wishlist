package com.funkflute.kotlin.wishlist

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue

import org.springframework.test.web.servlet.MockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.junit.runner.RunWith
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath

@RunWith(SpringRunner::class)
@WebMvcTest
class UserMvcTests {

	@Autowired
	lateinit var mockMvc: MockMvc

	@Test
	fun `User Model Creation`() {
		val request = post("/user")
			.content("{ \"name\": \"Fry\", \"email\": \"fry@example.com\"}")
			.contentType(MediaType.APPLICATION_JSON_UTF8)
			.accept(MediaType.APPLICATION_JSON_UTF8)

		mockMvc.perform(request)
			.andExpect(status().isOk)
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$.name").value("Fry"))
			.andExpect(jsonPath("$.email").value("fry@example.com"))
			/* .andExpect(jsonPath("$.id").value()) */
	}
}	