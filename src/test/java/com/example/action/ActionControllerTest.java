package com.example.action;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.Matchers.hasSize;
import java.util.List;
import static org.hamcrest.Matchers.is;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ActionController.class)
public class ActionControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ActionService service;
    private final ObjectMapper objectMapper = new ObjectMapper();

//    @Test
//    public void testGetAction() throws Exception{
//        //given
//        List<Action> actions = List.of(new Action(1L, "Pierwsza", "Testowa","Tu jest opis bardzo długi we wzorki", "Wszędzie"));
//        when(service.getAll()).thenReturn(actions);
//        //then
//        mockMvc.perform(get("/api/action"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(1)))
//                .andExpect(jsonPath("$[0].id", is(1)))
//                .andExpect(jsonPath("$[0].name", is("Pierwsza")))
//                .andExpect(jsonPath("$[0].organization", is("Testowa")))
//                .andExpect(jsonPath("$[0].description", is("Tu jest opis bardzo długi we wzorki")));
//
//    }

}
