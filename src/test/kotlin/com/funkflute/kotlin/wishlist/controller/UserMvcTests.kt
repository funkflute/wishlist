package com.funkflute.kotlin.wishlist

import java.util.UUID
import java.util.Date

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
	fun `User Creation`() {
		val json = """
{
	"name": "Fry",
	"email": "fry@example.com"
}
"""
		val request = post("/users")
			.content(json)
			.contentType(MediaType.APPLICATION_JSON_UTF8)
			.accept(MediaType.APPLICATION_JSON_UTF8)

		mockMvc.perform(request)
			.andExpect(status().isOk)
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$.name").value("Fry"))
			.andExpect(jsonPath("$.email").value("fry@example.com"))
			/* .andExpect(jsonPath("$.id").value()) */
	}

	@Test
	fun `List Creation`() {
		val user = User("Leela", "leela@planex.com")
		val list_name = "Leela's List"
		val json = """
{
"name": "$list_name"
}
"""

		val request = post("/users/" + user.id + "/lists")
			.content(json)
			.contentType(MediaType.APPLICATION_JSON_UTF8)
			.accept(MediaType.APPLICATION_JSON_UTF8)

		mockMvc.perform(request)
			.andExpect(status().isOk)
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$.name").value(list_name))
			/* .andExpect(jsonPath("$.id").value()) */
	}

	@Test
	fun `Item Creation`() {
		val list_id: UUID = UUID.randomUUID()
		val name = "Zero-G-Juggs" //  National Pornographic, Play-Boy-Ar-De, Zero-G-Juggs, Extra Long Honkers, Unique Knocker
		val url = "http://Zero-G-Juggs.mag/subscribe"
		val json = """
{
	"name": "$name",
	"url": "$url"
} 
"""
		val request = post("/lists/" + list_id + "/items")
			.content(json)
			.contentType(MediaType.APPLICATION_JSON_UTF8)
			.accept(MediaType.APPLICATION_JSON_UTF8)

		mockMvc.perform(request)
			.andExpect(status().isOk)
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$.name").value(name))
			.andExpect(jsonPath("$.url").value(url))
			.andExpect(jsonPath("$.list_id").value(list_id.toString()))
			.andExpect(jsonPath("$.purchased_at").doesNotExist())
			.andExpect(jsonPath("$.created_at").exists())
			.andExpect(jsonPath("$.id").exists())
	}

	@Test
	fun `Mark Item Purchased`() {
	}

}	