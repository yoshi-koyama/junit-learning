package com.example.junitlesson;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void NotFoundエラーになること() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/calculator/dummy").param("x", "2").param("y", "3"))
                .andExpect(status().isNotFound());
    }

    @Test
    void かけ算処理が正しくできること() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/calculator/multiply").param("x", "2").param("y", "3"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("6"));
    }

    @Test
    void divide() {

    }
}