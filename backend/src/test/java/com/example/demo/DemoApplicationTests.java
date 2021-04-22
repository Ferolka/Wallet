package com.example.demo;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void startTest() throws Exception {
        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testCategoty() throws Exception {
        this.mockMvc.perform(get("/category/all"))
                .andExpect(status().isOk());
    }

    @Test
    public void testScheduleTransactions() throws Exception {
        this.mockMvc.perform(get("/scheduletran/all"))
                .andExpect(status().isOk());
    }

    @Test
    public void testUsers() throws Exception {
        this.mockMvc.perform(get("/user/all"))
                .andExpect(status().isOk());
    }

    @Test
    public void testTransaction() throws Exception {
        this.mockMvc.perform(get("/user/all"))
                .andExpect(status().isOk());
    }

    @Test
    public void testUserTransaction() throws Exception {
        this.mockMvc.perform(get("/transaction/getUserTransaction/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getExistUserById() throws Exception {
        this.mockMvc.perform(get("/user/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void getNotExistUserById() throws Exception {
        this.mockMvc.perform(get("/user/999"))
                .andExpect(status().isNotFound());
    }

}
