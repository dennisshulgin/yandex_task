package com.shulgin.yandex.yandex;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/test-application.properties")
class YandexApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	String[] jsonStrings = {
			"{\n" +
			"        \"items\": [\n" +
			"            {\n" +
			"                \"type\": \"CATEGORY\",\n" +
			"                \"name\": \"Товары\",\n" +
			"                \"id\": \"069cb8d7-bbdd-47d3-ad8f-82ef4c269df1\",\n" +
			"                \"parentId\": null\n" +
			"            }\n" +
			"        ],\n" +
			"        \"updateDate\": \"2022-02-01T12:00:00.000Z\"\n" +
			"}",
			"{\n" +
					"        \"items\": [\n" +
					"            {\n" +
					"                \"type\": \"CATEGORY\",\n" +
					"                \"name\": \"Смартфоны\",\n" +
					"                \"id\": \"d515e43f-f3f6-4471-bb77-6b455017a2d2\",\n" +
					"                \"parentId\": \"069cb8d7-bbdd-47d3-ad8f-82ef4c269df1\"\n" +
					"            },\n" +
					"            {\n" +
					"                \"type\": \"OFFER\",\n" +
					"                \"name\": \"jPhone 13\",\n" +
					"                \"id\": \"863e1a7a-1304-42ae-943b-179184c077e3\",\n" +
					"                \"parentId\": \"d515e43f-f3f6-4471-bb77-6b455017a2d2\",\n" +
					"                \"price\": 79999\n" +
					"            },\n" +
					"            {\n" +
					"                \"type\": \"OFFER\",\n" +
					"                \"name\": \"Xomiа Readme 10\",\n" +
					"                \"id\": \"b1d8fd7d-2ae3-47d5-b2f9-0f094af800d4\",\n" +
					"                \"parentId\": \"d515e43f-f3f6-4471-bb77-6b455017a2d2\",\n" +
					"                \"price\": 59999\n" +
					"            }\n" +
					"        ],\n" +
					"        \"updateDate\": \"2022-02-02T12:00:00.000Z\"\n" +
					"}",
			"{\n" +
					"        \"items\": [\n" +
					"            {\n" +
					"                \"type\": \"OFFER\",\n" +
					"                \"name\": \"Samson 70\\\" LED UHD Smart\",\n" +
					"                \"id\": \"98883e8f-0507-482f-bce2-2fb306cf6483\",\n" +
					"                \"parentId\": \"1cc0129a-2bfe-474c-9ee6-d435bf5fc8f2\",\n" +
					"                \"price\": 32999\n" +
					"            },\n" +
					"            {\n" +
					"                 \"type\": \"OFFER\",\n" +
					"                 \"name\": \"Phyllis 50\\\" LED UHD Smarter\",\n" +
					"                 \"id\": \"74b81fda-9cdc-4b63-8927-c978afed5cf4\",\n" +
					"                 \"parentId\": \"1cc0129a-2bfe-474c-9ee6-d435bf5fc8f2\",\n" +
					"                 \"price\": 49999\n" +
					"            },\n" +
					"            {\n" +
					"                \"type\": \"CATEGORY\",\n" +
					"                \"name\": \"Телевизоры\",\n" +
					"                \"id\": \"1cc0129a-2bfe-474c-9ee6-d435bf5fc8f2\",\n" +
					"                \"parentId\": \"069cb8d7-bbdd-47d3-ad8f-82ef4c269df1\"\n" +
					"            }  \n" +
					"        ],\n" +
					"        \"updateDate\": \"2022-02-03T12:00:00.000Z\"\n" +
					"}",
			"{\n" +
					"        \"items\": [\n" +
					"            {\n" +
					"                \"type\": \"OFFER\",\n" +
					"                \"name\": \"Goldstar 65\\\" LED UHD LOL Very Smart\",\n" +
					"                \"id\": \"73bc3b36-02d1-4245-ab35-3106c9ee1c65\",\n" +
					"                \"parentId\": \"1cc0129a-2bfe-474c-9ee6-d435bf5fc8f2\",\n" +
					"                \"price\": 69999\n" +
					"            }\n" +
					"        ],\n" +
					"        \"updateDate\": \"2022-02-03T15:00:00.000Z\"\n" +
					"}"
	};

	@Test
	void imports() throws Exception{
		for(String json : jsonStrings) {
			mockMvc.perform(post("/imports")
							.contentType(MediaType.APPLICATION_JSON)
							.content(json))
					.andExpect(status().isOk());
		}
	}

	String[] jsonStringsWithIncorrectParams = {
			// одинаковые id
			"{\n" +
					"        \"items\": [\n" +
					"            {\n" +
					"                \"type\": \"OFFER\",\n" +
					"                \"name\": \"Samsung 12 HD\",\n" +
					"                \"id\": \"73bc3b36-02d1-4245-ab35-3106c9ee1c11\",\n" +
					"                \"parentId\": \"1cc0129a-2bfe-474c-9ee6-d435bf5fc8f2\",\n" +
					"                \"price\": 69998\n" +
					"            }, \n" +
					"            {\n" +
					"                 \"type\": \"OFFER\",\n" +
					"                 \"name\": \"Samsund 14 LED\",\n" +
					"                 \"id\": \"73bc3b36-02d1-4245-ab35-3106c9ee1c11\",\n" +
					"                 \"parentId\": \"1cc0129a-2bfe-474c-9ee6-d435bf5fc8f2\",\n" +
					"                 \"price\": 69997\n" +
					"            }\n" +
					"        ],\n" +
					"        \"updateDate\": \"2022-02-03T15:00:00.000Z\"\n" +
					"}",
			// Товар является родителем другого товара
			"{\n" +
					"        \"items\": [\n" +
					"            {\n" +
					"                \"type\": \"OFFER\",\n" +
					"                \"name\": \"Samsung 12 HD\",\n" +
					"                \"id\": \"73bc3b36-02d1-4245-ab35-3106c9ee1c19\",\n" +
					"                \"parentId\": \"73bc3b36-02d1-4245-ab35-3106c9ee1c11\",\n" +
					"                \"price\": 69998\n" +
					"            }, \n" +
					"            {\n" +
					"                 \"type\": \"OFFER\",\n" +
					"                 \"name\": \"Samsund 14 LED\",\n" +
					"                 \"id\": \"73bc3b36-02d1-4245-ab35-3106c9ee1c11\",\n" +
					"                 \"parentId\": \"1cc0129a-2bfe-474c-9ee6-d435bf5fc8f2\",\n" +
					"                 \"price\": 69997\n" +
					"            }\n" +
					"        ],\n" +
					"        \"updateDate\": \"2022-02-03T15:00:00.000Z\"\n" +
					"}",
			// Цена у категории
			"{\n" +
					"        \"items\": [\n" +
					"            {\n" +
					"                \"type\": \"CATEGORY\",\n" +
					"                \"name\": \"Товары\",\n" +
					"                \"id\": \"069cb8d7-bbdd-47d3-ad8f-82ef4c269df1\",\n" +
					"                \"parentId\": null\n" +
					"				 \"price\": 12345\n" +
					"            }\n" +
					"        ],\n" +
					"        \"updateDate\": \"2022-02-01T12:00:00.000Z\"\n" +
					"}",

	};

	@Test
	void importsIncorrect() throws Exception {
		for(String json : jsonStringsWithIncorrectParams) {
			mockMvc.perform(post("/imports")
							.contentType(MediaType.APPLICATION_JSON)
							.content(json))
					.andExpect(status().is(400))
					.andExpect(jsonPath("$.code", is(400)))
					.andExpect(jsonPath("$.message", is("Validation Failed")));
		}
	}
}
