package com.shulgin.yandex.yandex;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@SpringBootTest
class YandexApplicationTests {

	@Test
	void contextLoads() {
		DateTimeFormatter dtf = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
		OffsetDateTime l = OffsetDateTime.parse("2022-02-02T12:00:00.000Z", DateTimeFormatter.ISO_OFFSET_DATE_TIME);
		System.out.println(l);
		System.out.println(l.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")));
	}

}
