package com.buster.demomapstruct.controller;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.buster.demomapstruct.jira.FixVersionDTO;
import com.buster.demomapstruct.jira.JiraController;
import com.buster.demomapstruct.jira.JiraDTO;
import com.buster.demomapstruct.jira.JiraService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = JiraController.class)
@WithMockUser
public class JiraControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JiraService jiraService;

    List<FixVersionDTO> fixVersionsList = List.of(
            FixVersionDTO.builder()
                    .description("Crear automatizaciones para usuarios del CPCI")
                    .name("T - MVP - Automatizacion")
                    .build());

    JiraDTO mockIssue = JiraDTO.builder().key("CPCI-911")
            .issueTypeName("Spike")
            .statusName("Listo")
            .build();

    @Test
    public void getIssues() throws Exception {
        Mockito.when(jiraService.getIssue()).thenReturn(mockIssue);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/jira/").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "{\"key\": \"CPCI-911\",\"issueTypeName\":\"Spike\",\"estado\":\"Listo\"}";

        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

}
