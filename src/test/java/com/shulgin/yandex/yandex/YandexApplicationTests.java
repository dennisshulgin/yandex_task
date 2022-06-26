package com.shulgin.yandex.yandex;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Assert;

import java.nio.charset.StandardCharsets;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "/test-application.properties")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class YandexApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Order(1)
	@Test
	void importsTest() throws Exception {
		for(String json : JsonStrings.CORRECT_IMPORT_STRINGS) {
			mockMvc.perform(post("/imports")
							.contentType(MediaType.APPLICATION_JSON)
							.content(json))
					.andExpect(status().isOk());
		}
	}

	@Order(2)
	@Test
	void incorrectImportsTest() throws Exception {
		for(String json : JsonStrings.INCORRECT_IMPORT_STRINGS) {
			mockMvc.perform(post("/imports")
							.contentType(MediaType.APPLICATION_JSON)
							.content(json))
					.andExpect(status().is(400))
					.andExpect(jsonPath("$.code", is(400)))
					.andExpect(jsonPath("$.message", is("Validation Failed")));
		}
	}

	@Order(3)
	@Test
	void nodesTest() throws Exception {
		String responseString = mockMvc.perform(get("/nodes/069cb8d7-bbdd-47d3-ad8f-82ef4c269df1"))
				.andExpect(status().isOk())
				.andReturn()
				.getResponse()
				.getContentAsString();
		String decodeResponseString = new String(responseString.getBytes(StandardCharsets.ISO_8859_1));
		ObjectMapper mapper = new ObjectMapper();
		JsonNode tree1 = mapper.readTree(decodeResponseString);
		JsonNode tree2 = mapper.readTree(JsonStrings.EXPECTED_TREE);
		boolean areTheyEqual = tree1.equals(tree2);
		Assert.isTrue(areTheyEqual, "Trees are not equals");
	}

	@Order(4)
	@Test
	void nodesNotFoundTest() throws Exception {
		mockMvc.perform(get("/nodes/d515e43f-f3f6-4471-bb77-6b5666017a2d2"))
				.andExpect(status().is(404))
				.andExpect(jsonPath("$.code", is(404)))
				.andExpect(jsonPath("$.message", is("Item not found")));
	}

	@Order(5)
	@Test
	void deleteTest() throws Exception {
		mockMvc.perform(delete("/delete/d515e43f-f3f6-4471-bb77-6b455017a2d2"))
				.andExpect(status().isOk());
		String responseString = mockMvc.perform(get("/nodes/069cb8d7-bbdd-47d3-ad8f-82ef4c269df1"))
				.andExpect(status().isOk())
				.andReturn()
				.getResponse()
				.getContentAsString();
		String decodeResponseString = new String(responseString.getBytes(StandardCharsets.ISO_8859_1));
		ObjectMapper mapper = new ObjectMapper();
		JsonNode tree1 = mapper.readTree(decodeResponseString);
		JsonNode tree2 = mapper.readTree(JsonStrings.EXPECTED_TREE_AFTER_DELETE);
		boolean areTheyEqual = tree1.equals(tree2);
		Assert.isTrue(areTheyEqual, "Trees are not equals");
	}

	@Order(6)
	@Test
	void deleteNotFoundTest() throws Exception {
		mockMvc.perform(delete("/delete/d515e43f-f3f6-4471-bb77-6b5666017a2d2"))
				.andExpect(status().is(404))
				.andExpect(jsonPath("$.code", is(404)))
				.andExpect(jsonPath("$.message", is("Item not found")));
	}

	@Order(7)
	@Test
	void salesTest() throws Exception {
		String responseString = mockMvc.perform(get("/sales?date=2022-02-03T19:00:00.000Z"))
				.andExpect(status().isOk())
				.andReturn()
				.getResponse()
				.getContentAsString();
		String decodeResponseString = new String(responseString.getBytes(StandardCharsets.ISO_8859_1));
		ObjectMapper mapper = new ObjectMapper();
		JsonNode tree1 = mapper.readTree(decodeResponseString);
		JsonNode tree2 = mapper.readTree(JsonStrings.EXPECTED_TREE_SALES);
		boolean areTheyEqual = tree1.equals(tree2);
		Assert.isTrue(areTheyEqual, "Trees are not equals");
	}

	@Order(8)
	@Test
	void salesIncorrectDateTest() throws Exception {
		mockMvc.perform(get("/sales?date=2022-02-03"))
				.andExpect(status().is(400))
				.andExpect(jsonPath("$.code", is(400)))
				.andExpect(jsonPath("$.message", is("Validation Failed")));
	}

}
