package com.example.task4;

import com.example.task4.dto.UserPasswordDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WebLayerTest {

    @Autowired
    MockMvc mockMvc;


    @Test
    public void loginTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/auth/login")
                .content("{\n" +
                        "  \"username\": \"artov\",\n" +
                        "  \"password\": \"test\"\n" +
                        "}")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("username","artov").exists());
    }
//
    @Test
    public void shouldNotAllowAccessToUnauthenticatedUsers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/test")).andExpect(status().isForbidden());
    }

    @Test
    public void shouldNotAllowAccessToUnauthenticatedLogin() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/auth/login")
                .content("{\n" +
                        "  \"username\": \"artov\",\n" +
                        "  \"password\": \"test2\"\n" +
                        "}")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isForbidden());
    }

    @Test
    public void shouldNotAllowAccessToUnauthenticatedLoginNOT_ACTIVE_USER() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/auth/login")
                .content("{\n" +
                        "  \"username\": \"titix\",\n" +
                        "  \"password\": \"vale\"\n" +
                        "}")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isForbidden());
    }

}
