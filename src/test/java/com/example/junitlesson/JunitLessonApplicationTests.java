package com.example.junitlesson;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@SpringBootTest
public class JunitLessonApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	void testMultiNormal() throws Exception {
		mockMvc.perform(get("/calculator/multiply").param("x", "9").param("y", "9")).andExpect(content().string("81"))
				.andExpect(status().isOk());
	}

	@Test
	void testMultixZero() throws Exception {
		mockMvc.perform(get("/calculator/multiply").param("x", "0").param("y", "9")).andExpect(content().string("0"))
				.andExpect(status().isOk());
	}

	@Test
	void testMultiyZero() throws Exception {
		mockMvc.perform(get("/calculator/multiply").param("x", "9").param("y", "0")).andExpect(content().string("0"))
				.andExpect(status().isOk());
	}

	@Test
	void testMultiZero() throws Exception {
		mockMvc.perform(get("/calculator/multiply").param("x", "0").param("y", "0")).andExpect(content().string("0"))
				.andExpect(status().isOk());
	}

	@Test
	void testMultixMinus() throws Exception {
		mockMvc.perform(get("/calculator/multiply").param("x", "-9").param("y", "9")).andExpect(content().string("-81"))
				.andExpect(status().isOk());
	}

	@Test
	void testMultiyMinus() throws Exception {
		mockMvc.perform(get("/calculator/multiply").param("x", "9").param("y", "-9")).andExpect(content().string("-81"))
				.andExpect(status().isOk());
	}

	@Test
	void testMultiMinus() throws Exception {
		mockMvc.perform(get("/calculator/multiply").param("x", "-9").param("y", "-9")).andExpect(content().string("81"))
				.andExpect(status().isOk());
	}

	@Test
	void testDivNormal() throws Exception {
		mockMvc.perform(get("/calculator/divide").param("dividend", "9").param("divisor", "9"))
				.andExpect(content().string("1.0"))
				.andExpect(status().isOk());
	}

	@Test
	void testDivsorZero() throws Exception {
		mockMvc.perform(get("/calculator/divide").param("dividend", "9").param("divisor", "0"))
				.andExpect(content().string("除数に0は指定できません。"))
				.andExpect(status().is5xxServerError());
	}

	@Test
	void testDivendZero() throws Exception {
		mockMvc.perform(get("/calculator/divide").param("dividend", "0").param("divisor", "9"))
				.andExpect(content().string("0.0"))
				.andExpect(status().isOk());
	}

	@Test
	void testDivendMinus() throws Exception {
		mockMvc.perform(get("/calculator/divide").param("dividend", "-9").param("divisor", "9"))
				.andExpect(content().string("-1.0"))
				.andExpect(status().isOk());
	}

	@Test
	void testDivsorMinus() throws Exception {
		mockMvc.perform(get("/calculator/divide").param("dividend", "9").param("divisor", "-9"))
				.andExpect(content().string("-1.0"))
				.andExpect(status().isOk());
	}

	@Test
	void testDivMinus() throws Exception {
		mockMvc.perform(get("/calculator/divide").param("dividend", "-9").param("divisor", "-9"))
				.andExpect(content().string("1.0"))
				.andExpect(status().isOk());
	}

	@Test
	void testDivZero() throws Exception {
		mockMvc.perform(get("/calculator/divide").param("dividend", "0").param("divisor", "0"))
				.andExpect(content().string("除数に0は指定できません。"))
				.andExpect(status().is5xxServerError());
	}
}
